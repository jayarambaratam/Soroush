package android.support.design.widget;

import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0074j;
import android.view.MenuItem;

class at implements C0074j {
    final /* synthetic */ NavigationView f468a;

    at(NavigationView navigationView) {
        this.f468a = navigationView;
    }

    public boolean onMenuItemSelected(C0049i c0049i, MenuItem menuItem) {
        return this.f468a.f360e != null && this.f468a.f360e.m542a(menuItem);
    }

    public void onMenuModeChange(C0049i c0049i) {
    }
}
