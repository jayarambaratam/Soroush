package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.widget.m */
class C0346m {
    private static Field f1698a;
    private static boolean f1699b;

    static Drawable m3429a(CompoundButton compoundButton) {
        if (!f1699b) {
            try {
                f1698a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f1698a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", e);
            }
            f1699b = true;
        }
        if (f1698a != null) {
            try {
                return (Drawable) f1698a.get(compoundButton);
            } catch (Throwable e2) {
                Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", e2);
                f1698a = null;
            }
        }
        return null;
    }

    static void m3430a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof cs) {
            ((cs) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    static void m3431a(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof cs) {
            ((cs) compoundButton).setSupportButtonTintMode(mode);
        }
    }
}
