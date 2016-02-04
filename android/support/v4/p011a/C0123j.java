package android.support.v4.p011a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: android.support.v4.a.j */
class C0123j implements C0118l {
    final Animator f711a;

    public C0123j(Animator animator) {
        this.f711a = animator;
    }

    public void m933a() {
        this.f711a.start();
    }

    public void m934a(long j) {
        this.f711a.setDuration(j);
    }

    public void m935a(C0114b c0114b) {
        this.f711a.addListener(new C0122i(c0114b, this));
    }

    public void m936a(C0116d c0116d) {
        if (this.f711a instanceof ValueAnimator) {
            ((ValueAnimator) this.f711a).addUpdateListener(new C0124k(this, c0116d));
        }
    }

    public void m937a(View view) {
        this.f711a.setTarget(view);
    }

    public void m938b() {
        this.f711a.cancel();
    }

    public float m939c() {
        return ((ValueAnimator) this.f711a).getAnimatedFraction();
    }
}
