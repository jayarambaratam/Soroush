package org.linphone.compatibility;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.preference.Preference;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.linphone.mediastream.Version;

public class Compatibility {
    public static void copyTextToClipboard(Context context, String str) {
        if (Version.sdkAboveOrEqual(11)) {
            ApiElevenPlus.copyTextToClipboard(context, str);
        } else {
            ApiFivePlus.copyTextToClipboard(context, str);
        }
    }

    public static Notification createInCallNotification(Context context, String str, String str2, int i, Bitmap bitmap, String str3, PendingIntent pendingIntent) {
        return Version.sdkAboveOrEqual(16) ? ApiSixteenPlus.createInCallNotification(context, str, str2, i, bitmap, str3, pendingIntent) : Version.sdkAboveOrEqual(11) ? ApiElevenPlus.createInCallNotification(context, str, str2, i, bitmap, str3, pendingIntent) : ApiFivePlus.createInCallNotification(context, str, str2, i, pendingIntent);
    }

    public static Notification createNotification(Context context, String str, String str2, int i, int i2, Bitmap bitmap, PendingIntent pendingIntent) {
        return Version.sdkAboveOrEqual(16) ? ApiSixteenPlus.createNotification(context, str, str2, i, i2, bitmap, pendingIntent) : Version.sdkAboveOrEqual(11) ? ApiElevenPlus.createNotification(context, str, str2, i, i2, bitmap, pendingIntent) : ApiFivePlus.createNotification(context, str, str2, i, i2, pendingIntent);
    }

    public static void deleteSipAddressFromContact(ArrayList<ContentProviderOperation> arrayList, String str, String str2) {
        if (Version.sdkAboveOrEqual(9)) {
            ApiNinePlus.deleteSipAddressFromContact(arrayList, str, str2);
        } else {
            ApiFivePlus.deleteSipAddressFromContact(arrayList, str, str2);
        }
    }

    public static List<String> extractContactNumbersAndAddresses(String str, ContentResolver contentResolver) {
        return Version.sdkAboveOrEqual(9) ? ApiNinePlus.extractContactNumbersAndAddresses(str, contentResolver) : ApiFivePlus.extractContactNumbersAndAddresses(str, contentResolver);
    }

    public static InputStream getContactPictureInputStream(ContentResolver contentResolver, String str) {
        return Version.sdkAboveOrEqual(5) ? ApiFivePlus.getContactPictureInputStream(contentResolver, str) : null;
    }

    public static Cursor getContactsCursor(ContentResolver contentResolver) {
        return Version.sdkAboveOrEqual(9) ? ApiNinePlus.getContactsCursor(contentResolver) : ApiFivePlus.getContactsCursor(contentResolver);
    }

    public static int getCursorDisplayNameColumnIndex(Cursor cursor) {
        return Version.sdkAboveOrEqual(5) ? ApiFivePlus.getCursorDisplayNameColumnIndex(cursor) : -1;
    }

    public static Cursor getSIPContactsCursor(ContentResolver contentResolver) {
        return Version.sdkAboveOrEqual(9) ? ApiNinePlus.getSIPContactsCursor(contentResolver) : ApiFivePlus.getSIPContactsCursor(contentResolver);
    }

    public static CompatibilityScaleGestureDetector getScaleGestureDetector(Context context, CompatibilityScaleGestureListener compatibilityScaleGestureListener) {
        if (!Version.sdkAboveOrEqual(8)) {
            return null;
        }
        CompatibilityScaleGestureDetector compatibilityScaleGestureDetector = new CompatibilityScaleGestureDetector(context);
        compatibilityScaleGestureDetector.setOnScaleListener(compatibilityScaleGestureListener);
        return compatibilityScaleGestureDetector;
    }

    public static void hideNavigationBar(Activity activity) {
        if (Version.sdkAboveOrEqual(14)) {
            ApiFourteenPlus.hideNavigationBar(activity);
        }
    }

    public static boolean isPreferenceChecked(Preference preference) {
        return Version.sdkAboveOrEqual(14) ? ApiFourteenPlus.isPreferenceChecked(preference) : ApiFivePlus.isPreferenceChecked(preference);
    }

    public static void overridePendingTransition(Activity activity, int i, int i2) {
        if (Version.sdkAboveOrEqual(5)) {
            ApiFivePlus.overridePendingTransition(activity, i, i2);
        }
    }

    public static Intent prepareAddContactIntent(String str, String str2) {
        return Version.sdkAboveOrEqual(11) ? ApiElevenPlus.prepareAddContactIntent(str, str2) : ApiFivePlus.prepareAddContactIntent(str, str2);
    }

    public static Intent prepareEditContactIntent(int i) {
        return Version.sdkAboveOrEqual(5) ? ApiFivePlus.prepareEditContactIntent(i) : null;
    }

    public static Intent prepareEditContactIntentWithSipAddress(int i, String str) {
        return Version.sdkAboveOrEqual(11) ? ApiElevenPlus.prepareEditContactIntentWithSipAddress(i, str) : ApiFivePlus.prepareEditContactIntent(i);
    }

    public static String refreshContactName(ContentResolver contentResolver, String str) {
        return Version.sdkAboveOrEqual(5) ? ApiFivePlus.refreshContactName(contentResolver, str) : null;
    }

    public static void removeGlobalLayoutListener(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Version.sdkAboveOrEqual(16)) {
            ApiSixteenPlus.removeGlobalLayoutListener(viewTreeObserver, onGlobalLayoutListener);
        } else {
            ApiFivePlus.removeGlobalLayoutListener(viewTreeObserver, onGlobalLayoutListener);
        }
    }

    public static void setAudioManagerInCallMode(AudioManager audioManager) {
        if (Version.sdkAboveOrEqual(11)) {
            ApiElevenPlus.setAudioManagerInCallMode(audioManager);
        } else {
            ApiFivePlus.setAudioManagerInCallMode(audioManager);
        }
    }

    public static void setPreferenceChecked(Preference preference, boolean z) {
        if (Version.sdkAboveOrEqual(14)) {
            ApiFourteenPlus.setPreferenceChecked(preference, z);
        } else {
            ApiFivePlus.setPreferenceChecked(preference, z);
        }
    }

    public static void showNavigationBar(Activity activity) {
        if (Version.sdkAboveOrEqual(14)) {
            ApiFourteenPlus.showNavigationBar(activity);
        }
    }

    public static void updateSipAddressForContact(ArrayList<ContentProviderOperation> arrayList, String str, String str2, String str3) {
        if (Version.sdkAboveOrEqual(9)) {
            ApiNinePlus.updateSipAddressForContact(arrayList, str, str2, str3);
        } else {
            ApiFivePlus.updateSipAddressForContact(arrayList, str, str2, str3);
        }
    }
}
