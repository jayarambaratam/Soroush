package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class cf extends Animation {
    final /* synthetic */ SwipeRefreshLayout f1659a;

    cf(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1659a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f1659a.m3062c(f);
    }
}
