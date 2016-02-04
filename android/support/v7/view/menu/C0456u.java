package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.C0321p;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.view.menu.u */
class C0456u extends C0451p implements VisibilityListener {
    C0321p f2210c;
    final /* synthetic */ C0455t f2211d;

    public C0456u(C0455t c0455t, Context context, ActionProvider actionProvider) {
        this.f2211d = c0455t;
        super(c0455t, context, actionProvider);
    }

    public boolean isVisible() {
        return this.a.isVisible();
    }

    public void onActionProviderVisibilityChanged(boolean z) {
        if (this.f2210c != null) {
            this.f2210c.m2924a(z);
        }
    }

    public View onCreateActionView(MenuItem menuItem) {
        return this.a.onCreateActionView(menuItem);
    }

    public boolean overridesItemVisibility() {
        return this.a.overridesItemVisibility();
    }

    public void refreshVisibility() {
        this.a.refreshVisibility();
    }

    public void setVisibilityListener(C0321p c0321p) {
        VisibilityListener visibilityListener;
        this.f2210c = c0321p;
        ActionProvider actionProvider = this.a;
        if (c0321p == null) {
            visibilityListener = null;
        }
        actionProvider.setVisibilityListener(visibilityListener);
    }
}
