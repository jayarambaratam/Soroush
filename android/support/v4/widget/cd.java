package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class cd implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout f1657a;

    cd(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1657a = swipeRefreshLayout;
    }

    public void onAnimationEnd(Animation animation) {
        if (!this.f1657a.f1547v) {
            this.f1657a.m3061b(null);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
