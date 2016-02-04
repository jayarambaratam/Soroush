package android.support.v4.p011a;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* renamed from: android.support.v4.a.k */
class C0124k implements AnimatorUpdateListener {
    final /* synthetic */ C0116d f712a;
    final /* synthetic */ C0123j f713b;

    C0124k(C0123j c0123j, C0116d c0116d) {
        this.f713b = c0123j;
        this.f712a = c0116d;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f712a.onAnimationUpdate(this.f713b);
    }
}
