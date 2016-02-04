package android.support.v7.app;

import android.support.v4.view.cb;
import android.support.v7.view.C0376c;
import android.support.v7.view.C0378b;
import android.view.Menu;
import android.view.MenuItem;

class ba implements C0376c {
    final /* synthetic */ AppCompatDelegateImplV7 f1791a;
    private C0376c f1792b;

    public ba(AppCompatDelegateImplV7 appCompatDelegateImplV7, C0376c c0376c) {
        this.f1791a = appCompatDelegateImplV7;
        this.f1792b = c0376c;
    }

    public void m3649a(C0378b c0378b) {
        this.f1792b.m3645a(c0378b);
        if (this.f1791a.f1756o != null) {
            this.f1791a.b.getDecorView().removeCallbacks(this.f1791a.f1757p);
        }
        if (this.f1791a.f1755n != null) {
            this.f1791a.m3536t();
            this.f1791a.f1758q = cb.m2442s(this.f1791a.f1755n).m2798a(0.0f);
            this.f1791a.f1758q.m2800a(new bb(this));
        }
        if (this.f1791a.e != null) {
            this.f1791a.e.m3592b(this.f1791a.f1754m);
        }
        this.f1791a.f1754m = null;
    }

    public boolean m3650a(C0378b c0378b, Menu menu) {
        return this.f1792b.m3646a(c0378b, menu);
    }

    public boolean m3651a(C0378b c0378b, MenuItem menuItem) {
        return this.f1792b.m3647a(c0378b, menuItem);
    }

    public boolean m3652b(C0378b c0378b, Menu menu) {
        return this.f1792b.m3648b(c0378b, menu);
    }
}
