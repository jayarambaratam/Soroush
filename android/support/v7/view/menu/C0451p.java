package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.C0319n;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.p */
class C0451p extends C0319n {
    final ActionProvider f2205a;
    final /* synthetic */ C0450o f2206b;

    public C0451p(C0450o c0450o, Context context, ActionProvider actionProvider) {
        this.f2206b = c0450o;
        super(context);
        this.f2205a = actionProvider;
    }

    public boolean hasSubMenu() {
        return this.f2205a.hasSubMenu();
    }

    public View onCreateActionView() {
        return this.f2205a.onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return this.f2205a.onPerformDefaultAction();
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        this.f2205a.onPrepareSubMenu(this.f2206b.m4041a(subMenu));
    }
}
