package com.p032a.p033a.p037d.p046c;

import android.net.Uri;

/* renamed from: com.a.a.d.c.a */
final class C0692a {
    private static final int f2706a;

    static {
        f2706a = "file:///android_asset/".length();
    }

    public static boolean m4725a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    public static String m4726b(Uri uri) {
        return uri.toString().substring(f2706a);
    }
}
