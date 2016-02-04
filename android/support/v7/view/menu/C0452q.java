package android.support.v7.view.menu;

import android.support.v7.view.C0428d;
import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;

/* renamed from: android.support.v7.view.menu.q */
class C0452q extends FrameLayout implements C0428d {
    final CollapsibleActionView f2207a;

    C0452q(View view) {
        super(view.getContext());
        this.f2207a = (CollapsibleActionView) view;
        addView(view);
    }

    View m4087a() {
        return (View) this.f2207a;
    }

    public void onActionViewCollapsed() {
        this.f2207a.onActionViewCollapsed();
    }

    public void onActionViewExpanded() {
        this.f2207a.onActionViewExpanded();
    }
}
