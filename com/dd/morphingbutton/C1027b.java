package com.dd.morphingbutton;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.LayoutParams;

/* renamed from: com.dd.morphingbutton.b */
class C1027b implements AnimatorUpdateListener {
    final /* synthetic */ C1026a f3875a;

    C1027b(C1026a c1026a) {
        this.f3875a = c1026a;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        LayoutParams layoutParams = this.f3875a.f3874a.f3891n.getLayoutParams();
        layoutParams.height = intValue;
        this.f3875a.f3874a.f3891n.setLayoutParams(layoutParams);
    }
}
