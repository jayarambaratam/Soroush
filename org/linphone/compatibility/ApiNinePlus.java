package org.linphone.compatibility;

import android.annotation.TargetApi;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Data;
import java.util.ArrayList;
import java.util.List;

@TargetApi(9)
public class ApiNinePlus {
    public static void deleteSipAddressFromContact(ArrayList<ContentProviderOperation> arrayList, String str, String str2) {
        String[] strArr = new String[]{String.valueOf(str2), str};
        arrayList.add(ContentProviderOperation.newDelete(Data.CONTENT_URI).withSelection("contact_id=? AND mimetype='vnd.android.cursor.item/sip_address' AND data1=?", strArr).build());
    }

    public static List<String> extractContactNumbersAndAddresses(String str, ContentResolver contentResolver) {
        List<String> arrayList = new ArrayList();
        Uri uri = Data.CONTENT_URI;
        new String[1][0] = "data1";
        Cursor query = contentResolver.query(Phone.CONTENT_URI, new String[]{"data1"}, "contact_id = " + str, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                arrayList.add(query.getString(query.getColumnIndex("data1")));
            }
            query.close();
        }
        ContentResolver contentResolver2 = contentResolver;
        query = contentResolver2.query(uri, new String[]{"data1"}, "contact_id = ? AND mimetype = 'vnd.android.cursor.item/sip_address'", new String[]{str}, null);
        if (query != null) {
            int columnIndex = query.getColumnIndex("data1");
            while (query.moveToNext()) {
                arrayList.add("sip:" + query.getString(columnIndex));
            }
            query.close();
        }
        return arrayList;
    }

    public static Cursor getContactsCursor(ContentResolver contentResolver) {
        return ApiFivePlus.getGeneralContactCursor(contentResolver, "mimetype = 'vnd.android.cursor.item/phone_v2' AND data1 IS NOT NULL" + " OR (mimetype = 'vnd.android.cursor.item/sip_address' AND data1 IS NOT NULL)", true);
    }

    private static Cursor getSIPContactCursor(ContentResolver contentResolver, String str) {
        return ApiFivePlus.getGeneralContactCursor(contentResolver, "mimetype = 'vnd.android.cursor.item/sip_address' AND data1 LIKE '" + str + "'", false);
    }

    public static Cursor getSIPContactsCursor(ContentResolver contentResolver) {
        return ApiFivePlus.getGeneralContactCursor(contentResolver, "mimetype = 'vnd.android.cursor.item/sip_address' AND data1 IS NOT NULL", true);
    }

    public static void updateSipAddressForContact(ArrayList<ContentProviderOperation> arrayList, String str, String str2, String str3) {
        String[] strArr = new String[]{String.valueOf(str3), str};
        arrayList.add(ContentProviderOperation.newUpdate(Data.CONTENT_URI).withSelection("contact_id=? AND mimetype='vnd.android.cursor.item/sip_address' AND data1=?", strArr).withValue("mimetype", "vnd.android.cursor.item/sip_address").withValue("data1", str2).build());
    }
}
