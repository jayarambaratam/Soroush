package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* renamed from: android.support.v4.media.g */
class C0247g {
    public static Object m1760a(Parcel parcel) {
        return MediaDescription.CREATOR.createFromParcel(parcel);
    }

    public static String m1761a(Object obj) {
        return ((MediaDescription) obj).getMediaId();
    }

    public static void m1762a(Object obj, Parcel parcel, int i) {
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }

    public static CharSequence m1763b(Object obj) {
        return ((MediaDescription) obj).getTitle();
    }

    public static CharSequence m1764c(Object obj) {
        return ((MediaDescription) obj).getSubtitle();
    }

    public static CharSequence m1765d(Object obj) {
        return ((MediaDescription) obj).getDescription();
    }

    public static Bitmap m1766e(Object obj) {
        return ((MediaDescription) obj).getIconBitmap();
    }

    public static Uri m1767f(Object obj) {
        return ((MediaDescription) obj).getIconUri();
    }

    public static Bundle m1768g(Object obj) {
        return ((MediaDescription) obj).getExtras();
    }
}
