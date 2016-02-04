package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class db extends AnimatorListenerAdapter {
    final /* synthetic */ cv f586a;
    final /* synthetic */ cz f587b;

    db(cz czVar, cv cvVar) {
        this.f587b = czVar;
        this.f586a = cvVar;
    }

    public void onAnimationCancel(Animator animator) {
        this.f586a.m695c();
    }

    public void onAnimationEnd(Animator animator) {
        this.f586a.m694b();
    }

    public void onAnimationStart(Animator animator) {
        this.f586a.m693a();
    }
}
