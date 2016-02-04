package android.support.design.widget;

import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: android.support.design.widget.v */
class C0096v implements OnPreDrawListener {
    final /* synthetic */ CoordinatorLayout f679a;

    C0096v(CoordinatorLayout coordinatorLayout) {
        this.f679a = coordinatorLayout;
    }

    public boolean onPreDraw() {
        this.f679a.m338a(false);
        return true;
    }
}
