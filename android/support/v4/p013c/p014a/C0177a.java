package android.support.v4.p013c.p014a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.c.a.a */
public class C0177a {
    static final C0178c f1092a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1092a = new C0185i();
        } else if (i >= 22) {
            f1092a = new C0184h();
        } else if (i >= 21) {
            f1092a = new C0183g();
        } else if (i >= 19) {
            f1092a = new C0182f();
        } else if (i >= 17) {
            f1092a = new C0181e();
        } else if (i >= 11) {
            f1092a = new C0180d();
        } else {
            f1092a = new C0179b();
        }
    }

    public static void m1540a(Drawable drawable) {
        f1092a.m1552a(drawable);
    }

    public static void m1541a(Drawable drawable, float f, float f2) {
        f1092a.m1553a(drawable, f, f2);
    }

    public static void m1542a(Drawable drawable, int i) {
        f1092a.m1554a(drawable, i);
    }

    public static void m1543a(Drawable drawable, int i, int i2, int i3, int i4) {
        f1092a.m1555a(drawable, i, i2, i3, i4);
    }

    public static void m1544a(Drawable drawable, ColorStateList colorStateList) {
        f1092a.m1556a(drawable, colorStateList);
    }

    public static void m1545a(Drawable drawable, Mode mode) {
        f1092a.m1557a(drawable, mode);
    }

    public static void m1546a(Drawable drawable, boolean z) {
        f1092a.m1558a(drawable, z);
    }

    public static void m1547b(Drawable drawable, int i) {
        f1092a.m1559b(drawable, i);
    }

    public static boolean m1548b(Drawable drawable) {
        return f1092a.m1560b(drawable);
    }

    public static Drawable m1549c(Drawable drawable) {
        return f1092a.m1561c(drawable);
    }

    public static <T extends Drawable> T m1550d(Drawable drawable) {
        return drawable instanceof C0193q ? ((C0193q) drawable).m1610a() : drawable;
    }

    public static int m1551e(Drawable drawable) {
        return f1092a.m1562d(drawable);
    }
}
