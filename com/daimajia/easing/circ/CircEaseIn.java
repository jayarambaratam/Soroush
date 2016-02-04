package com.daimajia.easing.circ;

import com.daimajia.easing.BaseEasingMethod;

public class CircEaseIn extends BaseEasingMethod {
    public CircEaseIn(float f) {
        super(f);
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = f / f4;
        return Float.valueOf(((-f3) * (((float) Math.sqrt((double) (1.0f - (f5 * f5)))) - 1.0f)) + f2);
    }
}
