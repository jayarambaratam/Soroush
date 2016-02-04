package android.support.v7.app;

import android.support.v4.view.fd;
import android.view.View;

class ca extends fd {
    final /* synthetic */ by f1860a;

    ca(by byVar) {
        this.f1860a = byVar;
    }

    public void onAnimationEnd(View view) {
        this.f1860a.f1835H = null;
        this.f1860a.f1849q.requestLayout();
    }
}
