package android.support.design.widget;

import android.support.v4.view.p018b.C0305a;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* renamed from: android.support.design.widget.a */
class C0072a {
    static final Interpolator f428a;
    static final Interpolator f429b;
    static final Interpolator f430c;

    static {
        f428a = new LinearInterpolator();
        f429b = new C0305a();
        f430c = new DecelerateInterpolator();
    }

    static float m476a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    static int m477a(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
