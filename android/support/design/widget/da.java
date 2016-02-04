package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class da implements AnimatorUpdateListener {
    final /* synthetic */ cw f584a;
    final /* synthetic */ cz f585b;

    da(cz czVar, cw cwVar) {
        this.f585b = czVar;
        this.f584a = cwVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f584a.m691a();
    }
}
