package com.daimajia.easing.back;

import com.daimajia.easing.BaseEasingMethod;

public class BackEaseIn extends BaseEasingMethod {
    private float f3861s;

    public BackEaseIn(float f) {
        super(f);
        this.f3861s = 1.70158f;
    }

    public BackEaseIn(float f, float f2) {
        this(f);
        this.f3861s = f2;
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = f / f4;
        return Float.valueOf((((f5 * (this.f3861s + 1.0f)) - this.f3861s) * ((f3 * f5) * f5)) + f2);
    }
}
