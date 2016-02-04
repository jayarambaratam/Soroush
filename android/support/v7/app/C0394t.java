package android.support.v7.app;

import android.view.View;

/* renamed from: android.support.v7.app.t */
class C0394t implements Runnable {
    final /* synthetic */ View f1949a;
    final /* synthetic */ View f1950b;
    final /* synthetic */ C0391q f1951c;

    C0394t(C0391q c0391q, View view, View view2) {
        this.f1951c = c0391q;
        this.f1949a = view;
        this.f1950b = view2;
    }

    public void run() {
        C0391q.m3855b(this.f1951c.f1941w, this.f1949a, this.f1950b);
    }
}
