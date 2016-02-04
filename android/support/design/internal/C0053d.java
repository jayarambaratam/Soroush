package android.support.design.internal;

import android.support.v7.view.menu.C0448m;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: android.support.design.internal.d */
class C0053d implements OnClickListener {
    final /* synthetic */ C0052c f249a;

    C0053d(C0052c c0052c) {
        this.f249a = c0052c;
    }

    public void onClick(View view) {
        NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
        this.f249a.m157a(true);
        C0448m itemData = navigationMenuItemView.getItemData();
        boolean a = this.f249a.f237d.m110a((MenuItem) itemData, this.f249a, 0);
        if (itemData != null && itemData.isCheckable() && a) {
            this.f249a.f239f.m171a(itemData);
        }
        this.f249a.m157a(false);
        this.f249a.updateMenuView(false);
    }
}
