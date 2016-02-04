package com.daimajia.easing.elastic;

import com.daimajia.easing.BaseEasingMethod;

public class ElasticEaseInOut extends BaseEasingMethod {
    public ElasticEaseInOut(float f) {
        super(f);
    }

    public Float calculate(float f, float f2, float f3, float f4) {
        if (f == 0.0f) {
            return Float.valueOf(f2);
        }
        float f5 = f / (f4 / 2.0f);
        if (f5 == 2.0f) {
            return Float.valueOf(f2 + f3);
        }
        float f6 = 0.45000002f * f4;
        float f7 = f6 / 4.0f;
        if (f5 < 1.0f) {
            f5 -= 1.0f;
            return Float.valueOf(((((float) Math.sin((double) ((((f5 * f4) - f7) * 6.2831855f) / f6))) * (((float) Math.pow(2.0d, (double) (10.0f * f5))) * f3)) * -0.5f) + f2);
        }
        f5 -= 1.0f;
        return Float.valueOf((((((float) Math.sin((double) ((((f5 * f4) - f7) * 6.2831855f) / f6))) * (((float) Math.pow(2.0d, (double) (-10.0f * f5))) * f3)) * 0.5f) + f3) + f2);
    }
}
