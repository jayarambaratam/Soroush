package android.support.v7.app;

import android.support.v4.view.cb;
import android.support.v4.view.fd;
import android.view.View;

class ax extends fd {
    final /* synthetic */ aw f1788a;

    ax(aw awVar) {
        this.f1788a = awVar;
    }

    public void onAnimationEnd(View view) {
        cb.m2413c(this.f1788a.f1787a.f1755n, 1.0f);
        this.f1788a.f1787a.f1758q.m2800a(null);
        this.f1788a.f1787a.f1758q = null;
    }

    public void onAnimationStart(View view) {
        this.f1788a.f1787a.f1755n.setVisibility(0);
    }
}
