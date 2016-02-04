package android.support.v4.app;

import android.view.View;
import android.view.animation.Animation;

class ab extends ac {
    final /* synthetic */ Fragment f804a;
    final /* synthetic */ C0153z f805b;

    ab(C0153z c0153z, View view, Animation animation, Fragment fragment) {
        this.f805b = c0153z;
        this.f804a = fragment;
        super(view, animation);
    }

    public void onAnimationEnd(Animation animation) {
        super.onAnimationEnd(animation);
        if (this.f804a.f754c != null) {
            this.f804a.f754c = null;
            this.f805b.m1414a(this.f804a, this.f804a.f755d, 0, 0, false);
        }
    }
}
