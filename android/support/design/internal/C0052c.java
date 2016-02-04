package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.C0041e;
import android.support.design.C0044h;
import android.support.v7.view.menu.C0047z;
import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0051x;
import android.support.v7.view.menu.C0374y;
import android.support.v7.view.menu.C0448m;
import android.support.v7.view.menu.ad;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* renamed from: android.support.design.internal.c */
public class C0052c implements C0051x {
    private NavigationMenuView f234a;
    private LinearLayout f235b;
    private C0374y f236c;
    private C0049i f237d;
    private int f238e;
    private C0056f f239f;
    private LayoutInflater f240g;
    private int f241h;
    private boolean f242i;
    private ColorStateList f243j;
    private ColorStateList f244k;
    private Drawable f245l;
    private int f246m;
    private int f247n;
    private final OnClickListener f248o;

    public C0052c() {
        this.f248o = new C0053d(this);
    }

    public int m150a() {
        return this.f235b.getChildCount();
    }

    public C0047z m151a(ViewGroup viewGroup) {
        if (this.f234a == null) {
            this.f234a = (NavigationMenuView) this.f240g.inflate(C0044h.design_navigation_menu, viewGroup, false);
            if (this.f239f == null) {
                this.f239f = new C0056f(this);
            }
            this.f235b = (LinearLayout) this.f240g.inflate(C0044h.design_navigation_item_header, this.f234a, false);
            this.f234a.setAdapter(this.f239f);
        }
        return this.f234a;
    }

    public void m152a(int i) {
        this.f238e = i;
    }

    public void m153a(ColorStateList colorStateList) {
        this.f244k = colorStateList;
        updateMenuView(false);
    }

    public void m154a(Drawable drawable) {
        this.f245l = drawable;
    }

    public void m155a(C0448m c0448m) {
        this.f239f.m171a(c0448m);
    }

    public void m156a(View view) {
        this.f235b.addView(view);
        this.f234a.setPadding(0, 0, 0, this.f234a.getPaddingBottom());
    }

    public void m157a(boolean z) {
        if (this.f239f != null) {
            this.f239f.m172a(z);
        }
    }

    public ColorStateList m158b() {
        return this.f244k;
    }

    public View m159b(int i) {
        View inflate = this.f240g.inflate(i, this.f235b, false);
        m156a(inflate);
        return inflate;
    }

    public void m160b(ColorStateList colorStateList) {
        this.f243j = colorStateList;
        updateMenuView(false);
    }

    public ColorStateList m161c() {
        return this.f243j;
    }

    public void m162c(int i) {
        this.f241h = i;
        this.f242i = true;
        updateMenuView(false);
    }

    public boolean collapseItemActionView(C0049i c0049i, C0448m c0448m) {
        return false;
    }

    public Drawable m163d() {
        return this.f245l;
    }

    public boolean expandItemActionView(C0049i c0049i, C0448m c0448m) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.f238e;
    }

    public void initForMenu(Context context, C0049i c0049i) {
        this.f240g = LayoutInflater.from(context);
        this.f237d = c0049i;
        Resources resources = context.getResources();
        this.f246m = resources.getDimensionPixelOffset(C0041e.design_navigation_padding_top_default);
        this.f247n = resources.getDimensionPixelOffset(C0041e.design_navigation_separator_vertical_padding);
    }

    public void onCloseMenu(C0049i c0049i, boolean z) {
        if (this.f236c != null) {
            this.f236c.onCloseMenu(c0049i, z);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f234a.restoreHierarchyState(sparseParcelableArray);
        }
        Bundle bundle2 = bundle.getBundle("android:menu:adapter");
        if (bundle2 != null) {
            this.f239f.m168a(bundle2);
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        if (this.f234a != null) {
            SparseArray sparseArray = new SparseArray();
            this.f234a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.f239f != null) {
            bundle.putBundle("android:menu:adapter", this.f239f.m173b());
        }
        return bundle;
    }

    public boolean onSubMenuSelected(ad adVar) {
        return false;
    }

    public void updateMenuView(boolean z) {
        if (this.f239f != null) {
            this.f239f.m167a();
        }
    }
}
