package android.support.v4.p015e;

import android.os.Build.VERSION;
import java.util.Locale;

/* renamed from: android.support.v4.e.a */
public class C0201a {
    private static final C0202b f1104a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1104a = new C0205e();
        } else if (i >= 14) {
            f1104a = new C0204d();
        } else {
            f1104a = new C0203c();
        }
    }

    public static String m1630a(Locale locale) {
        return f1104a.m1631a(locale);
    }
}
