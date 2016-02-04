package android.support.v7.app;

import android.support.v4.view.cb;
import android.support.v4.view.fd;
import android.view.View;

class bz extends fd {
    final /* synthetic */ by f1859a;

    bz(by byVar) {
        this.f1859a = byVar;
    }

    public void onAnimationEnd(View view) {
        if (this.f1859a.f1830C && this.f1859a.f1852t != null) {
            cb.m2408b(this.f1859a.f1852t, 0.0f);
            cb.m2408b(this.f1859a.f1849q, 0.0f);
        }
        this.f1859a.f1849q.setVisibility(8);
        this.f1859a.f1849q.setTransitioning(false);
        this.f1859a.f1835H = null;
        this.f1859a.m3751f();
        if (this.f1859a.f1848p != null) {
            cb.m2446w(this.f1859a.f1848p);
        }
    }
}
