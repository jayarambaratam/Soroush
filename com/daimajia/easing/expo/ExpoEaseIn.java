package com.daimajia.easing.expo;

import com.daimajia.easing.BaseEasingMethod;

public class ExpoEaseIn extends BaseEasingMethod {
    public ExpoEaseIn(float f) {
        super(f);
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        if (f != 0.0f) {
            f2 += ((float) Math.pow(2.0d, (double) (10.0f * ((f / f4) - 1.0f)))) * f3;
        }
        return Float.valueOf(f2);
    }
}
