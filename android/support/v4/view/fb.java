package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class fb implements AnimatorUpdateListener {
    final /* synthetic */ fe f1387a;
    final /* synthetic */ View f1388b;

    fb(fe feVar, View view) {
        this.f1387a = feVar;
        this.f1388b = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1387a.m2896a(this.f1388b);
    }
}
