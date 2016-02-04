package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

class bd {
    public static MenuItem m2303a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static View m2304a(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static void m2305a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem m2306b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }
}
