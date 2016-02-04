package android.support.v7.app;

import android.support.v7.view.C0373n;
import android.view.Menu;
import android.view.View;
import android.view.Window.Callback;
import org.linphone.core.VideoSize;

class bx extends C0373n {
    final /* synthetic */ br f1823a;

    public bx(br brVar, Callback callback) {
        this.f1823a = brVar;
        super(callback);
    }

    public View onCreatePanelView(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                Menu menu = this.f1823a.f1808a.getMenu();
                if (onPreparePanel(i, null, menu) && onMenuOpened(i, menu)) {
                    return this.f1823a.m3683a(menu);
                }
        }
        return super.onCreatePanelView(i);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        boolean onPreparePanel = super.onPreparePanel(i, view, menu);
        if (onPreparePanel && !this.f1823a.f1809b) {
            this.f1823a.f1808a.setMenuPrepared();
            this.f1823a.f1809b = true;
        }
        return onPreparePanel;
    }
}
