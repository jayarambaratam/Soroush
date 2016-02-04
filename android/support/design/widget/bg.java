package android.support.design.widget;

import android.support.v4.view.fd;
import android.view.View;

class bg extends fd {
    final /* synthetic */ Snackbar f495a;

    bg(Snackbar snackbar) {
        this.f495a = snackbar;
    }

    public void onAnimationEnd(View view) {
        if (this.f495a.f374f != null) {
            this.f495a.f374f.m576a(this.f495a);
        }
        bn.m578a().m589b(this.f495a.f375g);
    }

    public void onAnimationStart(View view) {
        this.f495a.f372d.m374a(70, 180);
    }
}
