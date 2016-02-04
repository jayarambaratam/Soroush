package android.support.design.widget;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

/* renamed from: android.support.design.widget.t */
final class C0094t implements OnHierarchyChangeListener {
    final /* synthetic */ CoordinatorLayout f665a;

    C0094t(CoordinatorLayout coordinatorLayout) {
        this.f665a = coordinatorLayout;
    }

    public void onChildViewAdded(View view, View view2) {
        if (this.f665a.f341y != null) {
            this.f665a.f341y.onChildViewAdded(view, view2);
        }
    }

    public void onChildViewRemoved(View view, View view2) {
        this.f665a.m342b(view2);
        if (this.f665a.f341y != null) {
            this.f665a.f341y.onChildViewRemoved(view, view2);
        }
    }
}
