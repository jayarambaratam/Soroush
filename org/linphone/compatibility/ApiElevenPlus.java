package org.linphone.compatibility;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.provider.ContactsContract.Contacts;
import java.util.ArrayList;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;

@TargetApi(11)
public class ApiElevenPlus {
    public static void copyTextToClipboard(Context context, String str) {
        ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Message", str));
    }

    public static Notification createInCallNotification(Context context, String str, String str2, int i, Bitmap bitmap, String str3, PendingIntent pendingIntent) {
        return new Builder(context).setContentTitle(str3).setContentText(str2).setSmallIcon(i).setAutoCancel(false).setContentIntent(pendingIntent).setWhen(System.currentTimeMillis()).setLargeIcon(bitmap).getNotification();
    }

    public static Notification createNotification(Context context, String str, String str2, int i, int i2, Bitmap bitmap, PendingIntent pendingIntent) {
        Notification notification = bitmap != null ? new Builder(context).setContentTitle(str).setContentText(str2).setSmallIcon(i, i2).setLargeIcon(bitmap).setContentIntent(pendingIntent).setWhen(System.currentTimeMillis()).getNotification() : new Builder(context).setContentTitle(str).setContentText(str2).setSmallIcon(i, i2).setContentIntent(pendingIntent).setWhen(System.currentTimeMillis()).getNotification();
        notification.flags |= 2;
        return notification;
    }

    public static Intent prepareAddContactIntent(String str, String str2) {
        Intent intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
        intent.putExtra("name", str);
        if (str2 != null && str2.startsWith("sip:")) {
            str2 = str2.substring(4);
        }
        ArrayList arrayList = new ArrayList();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/sip_address");
        contentValues.put("data1", str2);
        arrayList.add(contentValues);
        intent.putParcelableArrayListExtra(DataPacketExtension.ELEMENT, arrayList);
        return intent;
    }

    public static Intent prepareEditContactIntentWithSipAddress(int i, String str) {
        Intent intent = new Intent("android.intent.action.EDIT", Contacts.CONTENT_URI);
        intent.setData(ContentUris.withAppendedId(Contacts.CONTENT_URI, (long) i));
        ArrayList arrayList = new ArrayList();
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/sip_address");
        contentValues.put("data1", str);
        arrayList.add(contentValues);
        arrayList.add(contentValues);
        intent.putParcelableArrayListExtra(DataPacketExtension.ELEMENT, arrayList);
        return intent;
    }

    public static void setAudioManagerInCallMode(AudioManager audioManager) {
        audioManager.setMode(3);
    }
}
