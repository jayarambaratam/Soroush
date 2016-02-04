package android.support.v7.app;

import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0374y;

final class bw implements C0374y {
    final /* synthetic */ br f1822a;

    private bw(br brVar) {
        this.f1822a = brVar;
    }

    public void onCloseMenu(C0049i c0049i, boolean z) {
        if (this.f1822a.f1810c != null) {
            this.f1822a.f1810c.onPanelClosed(0, c0049i);
        }
    }

    public boolean onOpenSubMenu(C0049i c0049i) {
        if (c0049i == null && this.f1822a.f1810c != null) {
            this.f1822a.f1810c.onMenuOpened(0, c0049i);
        }
        return true;
    }
}
