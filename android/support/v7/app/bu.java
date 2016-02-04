package android.support.v7.app;

import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0374y;
import mobi.mmdt.ott.C1317h;

final class bu implements C0374y {
    final /* synthetic */ br f1819a;
    private boolean f1820b;

    private bu(br brVar) {
        this.f1819a = brVar;
    }

    public void onCloseMenu(C0049i c0049i, boolean z) {
        if (!this.f1820b) {
            this.f1820b = true;
            this.f1819a.f1808a.dismissPopupMenus();
            if (r1.f1810c != null) {
                this.f1819a.f1810c.onPanelClosed(C1317h.Theme_spinnerStyle, c0049i);
            }
            this.f1820b = false;
        }
    }

    public boolean onOpenSubMenu(C0049i c0049i) {
        if (this.f1819a.f1810c == null) {
            return false;
        }
        this.f1819a.f1810c.onMenuOpened(C1317h.Theme_spinnerStyle, c0049i);
        return true;
    }
}
