package android.support.v7.app;

import android.content.Context;
import android.support.v7.view.C0376c;
import android.support.v7.view.C0378b;
import android.support.v7.view.C0433i;
import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0074j;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class cc extends C0378b implements C0074j {
    final /* synthetic */ by f1864a;
    private final Context f1865b;
    private final C0049i f1866c;
    private C0376c f1867d;
    private WeakReference<View> f1868e;

    public cc(by byVar, Context context, C0376c c0376c) {
        this.f1864a = byVar;
        this.f1865b = context;
        this.f1867d = c0376c;
        this.f1866c = new C0049i(context).m93a(1);
        this.f1866c.m101a((C0074j) this);
    }

    public MenuInflater m3776a() {
        return new C0433i(this.f1865b);
    }

    public void m3777a(int i) {
        m3783b(this.f1864a.f1844l.getResources().getString(i));
    }

    public void m3778a(View view) {
        this.f1864a.f1851s.setCustomView(view);
        this.f1868e = new WeakReference(view);
    }

    public void m3779a(CharSequence charSequence) {
        this.f1864a.f1851s.setSubtitle(charSequence);
    }

    public void m3780a(boolean z) {
        super.m3764a(z);
        this.f1864a.f1851s.setTitleOptional(z);
    }

    public Menu m3781b() {
        return this.f1866c;
    }

    public void m3782b(int i) {
        m3779a(this.f1864a.f1844l.getResources().getString(i));
    }

    public void m3783b(CharSequence charSequence) {
        this.f1864a.f1851s.setTitle(charSequence);
    }

    public void m3784c() {
        if (this.f1864a.f1837a == this) {
            if (by.m3719b(this.f1864a.f1831D, this.f1864a.f1832E, false)) {
                this.f1867d.m3645a(this);
            } else {
                this.f1864a.f1838b = this;
                this.f1864a.f1839c = this.f1867d;
            }
            this.f1867d = null;
            this.f1864a.m3756i(false);
            this.f1864a.f1851s.closeMode();
            this.f1864a.f1850r.getViewGroup().sendAccessibilityEvent(32);
            this.f1864a.f1848p.setHideOnContentScrollEnabled(this.f1864a.f1840d);
            this.f1864a.f1837a = null;
        }
    }

    public void m3785d() {
        if (this.f1864a.f1837a == this) {
            this.f1866c.m127g();
            try {
                this.f1867d.m3648b(this, this.f1866c);
            } finally {
                this.f1866c.m128h();
            }
        }
    }

    public boolean m3786e() {
        this.f1866c.m127g();
        try {
            boolean a = this.f1867d.m3646a((C0378b) this, this.f1866c);
            return a;
        } finally {
            this.f1866c.m128h();
        }
    }

    public CharSequence m3787f() {
        return this.f1864a.f1851s.getTitle();
    }

    public CharSequence m3788g() {
        return this.f1864a.f1851s.getSubtitle();
    }

    public boolean m3789h() {
        return this.f1864a.f1851s.isTitleOptional();
    }

    public View m3790i() {
        return this.f1868e != null ? (View) this.f1868e.get() : null;
    }

    public boolean onMenuItemSelected(C0049i c0049i, MenuItem menuItem) {
        return this.f1867d != null ? this.f1867d.m3647a((C0378b) this, menuItem) : false;
    }

    public void onMenuModeChange(C0049i c0049i) {
        if (this.f1867d != null) {
            m3785d();
            this.f1864a.f1851s.showOverflowMenu();
        }
    }
}
