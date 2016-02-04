package android.support.v7.app;

import android.support.v4.view.cb;
import android.support.v4.view.fd;
import android.view.View;

class bb extends fd {
    final /* synthetic */ ba f1793a;

    bb(ba baVar) {
        this.f1793a = baVar;
    }

    public void onAnimationEnd(View view) {
        this.f1793a.f1791a.f1755n.setVisibility(8);
        if (this.f1793a.f1791a.f1756o != null) {
            this.f1793a.f1791a.f1756o.dismiss();
        } else if (this.f1793a.f1791a.f1755n.getParent() instanceof View) {
            cb.m2446w((View) this.f1793a.f1791a.f1755n.getParent());
        }
        this.f1793a.f1791a.f1755n.removeAllViews();
        this.f1793a.f1791a.f1758q.m2800a(null);
        this.f1793a.f1791a.f1758q = null;
    }
}
