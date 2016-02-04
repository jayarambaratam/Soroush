package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class cc extends Animation {
    final /* synthetic */ int f1654a;
    final /* synthetic */ int f1655b;
    final /* synthetic */ SwipeRefreshLayout f1656c;

    cc(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.f1656c = swipeRefreshLayout;
        this.f1654a = i;
        this.f1655b = i2;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f1656c.f1513C.setAlpha((int) (((float) this.f1654a) + (((float) (this.f1655b - this.f1654a)) * f)));
    }
}
