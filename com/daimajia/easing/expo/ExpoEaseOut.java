package com.daimajia.easing.expo;

import com.daimajia.easing.BaseEasingMethod;

public class ExpoEaseOut extends BaseEasingMethod {
    public ExpoEaseOut(float f) {
        super(f);
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        return Float.valueOf(f == f4 ? f2 + f3 : (((-((float) Math.pow(2.0d, (double) ((-10.0f * f) / f4)))) + 1.0f) * f3) + f2);
    }
}
