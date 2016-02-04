package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ar implements AnimationListener {
    final /* synthetic */ at f1598a;
    final /* synthetic */ ap f1599b;

    ar(ap apVar, at atVar) {
        this.f1599b = apVar;
        this.f1598a = atVar;
    }

    public void onAnimationEnd(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
        this.f1598a.m3232l();
        this.f1598a.m3215b();
        this.f1598a.m3216b(this.f1598a.m3229i());
        if (this.f1599b.f1584a) {
            this.f1599b.f1584a = false;
            animation.setDuration(1332);
            this.f1598a.m3213a(false);
            return;
        }
        this.f1599b.f1592k = (this.f1599b.f1592k + 1.0f) % 5.0f;
    }

    public void onAnimationStart(Animation animation) {
        this.f1599b.f1592k = 0.0f;
    }
}
