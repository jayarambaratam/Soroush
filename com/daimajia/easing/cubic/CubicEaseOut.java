package com.daimajia.easing.cubic;

import com.daimajia.easing.BaseEasingMethod;

public class CubicEaseOut extends BaseEasingMethod {
    public CubicEaseOut(float f) {
        super(f);
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = (f / f4) - 1.0f;
        return Float.valueOf((((f5 * (f5 * f5)) + 1.0f) * f3) + f2);
    }
}
