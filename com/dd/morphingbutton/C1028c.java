package com.dd.morphingbutton;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.LayoutParams;

/* renamed from: com.dd.morphingbutton.c */
class C1028c implements AnimatorUpdateListener {
    final /* synthetic */ C1026a f3876a;

    C1028c(C1026a c1026a) {
        this.f3876a = c1026a;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        LayoutParams layoutParams = this.f3876a.f3874a.f3891n.getLayoutParams();
        layoutParams.width = intValue;
        this.f3876a.f3874a.f3891n.setLayoutParams(layoutParams);
    }
}
