package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bh implements AnimationListener {
    final /* synthetic */ Snackbar f496a;

    bh(Snackbar snackbar) {
        this.f496a = snackbar;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f496a.f374f != null) {
            this.f496a.f374f.m576a(this.f496a);
        }
        bn.m578a().m589b(this.f496a.f375g);
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
