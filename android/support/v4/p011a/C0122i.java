package android.support.v4.p011a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* renamed from: android.support.v4.a.i */
class C0122i implements AnimatorListener {
    final C0114b f709a;
    final C0118l f710b;

    public C0122i(C0114b c0114b, C0118l c0118l) {
        this.f709a = c0114b;
        this.f710b = c0118l;
    }

    public void onAnimationCancel(Animator animator) {
        this.f709a.onAnimationCancel(this.f710b);
    }

    public void onAnimationEnd(Animator animator) {
        this.f709a.onAnimationEnd(this.f710b);
    }

    public void onAnimationRepeat(Animator animator) {
        this.f709a.onAnimationRepeat(this.f710b);
    }

    public void onAnimationStart(Animator animator) {
        this.f709a.onAnimationStart(this.f710b);
    }
}
