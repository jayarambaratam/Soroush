package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import java.lang.reflect.Field;

class cp {
    private static Field f1347a;
    private static boolean f1348b;
    private static Field f1349c;
    private static boolean f1350d;

    static void m2657a(View view, ColorStateList colorStateList) {
        if (view instanceof bv) {
            ((bv) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static void m2658a(View view, Mode mode) {
        if (view instanceof bv) {
            ((bv) view).setSupportBackgroundTintMode(mode);
        }
    }

    static boolean m2659a(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int m2660b(View view) {
        if (!f1348b) {
            try {
                f1347a = View.class.getDeclaredField("mMinWidth");
                f1347a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f1348b = true;
        }
        if (f1347a != null) {
            try {
                return ((Integer) f1347a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int m2661c(View view) {
        if (!f1350d) {
            try {
                f1349c = View.class.getDeclaredField("mMinHeight");
                f1349c.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f1350d = true;
        }
        if (f1349c != null) {
            try {
                return ((Integer) f1349c.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean m2662d(View view) {
        return view.getWindowToken() != null;
    }
}
