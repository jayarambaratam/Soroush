package android.support.v4.p013c.p014a;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.c.a.o */
class C0191o {
    public static void m1601a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean m1602a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable m1603b(Drawable drawable) {
        return !(drawable instanceof C0196t) ? new C0196t(drawable) : drawable;
    }
}
