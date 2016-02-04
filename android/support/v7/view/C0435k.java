package android.support.v7.view;

import android.content.res.TypedArray;
import android.support.v4.view.C0319n;
import android.support.v4.view.ax;
import android.support.v7.p019a.C0369l;
import android.support.v7.view.menu.C0448m;
import android.support.v7.view.menu.C0450o;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;

/* renamed from: android.support.v7.view.k */
class C0435k {
    final /* synthetic */ C0433i f2079a;
    private Menu f2080b;
    private int f2081c;
    private int f2082d;
    private int f2083e;
    private int f2084f;
    private boolean f2085g;
    private boolean f2086h;
    private boolean f2087i;
    private int f2088j;
    private int f2089k;
    private CharSequence f2090l;
    private CharSequence f2091m;
    private int f2092n;
    private char f2093o;
    private char f2094p;
    private int f2095q;
    private boolean f2096r;
    private boolean f2097s;
    private boolean f2098t;
    private int f2099u;
    private int f2100v;
    private String f2101w;
    private String f2102x;
    private String f2103y;
    private C0319n f2104z;

    public C0435k(C0433i c0433i, Menu menu) {
        this.f2079a = c0433i;
        this.f2080b = menu;
        m4000a();
    }

    private char m3996a(String str) {
        return str == null ? '\u0000' : str.charAt(0);
    }

    private <T> T m3998a(String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            Constructor constructor = this.f2079a.f2074e.getClassLoader().loadClass(str).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Throwable e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    private void m3999a(MenuItem menuItem) {
        boolean z = true;
        menuItem.setChecked(this.f2096r).setVisible(this.f2097s).setEnabled(this.f2098t).setCheckable(this.f2095q >= 1).setTitleCondensed(this.f2091m).setIcon(this.f2092n).setAlphabeticShortcut(this.f2093o).setNumericShortcut(this.f2094p);
        if (this.f2099u >= 0) {
            ax.m2246a(menuItem, this.f2099u);
        }
        if (this.f2103y != null) {
            if (this.f2079a.f2074e.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            menuItem.setOnMenuItemClickListener(new C0434j(this.f2079a.m3993c(), this.f2103y));
        }
        if (menuItem instanceof C0448m) {
            C0448m c0448m = (C0448m) menuItem;
        }
        if (this.f2095q >= 2) {
            if (menuItem instanceof C0448m) {
                ((C0448m) menuItem).m4065a(true);
            } else if (menuItem instanceof C0450o) {
                ((C0450o) menuItem).m4086a(true);
            }
        }
        if (this.f2101w != null) {
            ax.m2244a(menuItem, (View) m3998a(this.f2101w, C0433i.f2070a, this.f2079a.f2072c));
        } else {
            z = false;
        }
        if (this.f2100v > 0) {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                ax.m2247b(menuItem, this.f2100v);
            }
        }
        if (this.f2104z != null) {
            ax.m2243a(menuItem, this.f2104z);
        }
    }

    public void m4000a() {
        this.f2081c = 0;
        this.f2082d = 0;
        this.f2083e = 0;
        this.f2084f = 0;
        this.f2085g = true;
        this.f2086h = true;
    }

    public void m4001a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f2079a.f2074e.obtainStyledAttributes(attributeSet, C0369l.MenuGroup);
        this.f2081c = obtainStyledAttributes.getResourceId(C0369l.MenuGroup_android_id, 0);
        this.f2082d = obtainStyledAttributes.getInt(C0369l.MenuGroup_android_menuCategory, 0);
        this.f2083e = obtainStyledAttributes.getInt(C0369l.MenuGroup_android_orderInCategory, 0);
        this.f2084f = obtainStyledAttributes.getInt(C0369l.MenuGroup_android_checkableBehavior, 0);
        this.f2085g = obtainStyledAttributes.getBoolean(C0369l.MenuGroup_android_visible, true);
        this.f2086h = obtainStyledAttributes.getBoolean(C0369l.MenuGroup_android_enabled, true);
        obtainStyledAttributes.recycle();
    }

    public void m4002b() {
        this.f2087i = true;
        m3999a(this.f2080b.add(this.f2081c, this.f2088j, this.f2089k, this.f2090l));
    }

    public void m4003b(AttributeSet attributeSet) {
        boolean z = true;
        TypedArray obtainStyledAttributes = this.f2079a.f2074e.obtainStyledAttributes(attributeSet, C0369l.MenuItem);
        this.f2088j = obtainStyledAttributes.getResourceId(C0369l.MenuItem_android_id, 0);
        this.f2089k = (obtainStyledAttributes.getInt(C0369l.MenuItem_android_menuCategory, this.f2082d) & -65536) | (obtainStyledAttributes.getInt(C0369l.MenuItem_android_orderInCategory, this.f2083e) & InBandBytestreamManager.MAXIMUM_BLOCK_SIZE);
        this.f2090l = obtainStyledAttributes.getText(C0369l.MenuItem_android_title);
        this.f2091m = obtainStyledAttributes.getText(C0369l.MenuItem_android_titleCondensed);
        this.f2092n = obtainStyledAttributes.getResourceId(C0369l.MenuItem_android_icon, 0);
        this.f2093o = m3996a(obtainStyledAttributes.getString(C0369l.MenuItem_android_alphabeticShortcut));
        this.f2094p = m3996a(obtainStyledAttributes.getString(C0369l.MenuItem_android_numericShortcut));
        if (obtainStyledAttributes.hasValue(C0369l.MenuItem_android_checkable)) {
            this.f2095q = obtainStyledAttributes.getBoolean(C0369l.MenuItem_android_checkable, false) ? 1 : 0;
        } else {
            this.f2095q = this.f2084f;
        }
        this.f2096r = obtainStyledAttributes.getBoolean(C0369l.MenuItem_android_checked, false);
        this.f2097s = obtainStyledAttributes.getBoolean(C0369l.MenuItem_android_visible, this.f2085g);
        this.f2098t = obtainStyledAttributes.getBoolean(C0369l.MenuItem_android_enabled, this.f2086h);
        this.f2099u = obtainStyledAttributes.getInt(C0369l.MenuItem_showAsAction, -1);
        this.f2103y = obtainStyledAttributes.getString(C0369l.MenuItem_android_onClick);
        this.f2100v = obtainStyledAttributes.getResourceId(C0369l.MenuItem_actionLayout, 0);
        this.f2101w = obtainStyledAttributes.getString(C0369l.MenuItem_actionViewClass);
        this.f2102x = obtainStyledAttributes.getString(C0369l.MenuItem_actionProviderClass);
        if (this.f2102x == null) {
            z = false;
        }
        if (z && this.f2100v == 0 && this.f2101w == null) {
            this.f2104z = (C0319n) m3998a(this.f2102x, C0433i.f2071b, this.f2079a.f2073d);
        } else {
            if (z) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.f2104z = null;
        }
        obtainStyledAttributes.recycle();
        this.f2087i = false;
    }

    public SubMenu m4004c() {
        this.f2087i = true;
        SubMenu addSubMenu = this.f2080b.addSubMenu(this.f2081c, this.f2088j, this.f2089k, this.f2090l);
        m3999a(addSubMenu.getItem());
        return addSubMenu;
    }

    public boolean m4005d() {
        return this.f2087i;
    }
}
