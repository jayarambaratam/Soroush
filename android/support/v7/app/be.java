package android.support.v7.app;

import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0374y;
import android.view.Menu;
import android.view.Window.Callback;
import mobi.mmdt.ott.C1317h;

final class be implements C0374y {
    final /* synthetic */ AppCompatDelegateImplV7 f1795a;

    private be(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.f1795a = appCompatDelegateImplV7;
    }

    public void onCloseMenu(C0049i c0049i, boolean z) {
        Menu menu;
        Menu p = c0049i.m136p();
        boolean z2 = p != c0049i;
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = this.f1795a;
        if (z2) {
            menu = p;
        }
        PanelFeatureState a = appCompatDelegateImplV7.m3504a(menu);
        if (a == null) {
            return;
        }
        if (z2) {
            this.f1795a.m3505a(a.f1709a, a, p);
            this.f1795a.m3507a(a, true);
            return;
        }
        this.f1795a.m3507a(a, z);
    }

    public boolean onOpenSubMenu(C0049i c0049i) {
        if (c0049i == null && this.f1795a.h) {
            Callback n = this.f1795a.m3499n();
            if (!(n == null || this.f1795a.m3498m())) {
                n.onMenuOpened(C1317h.Theme_spinnerStyle, c0049i);
            }
        }
        return true;
    }
}
