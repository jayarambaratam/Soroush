package android.support.v4.p013c.p014a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;

/* renamed from: android.support.v4.c.a.p */
class C0192p {
    public static Drawable m1604a(Drawable drawable) {
        return ((drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer)) ? new C0197u(drawable) : drawable;
    }

    public static void m1605a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void m1606a(Drawable drawable, int i) {
        if (drawable instanceof C0197u) {
            C0188l.m1594a(drawable, i);
        } else {
            drawable.setTint(i);
        }
    }

    public static void m1607a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void m1608a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0197u) {
            C0188l.m1595a(drawable, colorStateList);
        } else {
            drawable.setTintList(colorStateList);
        }
    }

    public static void m1609a(Drawable drawable, Mode mode) {
        if (drawable instanceof C0197u) {
            C0188l.m1596a(drawable, mode);
        } else {
            drawable.setTintMode(mode);
        }
    }
}
