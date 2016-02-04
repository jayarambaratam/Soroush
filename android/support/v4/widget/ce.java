package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class ce extends Animation {
    final /* synthetic */ SwipeRefreshLayout f1658a;

    ce(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1658a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f1658a.m3045a((((int) (((float) ((!this.f1658a.f1523M ? (int) (this.f1658a.f1519I - ((float) Math.abs(this.f1658a.f1528b))) : (int) this.f1658a.f1519I) - this.f1658a.f1527a)) * f)) + this.f1658a.f1527a) - this.f1658a.f1550z.getTop(), false);
        this.f1658a.f1513C.m3194a(1.0f - f);
    }
}
