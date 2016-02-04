package android.support.v7.view.menu;

import android.support.v4.view.bc;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

/* renamed from: android.support.v7.view.menu.r */
class C0453r extends C0440f<OnActionExpandListener> implements bc {
    final /* synthetic */ C0450o f2208a;

    C0453r(C0450o c0450o, OnActionExpandListener onActionExpandListener) {
        this.f2208a = c0450o;
        super(onActionExpandListener);
    }

    public boolean m4088a(MenuItem menuItem) {
        return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f2208a.m4040a(menuItem));
    }

    public boolean m4089b(MenuItem menuItem) {
        return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f2208a.m4040a(menuItem));
    }
}
