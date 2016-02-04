package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p007d.p008a.C0199b;
import android.support.v4.p007d.p008a.C0200c;
import android.support.v4.p016f.C0223a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* renamed from: android.support.v7.view.menu.e */
abstract class C0441e<T> extends C0440f<T> {
    final Context f2157a;
    private Map<C0199b, MenuItem> f2158c;
    private Map<C0200c, SubMenu> f2159d;

    C0441e(Context context, T t) {
        super(t);
        this.f2157a = context;
    }

    final MenuItem m4040a(MenuItem menuItem) {
        if (!(menuItem instanceof C0199b)) {
            return menuItem;
        }
        C0199b c0199b = (C0199b) menuItem;
        if (this.f2158c == null) {
            this.f2158c = new C0223a();
        }
        MenuItem menuItem2 = (MenuItem) this.f2158c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = ab.m4038a(this.f2157a, c0199b);
        this.f2158c.put(c0199b, menuItem2);
        return menuItem2;
    }

    final SubMenu m4041a(SubMenu subMenu) {
        if (!(subMenu instanceof C0200c)) {
            return subMenu;
        }
        C0200c c0200c = (C0200c) subMenu;
        if (this.f2159d == null) {
            this.f2159d = new C0223a();
        }
        SubMenu subMenu2 = (SubMenu) this.f2159d.get(c0200c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = ab.m4039a(this.f2157a, c0200c);
        this.f2159d.put(c0200c, subMenu2);
        return subMenu2;
    }

    final void m4042a() {
        if (this.f2158c != null) {
            this.f2158c.clear();
        }
        if (this.f2159d != null) {
            this.f2159d.clear();
        }
    }

    final void m4043a(int i) {
        if (this.f2158c != null) {
            Iterator it = this.f2158c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m4044b(int i) {
        if (this.f2158c != null) {
            Iterator it = this.f2158c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
