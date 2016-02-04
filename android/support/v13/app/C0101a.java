package android.support.v13.app;

import android.app.Fragment;
import android.os.Build.VERSION;

/* renamed from: android.support.v13.app.a */
public class C0101a {
    static final C0102c f688a;

    static {
        if (VERSION.SDK_INT >= 23) {
            f688a = new C0106f();
        } else if (VERSION.SDK_INT >= 15) {
            f688a = new C0105e();
        } else if (VERSION.SDK_INT >= 14) {
            f688a = new C0104d();
        } else {
            f688a = new C0103b();
        }
    }

    public static void m850a(Fragment fragment, boolean z) {
        f688a.m852a(fragment, z);
    }

    public static void m851b(Fragment fragment, boolean z) {
        f688a.m853b(fragment, z);
    }
}
