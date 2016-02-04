package com.daimajia.easing.quad;

import com.daimajia.easing.BaseEasingMethod;

public class QuadEaseInOut extends BaseEasingMethod {
    public QuadEaseInOut(float f) {
        super(f);
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = f / (f4 / 2.0f);
        if (f5 < 1.0f) {
            return Float.valueOf((f5 * ((f3 / 2.0f) * f5)) + f2);
        }
        f5 -= 1.0f;
        return Float.valueOf((((f5 * (f5 - 2.0f)) - 1.0f) * ((-f3) / 2.0f)) + f2);
    }
}
