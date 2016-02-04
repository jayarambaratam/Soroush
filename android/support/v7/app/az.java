package android.support.v7.app;

import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0374y;
import android.view.Window.Callback;
import mobi.mmdt.ott.C1317h;

final class az implements C0374y {
    final /* synthetic */ AppCompatDelegateImplV7 f1790a;

    private az(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.f1790a = appCompatDelegateImplV7;
    }

    public void onCloseMenu(C0049i c0049i, boolean z) {
        this.f1790a.m3512a(c0049i);
    }

    public boolean onOpenSubMenu(C0049i c0049i) {
        Callback n = this.f1790a.m3499n();
        if (n != null) {
            n.onMenuOpened(C1317h.Theme_spinnerStyle, c0049i);
        }
        return true;
    }
}
