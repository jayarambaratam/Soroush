package mobi.mmdt.ott.view.main.basenavigation.viewpager;

import android.view.animation.Interpolator;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.viewpager.d */
final class C2329d implements Interpolator {
    C2329d() {
    }

    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
    }
}
