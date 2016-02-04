package android.support.v4.p013c.p014a;

import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.c.a.m */
class C0189m {
    public static void m1597a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable m1598b(Drawable drawable) {
        return !(drawable instanceof C0195s) ? new C0195s(drawable) : drawable;
    }
}
