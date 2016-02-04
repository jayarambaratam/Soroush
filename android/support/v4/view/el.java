package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public class el {
    static final ev f1370a;
    private WeakReference<View> f1371b;
    private Runnable f1372c;
    private Runnable f1373d;
    private int f1374e;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1370a = new eu();
        } else if (i >= 19) {
            f1370a = new et();
        } else if (i >= 18) {
            f1370a = new er();
        } else if (i >= 16) {
            f1370a = new es();
        } else if (i >= 14) {
            f1370a = new ep();
        } else {
            f1370a = new en();
        }
    }

    el(View view) {
        this.f1372c = null;
        this.f1373d = null;
        this.f1374e = -1;
        this.f1371b = new WeakReference(view);
    }

    public long m2797a() {
        View view = (View) this.f1371b.get();
        return view != null ? f1370a.m2812a(this, view) : 0;
    }

    public el m2798a(float f) {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2813a(this, view, f);
        }
        return this;
    }

    public el m2799a(long j) {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2814a(this, view, j);
        }
        return this;
    }

    public el m2800a(fc fcVar) {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2815a(this, view, fcVar);
        }
        return this;
    }

    public el m2801a(fe feVar) {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2816a(this, view, feVar);
        }
        return this;
    }

    public el m2802a(Interpolator interpolator) {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2817a(this, view, interpolator);
        }
        return this;
    }

    public el m2803b(float f) {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2819b(this, view, f);
        }
        return this;
    }

    public el m2804b(long j) {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2820b(this, view, j);
        }
        return this;
    }

    public void m2805b() {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2818b(this, view);
        }
    }

    public el m2806c(float f) {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2822c(this, view, f);
        }
        return this;
    }

    public void m2807c() {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2821c(this, view);
        }
    }

    public el m2808d(float f) {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2823d(this, view, f);
        }
        return this;
    }

    public el m2809e(float f) {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2824e(this, view, f);
        }
        return this;
    }

    public el m2810f(float f) {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2825f(this, view, f);
        }
        return this;
    }

    public el m2811g(float f) {
        View view = (View) this.f1371b.get();
        if (view != null) {
            f1370a.m2826g(this, view, f);
        }
        return this;
    }
}
