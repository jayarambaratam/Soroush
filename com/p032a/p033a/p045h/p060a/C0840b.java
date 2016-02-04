package com.p032a.p033a.p045h.p060a;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/* renamed from: com.a.a.h.a.b */
class C0840b implements C0839j {
    private final int f2955a;

    C0840b(int i) {
        this.f2955a = i;
    }

    public Animation m5135a() {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration((long) this.f2955a);
        return alphaAnimation;
    }
}
