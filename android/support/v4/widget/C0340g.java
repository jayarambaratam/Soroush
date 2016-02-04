package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

/* renamed from: android.support.v4.widget.g */
public final class C0340g {
    private static final C0341j f1697a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1697a = new C0344h();
        } else if (i >= 21) {
            f1697a = new C0343k();
        } else {
            f1697a = new C0342i();
        }
    }

    public static Drawable m3416a(CompoundButton compoundButton) {
        return f1697a.m3419a(compoundButton);
    }

    public static void m3417a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f1697a.m3420a(compoundButton, colorStateList);
    }

    public static void m3418a(CompoundButton compoundButton, Mode mode) {
        f1697a.m3421a(compoundButton, mode);
    }
}
