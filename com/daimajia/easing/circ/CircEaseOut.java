package com.daimajia.easing.circ;

import com.daimajia.easing.BaseEasingMethod;

public class CircEaseOut extends BaseEasingMethod {
    public CircEaseOut(float f) {
        super(f);
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = (f / f4) - 1.0f;
        return Float.valueOf((((float) Math.sqrt((double) (1.0f - (f5 * f5)))) * f3) + f2);
    }
}
