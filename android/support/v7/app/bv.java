package android.support.v7.app;

import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0074j;
import android.view.MenuItem;
import mobi.mmdt.ott.C1317h;

final class bv implements C0074j {
    final /* synthetic */ br f1821a;

    private bv(br brVar) {
        this.f1821a = brVar;
    }

    public boolean onMenuItemSelected(C0049i c0049i, MenuItem menuItem) {
        return false;
    }

    public void onMenuModeChange(C0049i c0049i) {
        if (this.f1821a.f1810c == null) {
            return;
        }
        if (this.f1821a.f1808a.isOverflowMenuShowing()) {
            this.f1821a.f1810c.onPanelClosed(C1317h.Theme_spinnerStyle, c0049i);
        } else if (this.f1821a.f1810c.onPreparePanel(0, null, c0049i)) {
            this.f1821a.f1810c.onMenuOpened(C1317h.Theme_spinnerStyle, c0049i);
        }
    }
}
