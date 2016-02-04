package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class az implements AnimationListener {
    final /* synthetic */ int f486a;
    final /* synthetic */ Snackbar f487b;

    az(Snackbar snackbar, int i) {
        this.f487b = snackbar;
        this.f486a = i;
    }

    public void onAnimationEnd(Animation animation) {
        this.f487b.m389e(this.f486a);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
