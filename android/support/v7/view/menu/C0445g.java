package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.p019a.C0366i;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

/* renamed from: android.support.v7.view.menu.g */
public class C0445g implements C0051x, OnItemClickListener {
    Context f2161a;
    LayoutInflater f2162b;
    C0049i f2163c;
    ExpandedMenuView f2164d;
    int f2165e;
    int f2166f;
    C0446h f2167g;
    private int f2168h;
    private C0374y f2169i;
    private int f2170j;

    public C0445g(int i, int i2) {
        this.f2166f = i;
        this.f2165e = i2;
    }

    public C0445g(Context context, int i) {
        this(i, 0);
        this.f2161a = context;
        this.f2162b = LayoutInflater.from(this.f2161a);
    }

    public C0047z m4047a(ViewGroup viewGroup) {
        if (this.f2164d == null) {
            this.f2164d = (ExpandedMenuView) this.f2162b.inflate(C0366i.abc_expanded_menu_layout, viewGroup, false);
            if (this.f2167g == null) {
                this.f2167g = new C0446h(this);
            }
            this.f2164d.setAdapter(this.f2167g);
            this.f2164d.setOnItemClickListener(this);
        }
        return this.f2164d;
    }

    public ListAdapter m4048a() {
        if (this.f2167g == null) {
            this.f2167g = new C0446h(this);
        }
        return this.f2167g;
    }

    public void m4049a(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        if (this.f2164d != null) {
            this.f2164d.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void m4050a(C0374y c0374y) {
        this.f2169i = c0374y;
    }

    public void m4051b(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f2164d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public boolean collapseItemActionView(C0049i c0049i, C0448m c0448m) {
        return false;
    }

    public boolean expandItemActionView(C0049i c0049i, C0448m c0448m) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.f2170j;
    }

    public void initForMenu(Context context, C0049i c0049i) {
        if (this.f2165e != 0) {
            this.f2161a = new ContextThemeWrapper(context, this.f2165e);
            this.f2162b = LayoutInflater.from(this.f2161a);
        } else if (this.f2161a != null) {
            this.f2161a = context;
            if (this.f2162b == null) {
                this.f2162b = LayoutInflater.from(this.f2161a);
            }
        }
        this.f2163c = c0049i;
        if (this.f2167g != null) {
            this.f2167g.notifyDataSetChanged();
        }
    }

    public void onCloseMenu(C0049i c0049i, boolean z) {
        if (this.f2169i != null) {
            this.f2169i.onCloseMenu(c0049i, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f2163c.m110a(this.f2167g.m4052a(i), (C0051x) this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        m4051b((Bundle) parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.f2164d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        m4049a(bundle);
        return bundle;
    }

    public boolean onSubMenuSelected(ad adVar) {
        if (!adVar.hasVisibleItems()) {
            return false;
        }
        new C0447l(adVar).m4055a(null);
        if (this.f2169i != null) {
            this.f2169i.onOpenSubMenu(adVar);
        }
        return true;
    }

    public void updateMenuView(boolean z) {
        if (this.f2167g != null) {
            this.f2167g.notifyDataSetChanged();
        }
    }
}
