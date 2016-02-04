package android.support.v7.app;

import android.support.v7.view.C0373n;
import android.support.v7.view.menu.C0049i;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;

class am extends C0373n {
    final /* synthetic */ aj f1779a;

    am(aj ajVar, Callback callback) {
        this.f1779a = ajVar;
        super(callback);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f1779a.m3488a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return super.dispatchKeyShortcutEvent(keyEvent) || this.f1779a.m3487a(keyEvent.getKeyCode(), keyEvent);
    }

    public void onContentChanged() {
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return (i != 0 || (menu instanceof C0049i)) ? super.onCreatePanelMenu(i, menu) : false;
    }

    public boolean onMenuOpened(int i, Menu menu) {
        super.onMenuOpened(i, menu);
        this.f1779a.m3491b(i, menu);
        return true;
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
        this.f1779a.m3485a(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        C0049i c0049i = menu instanceof C0049i ? (C0049i) menu : null;
        if (i == 0 && c0049i == null) {
            return false;
        }
        if (c0049i != null) {
            c0049i.m119c(true);
        }
        boolean onPreparePanel = super.onPreparePanel(i, view, menu);
        if (c0049i == null) {
            return onPreparePanel;
        }
        c0049i.m119c(false);
        return onPreparePanel;
    }
}
