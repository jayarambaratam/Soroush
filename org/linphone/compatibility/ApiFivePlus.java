package org.linphone.compatibility;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.media.AudioManager;
import android.net.Uri;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.Data;
import android.support.v4.app.bm;
import android.text.ClipboardManager;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@TargetApi(5)
public class ApiFivePlus {
    public static void copyTextToClipboard(Context context, String str) {
        ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
    }

    public static Notification createInCallNotification(Context context, String str, String str2, int i, PendingIntent pendingIntent) {
        return new bm(context).m1170a(i).m1177a((CharSequence) str).m1182b((CharSequence) str2).m1173a(pendingIntent).m1169a();
    }

    public static Notification createNotification(Context context, String str, String str2, int i, int i2, PendingIntent pendingIntent) {
        return new bm(context).m1171a(i, i2).m1177a((CharSequence) str).m1182b((CharSequence) str2).m1173a(pendingIntent).m1169a();
    }

    public static void deleteSipAddressFromContact(ArrayList<ContentProviderOperation> arrayList, String str, String str2) {
        String[] strArr = new String[]{String.valueOf(str2), str};
        arrayList.add(ContentProviderOperation.newDelete(Data.CONTENT_URI).withSelection("contact_id=? AND mimetype='vnd.android.cursor.item/im' AND data1=?", strArr).build());
    }

    public static List<String> extractContactNumbersAndAddresses(String str, ContentResolver contentResolver) {
        List<String> arrayList = new ArrayList();
        Uri uri = Data.CONTENT_URI;
        String[] strArr = new String[]{"data1"};
        Cursor query = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1"}, "contact_id = " + str, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                arrayList.add(query.getString(query.getColumnIndex("data1")));
            }
            query.close();
        }
        ContentResolver contentResolver2 = contentResolver;
        query = contentResolver2.query(uri, strArr, "contact_id =  ? AND mimetype = 'vnd.android.cursor.item/im' AND lower(data6) = 'sip'", new String[]{str}, null);
        if (query != null) {
            int columnIndex = query.getColumnIndex("data1");
            while (query.moveToNext()) {
                arrayList.add("sip:" + query.getString(columnIndex));
            }
            query.close();
        }
        return arrayList;
    }

    private static String getContactDisplayName(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("display_name"));
    }

    public static InputStream getContactPictureInputStream(ContentResolver contentResolver, String str) {
        return Contacts.openContactPhotoInputStream(contentResolver, getContactPictureUri(str));
    }

    private static Uri getContactPictureUri(String str) {
        return ContentUris.withAppendedId(Contacts.CONTENT_URI, Long.parseLong(str));
    }

    public static Cursor getContactsCursor(ContentResolver contentResolver) {
        return getGeneralContactCursor(contentResolver, "mimetype = 'vnd.android.cursor.item/phone_v2' AND data1 IS NOT NULL" + " OR (mimetype = 'vnd.android.cursor.item/im' AND lower(data6) = 'sip')", true);
    }

    public static int getCursorDisplayNameColumnIndex(Cursor cursor) {
        return cursor.getColumnIndex("display_name");
    }

    public static Cursor getGeneralContactCursor(ContentResolver contentResolver, String str, boolean z) {
        String[] strArr = new String[]{"contact_id", "display_name"};
        String str2 = "display_name IS NOT NULL AND (" + str + ")";
        Cursor query = contentResolver.query(Data.CONTENT_URI, strArr, str2, null, "display_name COLLATE NOCASE ASC");
        if (!z || query == null) {
            return query;
        }
        Cursor matrixCursor = new MatrixCursor(query.getColumnNames());
        Set hashSet = new HashSet();
        while (query.moveToNext()) {
            str2 = query.getString(getCursorDisplayNameColumnIndex(query));
            if (!hashSet.contains(str2)) {
                hashSet.add(str2);
                Object[] objArr = new Object[query.getColumnCount()];
                int columnIndex = query.getColumnIndex("contact_id");
                int columnIndex2 = query.getColumnIndex("display_name");
                objArr[columnIndex] = query.getString(columnIndex);
                objArr[columnIndex2] = query.getString(columnIndex2);
                matrixCursor.addRow(objArr);
            }
        }
        query.close();
        return matrixCursor;
    }

    private static Cursor getSIPContactCursor(ContentResolver contentResolver, String str) {
        return getGeneralContactCursor(contentResolver, "mimetype = 'vnd.android.cursor.item/im AND lower(data6) = 'sip' AND data1 LIKE '" + str + "'", false);
    }

    public static Cursor getSIPContactsCursor(ContentResolver contentResolver) {
        return getGeneralContactCursor(contentResolver, "mimetype = 'vnd.android.cursor.item/im' AND lower(data6) = 'sip'", true);
    }

    public static boolean isPreferenceChecked(Preference preference) {
        return ((CheckBoxPreference) preference).isChecked();
    }

    public static void overridePendingTransition(Activity activity, int i, int i2) {
        activity.overridePendingTransition(i, i2);
    }

    public static Intent prepareAddContactIntent(String str, String str2) {
        Intent intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
        intent.putExtra("name", str);
        intent.putExtra("im_handle", str2);
        intent.putExtra("im_protocol", "sip");
        return intent;
    }

    public static Intent prepareEditContactIntent(int i) {
        Intent intent = new Intent("android.intent.action.EDIT", Contacts.CONTENT_URI);
        intent.setData(ContentUris.withAppendedId(Contacts.CONTENT_URI, (long) i));
        return intent;
    }

    public static Intent prepareEditContactIntentWithSipAddress(int i, String str) {
        Intent intent = new Intent("android.intent.action.EDIT", Contacts.CONTENT_URI);
        intent.setData(ContentUris.withAppendedId(Contacts.CONTENT_URI, (long) i));
        intent.putExtra("im_handle", str);
        intent.putExtra("im_protocol", "sip");
        return intent;
    }

    public static String refreshContactName(ContentResolver contentResolver, String str) {
        Cursor generalContactCursor = getGeneralContactCursor(contentResolver, "contact_id = '" + str + "'", false);
        if (generalContactCursor == null || !generalContactCursor.moveToFirst()) {
            generalContactCursor.close();
            return null;
        }
        String contactDisplayName = getContactDisplayName(generalContactCursor);
        generalContactCursor.close();
        return contactDisplayName;
    }

    public static void removeGlobalLayoutListener(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public static void setAudioManagerInCallMode(AudioManager audioManager) {
    }

    public static void setPreferenceChecked(Preference preference, boolean z) {
        ((CheckBoxPreference) preference).setChecked(z);
    }

    public static void updateSipAddressForContact(ArrayList<ContentProviderOperation> arrayList, String str, String str2, String str3) {
        String[] strArr = new String[]{String.valueOf(str3), str};
        arrayList.add(ContentProviderOperation.newUpdate(Data.CONTENT_URI).withSelection("contact_id=? AND mimetype='vnd.android.cursor.item/im' AND data1=?", strArr).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data1", str2).build());
    }
}
