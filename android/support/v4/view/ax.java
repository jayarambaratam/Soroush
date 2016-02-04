package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.p007d.p008a.C0199b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class ax {
    static final bb f1329a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f1329a = new ba();
        } else if (i >= 11) {
            f1329a = new az();
        } else {
            f1329a = new ay();
        }
    }

    public static MenuItem m2243a(MenuItem menuItem, C0319n c0319n) {
        if (menuItem instanceof C0199b) {
            return ((C0199b) menuItem).m1628a(c0319n);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static MenuItem m2244a(MenuItem menuItem, View view) {
        return menuItem instanceof C0199b ? ((C0199b) menuItem).setActionView(view) : f1329a.m2250a(menuItem, view);
    }

    public static View m2245a(MenuItem menuItem) {
        return menuItem instanceof C0199b ? ((C0199b) menuItem).getActionView() : f1329a.m2251a(menuItem);
    }

    public static void m2246a(MenuItem menuItem, int i) {
        if (menuItem instanceof C0199b) {
            ((C0199b) menuItem).setShowAsAction(i);
        } else {
            f1329a.m2252a(menuItem, i);
        }
    }

    public static MenuItem m2247b(MenuItem menuItem, int i) {
        return menuItem instanceof C0199b ? ((C0199b) menuItem).setActionView(i) : f1329a.m2253b(menuItem, i);
    }

    public static boolean m2248b(MenuItem menuItem) {
        return menuItem instanceof C0199b ? ((C0199b) menuItem).expandActionView() : f1329a.m2254b(menuItem);
    }

    public static boolean m2249c(MenuItem menuItem) {
        return menuItem instanceof C0199b ? ((C0199b) menuItem).isActionViewExpanded() : f1329a.m2255c(menuItem);
    }
}
