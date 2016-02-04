package android.support.v4.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.p012b.C0125h;

/* renamed from: android.support.v4.app.a */
public class C0126a extends C0125h {
    public static void m1021a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            C0131d.m1241a(activity);
        } else {
            activity.finish();
        }
    }

    public static void m1022b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            C0129b.m1125a(activity);
        } else {
            activity.finish();
        }
    }
}
