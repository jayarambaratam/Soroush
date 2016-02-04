package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

class bl implements bk {
    bl() {
    }

    public Object m3292a(Context context, Interpolator interpolator) {
        return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
    }

    public void m3293a(Object obj, int i, int i2, int i3, int i4) {
        ((Scroller) obj).startScroll(i, i2, i3, i4);
    }

    public void m3294a(Object obj, int i, int i2, int i3, int i4, int i5) {
        ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
    }

    public void m3295a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void m3296a(Object obj, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        ((Scroller) obj).fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public boolean m3297a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    public boolean m3298a(Object obj, int i, int i2, int i3, int i4, int i5, int i6) {
        return false;
    }

    public int m3299b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    public int m3300c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    public float m3301d(Object obj) {
        return 0.0f;
    }

    public boolean m3302e(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    public void m3303f(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    public int m3304g(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    public int m3305h(Object obj) {
        return ((Scroller) obj).getFinalY();
    }
}
