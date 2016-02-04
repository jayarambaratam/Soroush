package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public class ee {
    static final eg f1369a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1369a = new ei();
        } else if (i >= 19) {
            f1369a = new eh();
        } else if (i >= 14) {
            f1369a = new ef();
        } else {
            f1369a = new ej();
        }
    }

    public static void m2758a(ViewParent viewParent, View view) {
        f1369a.m2765a(viewParent, view);
    }

    public static void m2759a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
        f1369a.m2766a(viewParent, view, i, i2, i3, i4);
    }

    public static void m2760a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
        f1369a.m2767a(viewParent, view, i, i2, iArr);
    }

    public static boolean m2761a(ViewParent viewParent, View view, float f, float f2) {
        return f1369a.m2768a(viewParent, view, f, f2);
    }

    public static boolean m2762a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f1369a.m2769a(viewParent, view, f, f2, z);
    }

    public static boolean m2763a(ViewParent viewParent, View view, View view2, int i) {
        return f1369a.m2770a(viewParent, view, view2, i);
    }

    public static void m2764b(ViewParent viewParent, View view, View view2, int i) {
        f1369a.m2771b(viewParent, view, view2, i);
    }
}
