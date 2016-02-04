package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription.Builder;
import android.net.Uri;
import android.os.Bundle;

/* renamed from: android.support.v4.media.h */
class C0248h {
    public static Object m1769a() {
        return new Builder();
    }

    public static Object m1770a(Object obj) {
        return ((Builder) obj).build();
    }

    public static void m1771a(Object obj, Bitmap bitmap) {
        ((Builder) obj).setIconBitmap(bitmap);
    }

    public static void m1772a(Object obj, Uri uri) {
        ((Builder) obj).setIconUri(uri);
    }

    public static void m1773a(Object obj, Bundle bundle) {
        ((Builder) obj).setExtras(bundle);
    }

    public static void m1774a(Object obj, CharSequence charSequence) {
        ((Builder) obj).setTitle(charSequence);
    }

    public static void m1775a(Object obj, String str) {
        ((Builder) obj).setMediaId(str);
    }

    public static void m1776b(Object obj, CharSequence charSequence) {
        ((Builder) obj).setSubtitle(charSequence);
    }

    public static void m1777c(Object obj, CharSequence charSequence) {
        ((Builder) obj).setDescription(charSequence);
    }
}
