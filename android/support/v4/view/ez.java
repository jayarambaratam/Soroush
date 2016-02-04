package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class ez extends AnimatorListenerAdapter {
    final /* synthetic */ fc f1383a;
    final /* synthetic */ View f1384b;

    ez(fc fcVar, View view) {
        this.f1383a = fcVar;
        this.f1384b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f1383a.onAnimationCancel(this.f1384b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f1383a.onAnimationEnd(this.f1384b);
    }

    public void onAnimationStart(Animator animator) {
        this.f1383a.onAnimationStart(this.f1384b);
    }
}
