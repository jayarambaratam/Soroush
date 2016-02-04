package org.linphone;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts.People;
import android.provider.Contacts.Phones;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.PhoneLookup;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;
import org.linphone.core.LinphoneAddress;
import org.linphone.mediastream.Version;

public final class ContactHelper {
    private LinphoneAddress address;
    private String displayName;
    private String domain;
    private Uri foundPhotoUri;
    private ContentResolver resolver;
    private String username;

    class ContactHelperNew {
        private ContactHelperNew() {
        }

        private boolean checkPhotosUris(ContentResolver contentResolver, Cursor cursor, String str, String str2) {
            if (cursor == null) {
                return false;
            }
            while (cursor.moveToNext()) {
                Uri withAppendedPath = Uri.withAppendedPath(ContentUris.withAppendedId(Contacts.CONTENT_URI, cursor.getLong(cursor.getColumnIndex(str))), "photo");
                if (withAppendedPath == null) {
                    return false;
                }
                Cursor query = contentResolver.query(withAppendedPath, new String[]{"data15"}, null, null, null);
                String string = cursor.getString(cursor.getColumnIndex(str2));
                if (ContactHelper.testPhotoUriAndCloseCursor(query)) {
                    ContactHelper.this.foundPhotoUri = withAppendedPath;
                    ContactHelper.this.displayName = string;
                    return true;
                } else if (string != null) {
                    ContactHelper.this.foundPhotoUri = null;
                    ContactHelper.this.displayName = string;
                    return true;
                }
            }
            cursor.close();
            return false;
        }

        private boolean queryNewContactAPI() {
            Cursor query;
            String str = ContactHelper.this.username + "@" + ContactHelper.this.domain;
            Uri uri = Data.CONTENT_URI;
            String[] strArr = new String[]{"contact_id", "display_name"};
            if (Version.sdkAboveOrEqual(9)) {
                query = ContactHelper.this.resolver.query(uri, strArr, "data1 = ? AND mimetype = 'vnd.android.cursor.item/sip_address'", new String[]{str}, null);
                boolean checkPhotosUris = checkPhotosUris(ContactHelper.this.resolver, query, "contact_id", "display_name");
                query.close();
                if (checkPhotosUris) {
                    return true;
                }
            }
            query = ContactHelper.this.resolver.query(uri, strArr, "data1 =  ? AND mimetype = 'vnd.android.cursor.item/im' AND lower(data6) = 'sip'", new String[]{str}, null);
            boolean checkPhotosUris2 = checkPhotosUris(ContactHelper.this.resolver, query, "contact_id", "display_name");
            query.close();
            if (checkPhotosUris2) {
                return true;
            }
            Object strippedReversed = PhoneNumberUtils.getStrippedReversed(ContactHelper.this.username);
            if (TextUtils.isEmpty(strippedReversed)) {
                return false;
            }
            Cursor query2 = ContactHelper.this.resolver.query(Uri.withAppendedPath(PhoneLookup.CONTENT_FILTER_URI, Uri.encode(ContactHelper.this.username)), new String[]{"_id", "number", "display_name"}, null, null, null);
            while (query2 != null && query2.moveToNext()) {
                long j = query2.getLong(query2.getColumnIndex("_id"));
                if (strippedReversed.equals(PhoneNumberUtils.getStrippedReversed(query2.getString(query2.getColumnIndex("number"))))) {
                    Uri withAppendedPath = Uri.withAppendedPath(ContentUris.withAppendedId(Contacts.CONTENT_URI, j), "photo");
                    boolean testPhotoUriAndCloseCursor = ContactHelper.testPhotoUriAndCloseCursor(ContactHelper.this.resolver.query(withAppendedPath, new String[]{"data15"}, null, null, null));
                    ContactHelper.this.displayName = query2.getString(query2.getColumnIndex("display_name"));
                    if (testPhotoUriAndCloseCursor) {
                        ContactHelper.this.foundPhotoUri = withAppendedPath;
                    } else {
                        ContactHelper.this.foundPhotoUri = null;
                    }
                    query2.close();
                    return true;
                }
            }
            query2.close();
            return false;
        }
    }

    public ContactHelper(LinphoneAddress linphoneAddress, ContentResolver contentResolver) {
        this.username = linphoneAddress.getUserName();
        this.domain = linphoneAddress.getDomain();
        this.resolver = contentResolver;
        this.address = linphoneAddress;
    }

    public static Intent prepareEditContactIntent(int i) {
        Intent intent = new Intent("android.intent.action.EDIT", Contacts.CONTENT_URI);
        intent.setData(ContentUris.withAppendedId(Contacts.CONTENT_URI, (long) i));
        return intent;
    }

    private boolean queryOldContactAPI() {
        Object strippedReversed = PhoneNumberUtils.getStrippedReversed(this.username);
        if (TextUtils.isEmpty(strippedReversed)) {
            return false;
        }
        Cursor query = this.resolver.query(Phones.CONTENT_URI, new String[]{"person", "display_name"}, "number_key=" + strippedReversed, null, null);
        if (query == null) {
            return false;
        }
        while (query.moveToNext()) {
            Uri withAppendedId = ContentUris.withAppendedId(People.CONTENT_URI, query.getLong(query.getColumnIndex("person")));
            if (testPhotoUri(this.resolver, Uri.withAppendedPath(withAppendedId, "photo"), DataPacketExtension.ELEMENT)) {
                this.displayName = query.getString(query.getColumnIndex("display_name"));
                this.foundPhotoUri = withAppendedId;
                query.close();
                return true;
            }
        }
        query.close();
        return false;
    }

    public static boolean testPhotoUri(ContentResolver contentResolver, Uri uri, String str) {
        return testPhotoUriAndCloseCursor(contentResolver.query(uri, new String[]{str}, null, null, null));
    }

    public static boolean testPhotoUri(Cursor cursor) {
        return (cursor == null || !cursor.moveToNext() || cursor.getBlob(0) == null) ? false : true;
    }

    public static boolean testPhotoUriAndCloseCursor(Cursor cursor) {
        boolean testPhotoUri = testPhotoUri(cursor);
        if (cursor != null) {
            cursor.close();
        }
        return testPhotoUri;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Uri getUri() {
        return this.foundPhotoUri;
    }

    public boolean query() {
        boolean access$100 = Version.sdkAboveOrEqual(5) ? new ContactHelperNew().queryNewContactAPI() : queryOldContactAPI();
        if (access$100 && !TextUtils.isEmpty(this.displayName)) {
            this.address.setDisplayName(this.displayName);
        }
        return access$100;
    }
}
