package com.daimajia.easing.back;

import com.daimajia.easing.BaseEasingMethod;

public class BackEaseInOut extends BaseEasingMethod {
    private float f3862s;

    public BackEaseInOut(float f) {
        super(f);
        this.f3862s = 1.70158f;
    }

    public BackEaseInOut(float f, float f2) {
        this(f);
        this.f3862s = f2;
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = f / (f4 / 2.0f);
        if (f5 < 1.0f) {
            float f6 = f3 / 2.0f;
            float f7 = f5 * f5;
            float f8 = (float) (((double) this.f3862s) * 1.525d);
            this.f3862s = f8;
            return Float.valueOf(((((f5 * (f8 + 1.0f)) - this.f3862s) * f7) * f6) + f2);
        }
        f6 = f3 / 2.0f;
        f5 -= 2.0f;
        f7 = f5 * f5;
        f8 = (float) (((double) this.f3862s) * 1.525d);
        this.f3862s = f8;
        return Float.valueOf((((((f5 * (f8 + 1.0f)) + this.f3862s) * f7) + 2.0f) * f6) + f2);
    }
}
