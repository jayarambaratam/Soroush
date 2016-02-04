package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class aj extends AnimatorListenerAdapter {
    final /* synthetic */ an f459a;
    final /* synthetic */ ai f460b;

    aj(ai aiVar, an anVar) {
        this.f460b = aiVar;
        this.f459a = anVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f460b.f458j = false;
    }

    public void onAnimationEnd(Animator animator) {
        this.f460b.f458j = false;
        this.f460b.h.setVisibility(8);
        if (this.f459a != null) {
            this.f459a.m530b();
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f460b.f458j = true;
        this.f460b.h.setVisibility(0);
    }
}
