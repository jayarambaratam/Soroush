package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ak extends AnimatorListenerAdapter {
    final /* synthetic */ an f461a;
    final /* synthetic */ ai f462b;

    ak(ai aiVar, an anVar) {
        this.f462b = aiVar;
        this.f461a = anVar;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.f461a != null) {
            this.f461a.m529a();
        }
    }

    public void onAnimationStart(Animator animator) {
        this.f462b.h.setVisibility(0);
    }
}
