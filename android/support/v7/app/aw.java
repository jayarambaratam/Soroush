package android.support.v7.app;

import android.support.v4.view.cb;

class aw implements Runnable {
    final /* synthetic */ AppCompatDelegateImplV7 f1787a;

    aw(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.f1787a = appCompatDelegateImplV7;
    }

    public void run() {
        this.f1787a.f1756o.showAtLocation(this.f1787a.f1755n, 55, 0, 0);
        this.f1787a.m3536t();
        cb.m2413c(this.f1787a.f1755n, 0.0f);
        this.f1787a.f1758q = cb.m2442s(this.f1787a.f1755n).m2798a(1.0f);
        this.f1787a.f1758q.m2800a(new ax(this));
    }
}
