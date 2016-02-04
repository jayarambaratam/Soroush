package android.support.v4.p013c.p014a;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.c.a.n */
class C0190n {
    private static Method f1093a;
    private static boolean f1094b;
    private static Method f1095c;
    private static boolean f1096d;

    public static int m1599a(Drawable drawable) {
        if (!f1096d) {
            try {
                f1095c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f1095c.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            f1096d = true;
        }
        if (f1095c != null) {
            try {
                return ((Integer) f1095c.invoke(drawable, new Object[0])).intValue();
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                f1095c = null;
            }
        }
        return -1;
    }

    public static void m1600a(Drawable drawable, int i) {
        if (!f1094b) {
            try {
                f1093a = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                f1093a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve setLayoutDirection(int) method", e);
            }
            f1094b = true;
        }
        if (f1093a != null) {
            try {
                f1093a.invoke(drawable, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                f1093a = null;
            }
        }
    }
}
