package com.daimajia.easing.back;

import com.daimajia.easing.BaseEasingMethod;

public class BackEaseOut extends BaseEasingMethod {
    private float f3863s;

    public BackEaseOut(float f) {
        super(f);
        this.f3863s = 1.70158f;
    }

    public BackEaseOut(float f, float f2) {
        this(f);
        this.f3863s = f2;
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        float f5 = (f / f4) - 1.0f;
        return Float.valueOf((((((f5 * (this.f3863s + 1.0f)) + this.f3863s) * (f5 * f5)) + 1.0f) * f3) + f2);
    }
}
