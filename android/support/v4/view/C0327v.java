package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.view.v */
public class C0327v {
    static final C0328w f1419a;

    static {
        if (VERSION.SDK_INT >= 17) {
            f1419a = new C0330y();
        } else {
            f1419a = new C0329x();
        }
    }

    public static int m2941a(int i, int i2) {
        return f1419a.m2943a(i, i2);
    }

    public static void m2942a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        f1419a.m2944a(i, i2, i3, rect, rect2, i4);
    }
}
