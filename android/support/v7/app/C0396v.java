package android.support.v7.app;

import android.view.View;

/* renamed from: android.support.v7.app.v */
class C0396v implements Runnable {
    final /* synthetic */ View f1955a;
    final /* synthetic */ View f1956b;
    final /* synthetic */ C0391q f1957c;

    C0396v(C0391q c0391q, View view, View view2) {
        this.f1957c = c0391q;
        this.f1955a = view;
        this.f1956b = view2;
    }

    public void run() {
        C0391q.m3855b(this.f1957c.f1924f, this.f1955a, this.f1956b);
    }
}
