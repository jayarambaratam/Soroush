package android.support.v4.view;

import android.graphics.Rect;
import android.view.Gravity;

/* renamed from: android.support.v4.view.z */
class C0331z {
    public static int m2949a(int i, int i2) {
        return Gravity.getAbsoluteGravity(i, i2);
    }

    public static void m2950a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        Gravity.apply(i, i2, i3, rect, rect2, i4);
    }
}
