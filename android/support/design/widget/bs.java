package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class bs implements AnimationListener {
    final /* synthetic */ br f513a;

    bs(br brVar) {
        this.f513a = brVar;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f513a.f510c == animation) {
            this.f513a.f510c = null;
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
