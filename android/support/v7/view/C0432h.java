package android.support.v7.view;

import android.content.Context;
import android.support.v4.p007d.p008a.C0048a;
import android.support.v4.p007d.p008a.C0199b;
import android.support.v4.p016f.C0222q;
import android.support.v7.view.menu.ab;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.h */
public class C0432h implements C0376c {
    final Callback f2066a;
    final Context f2067b;
    final ArrayList<C0431g> f2068c;
    final C0222q<Menu, Menu> f2069d;

    public C0432h(Context context, Callback callback) {
        this.f2067b = context;
        this.f2066a = callback;
        this.f2068c = new ArrayList();
        this.f2069d = new C0222q();
    }

    private Menu m3981a(Menu menu) {
        Menu menu2 = (Menu) this.f2069d.get(menu);
        if (menu2 != null) {
            return menu2;
        }
        menu2 = ab.m4037a(this.f2067b, (C0048a) menu);
        this.f2069d.put(menu, menu2);
        return menu2;
    }

    public void m3982a(C0378b c0378b) {
        this.f2066a.onDestroyActionMode(m3985b(c0378b));
    }

    public boolean m3983a(C0378b c0378b, Menu menu) {
        return this.f2066a.onCreateActionMode(m3985b(c0378b), m3981a(menu));
    }

    public boolean m3984a(C0378b c0378b, MenuItem menuItem) {
        return this.f2066a.onActionItemClicked(m3985b(c0378b), ab.m4038a(this.f2067b, (C0199b) menuItem));
    }

    public ActionMode m3985b(C0378b c0378b) {
        int size = this.f2068c.size();
        for (int i = 0; i < size; i++) {
            C0431g c0431g = (C0431g) this.f2068c.get(i);
            if (c0431g != null && c0431g.f2065b == c0378b) {
                return c0431g;
            }
        }
        ActionMode c0431g2 = new C0431g(this.f2067b, c0378b);
        this.f2068c.add(c0431g2);
        return c0431g2;
    }

    public boolean m3986b(C0378b c0378b, Menu menu) {
        return this.f2066a.onPrepareActionMode(m3985b(c0378b), m3981a(menu));
    }
}
