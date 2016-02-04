package com.daimajia.easing.expo;

import com.daimajia.easing.BaseEasingMethod;

public class ExpoEaseInOut extends BaseEasingMethod {
    public ExpoEaseInOut(float f) {
        super(f);
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        if (f == 0.0f) {
            return Float.valueOf(f2);
        }
        if (f == f4) {
            return Float.valueOf(f2 + f3);
        }
        float f5 = f / (f4 / 2.0f);
        if (f5 < 1.0f) {
            return Float.valueOf((((float) Math.pow(2.0d, (double) ((f5 - 1.0f) * 10.0f))) * (f3 / 2.0f)) + f2);
        }
        return Float.valueOf((((-((float) Math.pow(2.0d, (double) ((f5 - 1.0f) * -10.0f)))) + 2.0f) * (f3 / 2.0f)) + f2);
    }
}
