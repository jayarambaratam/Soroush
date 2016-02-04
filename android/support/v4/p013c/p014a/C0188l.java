package android.support.v4.p013c.p014a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v4.c.a.l */
class C0188l {
    public static Drawable m1593a(Drawable drawable) {
        return !(drawable instanceof C0194r) ? new C0194r(drawable) : drawable;
    }

    public static void m1594a(Drawable drawable, int i) {
        if (drawable instanceof C0193q) {
            ((C0193q) drawable).setTint(i);
        }
    }

    public static void m1595a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0193q) {
            ((C0193q) drawable).setTintList(colorStateList);
        }
    }

    public static void m1596a(Drawable drawable, Mode mode) {
        if (drawable instanceof C0193q) {
            ((C0193q) drawable).setTintMode(mode);
        }
    }
}
