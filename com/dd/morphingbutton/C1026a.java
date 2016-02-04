package com.dd.morphingbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

/* renamed from: com.dd.morphingbutton.a */
public class C1026a {
    private C1031f f3874a;

    public C1026a(C1031f c1031f) {
        this.f3874a = c1031f;
    }

    public void m6167a() {
        C1039n drawableNormal = this.f3874a.f3891n.getDrawableNormal();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(drawableNormal, "cornerRadius", new float[]{this.f3874a.f3878a, this.f3874a.f3879b});
        ObjectAnimator ofInt = ObjectAnimator.ofInt(drawableNormal, "strokeWidth", new int[]{this.f3874a.f3887j, this.f3874a.f3888k});
        ObjectAnimator.ofInt(drawableNormal, "strokeColor", new int[]{this.f3874a.f3889l, this.f3874a.f3890m}).setEvaluator(new ArgbEvaluator());
        ObjectAnimator.ofInt(drawableNormal, "color", new int[]{this.f3874a.f3884g, this.f3874a.f3885h}).setEvaluator(new ArgbEvaluator());
        ValueAnimator.ofInt(new int[]{this.f3874a.f3880c, this.f3874a.f3881d}).addUpdateListener(new C1027b(this));
        ValueAnimator.ofInt(new int[]{this.f3874a.f3882e, this.f3874a.f3883f}).addUpdateListener(new C1028c(this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration((long) this.f3874a.f3886i);
        animatorSet.playTogether(new Animator[]{ofInt, r3, ofFloat, r0, r4, r5});
        animatorSet.addListener(new C1029d(this));
        animatorSet.start();
    }
}
