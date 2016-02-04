package android.support.v7.view.menu;

import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;

/* renamed from: android.support.v7.view.menu.b */
class C0442b extends ForwardingListener {
    final /* synthetic */ ActionMenuItemView f2160a;

    public C0442b(ActionMenuItemView actionMenuItemView) {
        this.f2160a = actionMenuItemView;
        super(actionMenuItemView);
    }

    public ListPopupWindow getPopup() {
        return this.f2160a.f2119f != null ? this.f2160a.f2119f.getPopup() : null;
    }

    protected boolean onForwardingStarted() {
        if (this.f2160a.f2117d == null || !this.f2160a.f2117d.invokeItem(this.f2160a.f2114a)) {
            return false;
        }
        ListPopupWindow popup = getPopup();
        return popup != null && popup.isShowing();
    }
}
