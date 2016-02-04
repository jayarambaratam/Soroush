package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p007d.p008a.C0048a;
import android.support.v4.p007d.p008a.C0199b;
import android.support.v4.p007d.p008a.C0200c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class ab {
    public static Menu m4037a(Context context, C0048a c0048a) {
        if (VERSION.SDK_INT >= 14) {
            return new ac(context, c0048a);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem m4038a(Context context, C0199b c0199b) {
        if (VERSION.SDK_INT >= 16) {
            return new C0455t(context, c0199b);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0450o(context, c0199b);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu m4039a(Context context, C0200c c0200c) {
        if (VERSION.SDK_INT >= 14) {
            return new ae(context, c0200c);
        }
        throw new UnsupportedOperationException();
    }
}
