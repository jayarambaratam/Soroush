package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bz implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout f1640a;

    bz(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1640a = swipeRefreshLayout;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f1640a.f1531f) {
            this.f1640a.f1513C.setAlpha(255);
            this.f1640a.f1513C.start();
            if (this.f1640a.f1520J && this.f1640a.f1530e != null) {
                this.f1640a.f1530e.m3354a();
            }
        } else {
            this.f1640a.f1513C.stop();
            this.f1640a.f1550z.setVisibility(8);
            this.f1640a.setColorViewAlpha(255);
            if (this.f1640a.f1547v) {
                this.f1640a.setAnimationProgress(0.0f);
            } else {
                this.f1640a.m3045a(this.f1640a.f1528b - this.f1640a.f1541p, true);
            }
        }
        this.f1640a.f1541p = this.f1640a.f1550z.getTop();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
