package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

class be {
    private static Field f1626a;

    static {
        try {
            f1626a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f1626a.setAccessible(true);
        } catch (Throwable e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    static void m3256a(PopupWindow popupWindow, boolean z) {
        if (f1626a != null) {
            try {
                f1626a.set(popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }

    static boolean m3257a(PopupWindow popupWindow) {
        if (f1626a != null) {
            try {
                return ((Boolean) f1626a.get(popupWindow)).booleanValue();
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", e);
            }
        }
        return false;
    }
}
