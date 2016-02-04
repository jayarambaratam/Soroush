package android.support.v7.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.C0357z;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: android.support.v7.app.e */
public class C0380e implements C0357z {
    private final C0372g f1869a;
    private final DrawerLayout f1870b;
    private C0383j f1871c;
    private Drawable f1872d;
    private boolean f1873e;
    private boolean f1874f;
    private final int f1875g;
    private final int f1876h;
    private OnClickListener f1877i;
    private boolean f1878j;

    public C0380e(Activity activity, DrawerLayout drawerLayout, int i, int i2) {
        this(activity, null, drawerLayout, null, i, i2);
    }

    <T extends Drawable & C0383j> C0380e(Activity activity, Toolbar toolbar, DrawerLayout drawerLayout, T t, int i, int i2) {
        this.f1873e = true;
        this.f1878j = false;
        if (toolbar != null) {
            this.f1869a = new C0388n(toolbar);
            toolbar.setNavigationOnClickListener(new C0381f(this));
        } else if (activity instanceof C0371h) {
            this.f1869a = ((C0371h) activity).m3613b();
        } else if (VERSION.SDK_INT >= 18) {
            this.f1869a = new C0387m(null);
        } else if (VERSION.SDK_INT >= 11) {
            this.f1869a = new C0386l(null);
        } else {
            this.f1869a = new C0385k(activity);
        }
        this.f1870b = drawerLayout;
        this.f1875g = i;
        this.f1876h = i2;
        if (t == null) {
            this.f1871c = new C0384i(activity, this.f1869a.m3632b());
        } else {
            this.f1871c = (C0383j) t;
        }
        this.f1872d = m3808b();
    }

    private void m3799c() {
        if (this.f1870b.m2988g(8388611)) {
            this.f1870b.m2985e(8388611);
        } else {
            this.f1870b.m2983d(8388611);
        }
    }

    public void m3800a() {
        if (this.f1870b.m2986f(8388611)) {
            this.f1871c.m3819a(1.0f);
        } else {
            this.f1871c.m3819a(0.0f);
        }
        if (this.f1873e) {
            m3804a((Drawable) this.f1871c, this.f1870b.m2986f(8388611) ? this.f1876h : this.f1875g);
        }
    }

    public void m3801a(int i) {
    }

    public void m3802a(Configuration configuration) {
        if (!this.f1874f) {
            this.f1872d = m3808b();
        }
        m3800a();
    }

    public void m3803a(Drawable drawable) {
        if (drawable == null) {
            this.f1872d = m3808b();
            this.f1874f = false;
        } else {
            this.f1872d = drawable;
            this.f1874f = true;
        }
        if (!this.f1873e) {
            m3804a(this.f1872d, 0);
        }
    }

    void m3804a(Drawable drawable, int i) {
        if (!(this.f1878j || this.f1869a.m3633c())) {
            Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            this.f1878j = true;
        }
        this.f1869a.m3631a(drawable, i);
    }

    public void m3805a(View view) {
        this.f1871c.m3819a(1.0f);
        if (this.f1873e) {
            m3811c(this.f1876h);
        }
    }

    public void m3806a(View view, float f) {
        this.f1871c.m3819a(Math.min(1.0f, Math.max(0.0f, f)));
    }

    public void m3807a(boolean z) {
        if (z != this.f1873e) {
            if (z) {
                m3804a((Drawable) this.f1871c, this.f1870b.m2986f(8388611) ? this.f1876h : this.f1875g);
            } else {
                m3804a(this.f1872d, 0);
            }
            this.f1873e = z;
        }
    }

    Drawable m3808b() {
        return this.f1869a.m3629a();
    }

    public void m3809b(int i) {
        Drawable drawable = null;
        if (i != 0) {
            drawable = this.f1870b.getResources().getDrawable(i);
        }
        m3803a(drawable);
    }

    public void m3810b(View view) {
        this.f1871c.m3819a(0.0f);
        if (this.f1873e) {
            m3811c(this.f1875g);
        }
    }

    void m3811c(int i) {
        this.f1869a.m3630a(i);
    }
}
