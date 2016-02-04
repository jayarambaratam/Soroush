package com.daimajia.easing.bounce;

import com.daimajia.easing.BaseEasingMethod;

public class BounceEaseOut extends BaseEasingMethod {
    public BounceEaseOut(float f) {
        super(f);
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = f / f4;
        if (f5 < 0.36363637f) {
            return Float.valueOf(((f5 * (7.5625f * f5)) * f3) + f2);
        }
        if (f5 < 0.72727275f) {
            f5 -= 0.54545456f;
            return Float.valueOf((((f5 * (7.5625f * f5)) + 0.75f) * f3) + f2);
        } else if (((double) f5) < 0.9090909090909091d) {
            f5 -= 0.8181818f;
            return Float.valueOf((((f5 * (7.5625f * f5)) + 0.9375f) * f3) + f2);
        } else {
            f5 -= 0.95454544f;
            return Float.valueOf((((f5 * (7.5625f * f5)) + 0.984375f) * f3) + f2);
        }
    }
}
