package android.support.v4.view.p018b;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.b.b */
abstract class C0304b implements Interpolator {
    private final float[] f1330a;
    private final float f1331b;

    public C0304b(float[] fArr) {
        this.f1330a = fArr;
        this.f1331b = 1.0f / ((float) (this.f1330a.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f1330a.length - 1)) * f), this.f1330a.length - 2);
        float f2 = (f - (((float) min) * this.f1331b)) / this.f1331b;
        return ((this.f1330a[min + 1] - this.f1330a[min]) * f2) + this.f1330a[min];
    }
}
