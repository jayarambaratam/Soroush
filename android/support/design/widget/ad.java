package android.support.design.widget;

import android.view.animation.Animation;

class ad extends C0073b {
    final /* synthetic */ an f449a;
    final /* synthetic */ ac f450b;

    ad(ac acVar, an anVar) {
        this.f450b = acVar;
        this.f449a = anVar;
    }

    public void onAnimationEnd(Animation animation) {
        this.f450b.f448n = false;
        this.f450b.h.setVisibility(8);
        if (this.f449a != null) {
            this.f449a.m530b();
        }
    }

    public void onAnimationStart(Animation animation) {
        this.f450b.f448n = true;
    }
}
