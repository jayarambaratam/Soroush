package android.support.design.widget;

import android.view.animation.Animation;

class ae extends C0073b {
    final /* synthetic */ an f451a;
    final /* synthetic */ ac f452b;

    ae(ac acVar, an anVar) {
        this.f452b = acVar;
        this.f451a = anVar;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f451a != null) {
            this.f451a.m529a();
        }
    }
}
