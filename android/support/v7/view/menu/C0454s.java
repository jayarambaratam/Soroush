package android.support.v7.view.menu;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

/* renamed from: android.support.v7.view.menu.s */
class C0454s extends C0440f<OnMenuItemClickListener> implements OnMenuItemClickListener {
    final /* synthetic */ C0450o f2209a;

    C0454s(C0450o c0450o, OnMenuItemClickListener onMenuItemClickListener) {
        this.f2209a = c0450o;
        super(onMenuItemClickListener);
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.f2209a.m4040a(menuItem));
    }
}
