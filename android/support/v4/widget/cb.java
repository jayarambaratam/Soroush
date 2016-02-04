package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class cb extends Animation {
    final /* synthetic */ SwipeRefreshLayout f1653a;

    cb(SwipeRefreshLayout swipeRefreshLayout) {
        this.f1653a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f1653a.setAnimationProgress(1.0f - f);
    }
}
