package com.daimajia.easing.linear;

import com.daimajia.easing.BaseEasingMethod;

public class Linear extends BaseEasingMethod {
    public Linear(float f) {
        super(f);
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        return Float.valueOf(((f3 * f) / f4) + f2);
    }
}
