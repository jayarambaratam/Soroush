package com.dd.morphingbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: com.dd.morphingbutton.d */
class C1029d extends AnimatorListenerAdapter {
    final /* synthetic */ C1026a f3877a;

    C1029d(C1026a c1026a) {
        this.f3877a = c1026a;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.f3877a.f3874a.f3892o != null) {
            this.f3877a.f3874a.f3892o.m6168a();
        }
    }
}
