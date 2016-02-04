package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class cg extends Animation {
    final /* synthetic */ SwipeRefreshLayout f1660a;

    cg(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1660a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f1660a.setAnimationProgress(this.f1660a.f1512B + ((-this.f1660a.f1512B) * f));
        this.f1660a.m3062c(f);
    }
}
