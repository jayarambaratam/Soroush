package android.support.v4.app;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ac implements AnimationListener {
    private AnimationListener f801a;
    private boolean f802b;
    private View f803c;

    public ac(View view, Animation animation) {
        this.f801a = null;
        this.f802b = false;
        this.f803c = null;
        if (view != null && animation != null) {
            this.f803c = view;
        }
    }

    public ac(View view, Animation animation, AnimationListener animationListener) {
        this.f801a = null;
        this.f802b = false;
        this.f803c = null;
        if (view != null && animation != null) {
            this.f801a = animationListener;
            this.f803c = view;
        }
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f803c != null && this.f802b) {
            this.f803c.post(new ae(this));
        }
        if (this.f801a != null) {
            this.f801a.onAnimationEnd(animation);
        }
    }

    public void onAnimationRepeat(Animation animation) {
        if (this.f801a != null) {
            this.f801a.onAnimationRepeat(animation);
        }
    }

    public void onAnimationStart(Animation animation) {
        if (this.f803c != null) {
            this.f802b = C0153z.m1393a(this.f803c, animation);
            if (this.f802b) {
                this.f803c.post(new ad(this));
            }
        }
        if (this.f801a != null) {
            this.f801a.onAnimationStart(animation);
        }
    }
}
