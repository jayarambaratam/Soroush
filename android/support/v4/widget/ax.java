package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

public class ax {
    static final bd f1625a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1625a = new az();
        } else if (i >= 21) {
            f1625a = new ay();
        } else if (i >= 19) {
            f1625a = new bc();
        } else if (i >= 9) {
            f1625a = new bb();
        } else {
            f1625a = new ba();
        }
    }

    public static void m3237a(PopupWindow popupWindow, int i) {
        f1625a.m3241a(popupWindow, i);
    }

    public static void m3238a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1625a.m3242a(popupWindow, view, i, i2, i3);
    }

    public static void m3239a(PopupWindow popupWindow, boolean z) {
        f1625a.m3243a(popupWindow, z);
    }

    public static boolean m3240a(PopupWindow popupWindow) {
        return f1625a.m3244a(popupWindow);
    }
}
