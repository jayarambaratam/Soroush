package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

class cw {
    public static int m2707a(View view) {
        return view.getLayoutDirection();
    }

    public static void m2708a(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static void m2709a(View view, Paint paint) {
        view.setLayerPaint(paint);
    }

    public static int m2710b(View view) {
        return view.getPaddingStart();
    }

    public static int m2711c(View view) {
        return view.getPaddingEnd();
    }

    public static int m2712d(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static boolean m2713e(View view) {
        return view.isPaddingRelative();
    }
}
