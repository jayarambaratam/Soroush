package android.support.design.widget;

import android.support.v4.view.cb;
import android.view.View;

class bw implements Runnable {
    final /* synthetic */ SwipeDismissBehavior f518a;
    private final View f519b;
    private final boolean f520c;

    bw(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.f518a = swipeDismissBehavior;
        this.f519b = view;
        this.f520c = z;
    }

    public void run() {
        if (this.f518a.f376a != null && this.f518a.f376a.m3397a(true)) {
            cb.m2402a(this.f519b, (Runnable) this);
        } else if (this.f520c && this.f518a.f377b != null) {
            this.f518a.f377b.m564a(this.f519b);
        }
    }
}
