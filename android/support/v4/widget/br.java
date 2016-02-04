package android.support.v4.widget;

import android.support.v4.view.cb;
import android.view.View;

class br implements Runnable {
    final View f1631a;
    final /* synthetic */ SlidingPaneLayout f1632b;

    br(SlidingPaneLayout slidingPaneLayout, View view) {
        this.f1632b = slidingPaneLayout;
        this.f1631a = view;
    }

    public void run() {
        if (this.f1631a.getParent() == this.f1632b) {
            cb.m2396a(this.f1631a, 0, null);
            this.f1632b.m3030d(this.f1631a);
        }
        this.f1632b.f1508u.remove(this);
    }
}
