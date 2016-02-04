package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.app.ae;
import android.support.v7.app.af;
import android.support.v7.p019a.C0366i;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/* renamed from: android.support.v7.view.menu.l */
class C0447l implements OnClickListener, OnDismissListener, OnKeyListener, C0374y {
    C0445g f2173a;
    private C0049i f2174b;
    private ae f2175c;
    private C0374y f2176d;

    public C0447l(C0049i c0049i) {
        this.f2174b = c0049i;
    }

    public void m4054a() {
        if (this.f2175c != null) {
            this.f2175c.dismiss();
        }
    }

    public void m4055a(IBinder iBinder) {
        C0049i c0049i = this.f2174b;
        af afVar = new af(c0049i.m125e());
        this.f2173a = new C0445g(afVar.m3601a(), C0366i.abc_list_menu_item_layout);
        this.f2173a.m4050a((C0374y) this);
        this.f2174b.m103a(this.f2173a);
        afVar.m3605a(this.f2173a.m4048a(), (OnClickListener) this);
        View o = c0049i.m135o();
        if (o != null) {
            afVar.m3604a(o);
        } else {
            afVar.m3603a(c0049i.m134n()).m3606a(c0049i.m133m());
        }
        afVar.m3602a((OnKeyListener) this);
        this.f2175c = afVar.m3608b();
        this.f2175c.setOnDismissListener(this);
        LayoutParams attributes = this.f2175c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f2175c.show();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f2174b.m109a((C0448m) this.f2173a.m4048a().getItem(i), 0);
    }

    public void onCloseMenu(C0049i c0049i, boolean z) {
        if (z || c0049i == this.f2174b) {
            m4054a();
        }
        if (this.f2176d != null) {
            this.f2176d.onCloseMenu(c0049i, z);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f2173a.onCloseMenu(this.f2174b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f2175c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f2175c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f2174b.m115b(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f2174b.performShortcut(i, keyEvent, 0);
    }

    public boolean onOpenSubMenu(C0049i c0049i) {
        return this.f2176d != null ? this.f2176d.onOpenSubMenu(c0049i) : false;
    }
}
