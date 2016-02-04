package android.support.v7.app;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* renamed from: android.support.v7.app.u */
class C0395u implements OnScrollListener {
    final /* synthetic */ View f1952a;
    final /* synthetic */ View f1953b;
    final /* synthetic */ C0391q f1954c;

    C0395u(C0391q c0391q, View view, View view2) {
        this.f1954c = c0391q;
        this.f1952a = view;
        this.f1953b = view2;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        C0391q.m3855b(absListView, this.f1952a, this.f1953b);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
