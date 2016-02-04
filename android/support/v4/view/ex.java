package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

final class ex extends AnimatorListenerAdapter {
    final /* synthetic */ fc f1381a;
    final /* synthetic */ View f1382b;

    ex(fc fcVar, View view) {
        this.f1381a = fcVar;
        this.f1382b = view;
    }

    public void onAnimationCancel(Animator animator) {
        this.f1381a.onAnimationCancel(this.f1382b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f1381a.onAnimationEnd(this.f1382b);
    }

    public void onAnimationStart(Animator animator) {
        this.f1381a.onAnimationStart(this.f1382b);
    }
}
