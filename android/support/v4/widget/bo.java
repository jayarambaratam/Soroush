package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

class bo {
    public static Object m3321a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public static void m3322a(Object obj, int i, int i2, int i3, int i4) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4);
    }

    public static void m3323a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((OverScroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public static void m3324a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public static void m3325a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((OverScroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public static boolean m3326a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public static boolean m3327a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
        return ((OverScroller) obj).springBack(i, i2, i3, i4, i5, i6);
    }

    public static int m3328b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public static int m3329c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public static boolean m3330d(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public static void m3331e(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public static int m3332f(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public static int m3333g(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
