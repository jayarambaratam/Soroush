package mobi.mmdt.ott.view.components.imageslider.Tricks;

import android.view.animation.Interpolator;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.Tricks.d */
final class C1826d implements Interpolator {
    C1826d() {
    }

    public float getInterpolation(float f) {
        float f2 = f - 1.0f;
        return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
    }
}
