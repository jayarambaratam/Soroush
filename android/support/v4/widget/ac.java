package android.support.v4.widget;

import android.view.View;

class ac extends cw {
    final /* synthetic */ DrawerLayout f1573a;
    private final int f1574b;
    private ct f1575c;
    private final Runnable f1576d;

    public ac(DrawerLayout drawerLayout, int i) {
        this.f1573a = drawerLayout;
        this.f1576d = new ad(this);
        this.f1574b = i;
    }

    private void m3114b() {
        int i = 3;
        if (this.f1574b == 3) {
            i = 5;
        }
        View b = this.f1573a.m2976b(i);
        if (b != null) {
            this.f1573a.m2991i(b);
        }
    }

    private void m3115c() {
        View view;
        int i;
        int i2 = 0;
        int b = this.f1575c.m3398b();
        boolean z = this.f1574b == 3;
        if (z) {
            View b2 = this.f1573a.m2976b(3);
            if (b2 != null) {
                i2 = -b2.getWidth();
            }
            i2 += b;
            view = b2;
            i = i2;
        } else {
            i2 = this.f1573a.getWidth() - b;
            view = this.f1573a.m2976b(5);
            i = i2;
        }
        if (view == null) {
            return;
        }
        if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && this.f1573a.m2967a(view) == 0) {
            aa aaVar = (aa) view.getLayoutParams();
            this.f1575c.m3396a(view, i, view.getTop());
            aaVar.f1571c = true;
            this.f1573a.invalidate();
            m3114b();
            this.f1573a.m2980c();
        }
    }

    public int m3116a(View view) {
        return this.f1573a.m2989g(view) ? view.getWidth() : 0;
    }

    public int m3117a(View view, int i, int i2) {
        if (this.f1573a.m2975a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.f1573a.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    public void m3118a() {
        this.f1573a.removeCallbacks(this.f1576d);
    }

    public void m3119a(int i) {
        this.f1573a.m2971a(this.f1574b, i, this.f1575c.m3404c());
    }

    public void m3120a(int i, int i2) {
        this.f1573a.postDelayed(this.f1576d, 160);
    }

    public void m3121a(ct ctVar) {
        this.f1575c = ctVar;
    }

    public void m3122a(View view, float f, float f2) {
        int i;
        float d = this.f1573a.m2982d(view);
        int width = view.getWidth();
        if (this.f1573a.m2975a(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && d > 0.5f)) ? 0 : -width;
        } else {
            i = this.f1573a.getWidth();
            if (f < 0.0f || (f == 0.0f && d > 0.5f)) {
                i -= width;
            }
        }
        this.f1575c.m3394a(i, view.getTop());
        this.f1573a.invalidate();
    }

    public void m3123a(View view, int i, int i2, int i3, int i4) {
        int width = view.getWidth();
        float width2 = this.f1573a.m2975a(view, 3) ? ((float) (width + i)) / ((float) width) : ((float) (this.f1573a.getWidth() - i)) / ((float) width);
        this.f1573a.m2979b(view, width2);
        view.setVisibility(width2 == 0.0f ? 4 : 0);
        this.f1573a.invalidate();
    }

    public boolean m3124a(View view, int i) {
        return this.f1573a.m2989g(view) && this.f1573a.m2975a(view, this.f1574b) && this.f1573a.m2967a(view) == 0;
    }

    public int m3125b(View view, int i, int i2) {
        return view.getTop();
    }

    public void m3126b(int i, int i2) {
        View b = (i & 1) == 1 ? this.f1573a.m2976b(3) : this.f1573a.m2976b(5);
        if (b != null && this.f1573a.m2967a(b) == 0) {
            this.f1575c.m3393a(b, i2);
        }
    }

    public void m3127b(View view, int i) {
        ((aa) view.getLayoutParams()).f1571c = false;
        m3114b();
    }

    public boolean m3128b(int i) {
        return false;
    }
}
