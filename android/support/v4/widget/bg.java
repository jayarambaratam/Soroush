package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class bg {
    private static Method f1627a;
    private static boolean f1628b;

    static void m3261a(PopupWindow popupWindow, int i) {
        if (!f1628b) {
            try {
                f1627a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f1627a.setAccessible(true);
            } catch (Exception e) {
            }
            f1628b = true;
        }
        if (f1627a != null) {
            try {
                f1627a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }
}
