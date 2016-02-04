package android.support.v4.view;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.WeakHashMap;

class en implements ev {
    WeakHashMap<View, Runnable> f1375a;

    en() {
        this.f1375a = null;
    }

    private void m2828a(View view) {
        if (this.f1375a != null) {
            Runnable runnable = (Runnable) this.f1375a.get(view);
            if (runnable != null) {
                view.removeCallbacks(runnable);
            }
        }
    }

    private void m2829d(el elVar, View view) {
        Object tag = view.getTag(2113929216);
        fc fcVar = tag instanceof fc ? (fc) tag : null;
        Runnable a = elVar.f1372c;
        Runnable b = elVar.f1373d;
        if (a != null) {
            a.run();
        }
        if (fcVar != null) {
            fcVar.onAnimationStart(view);
            fcVar.onAnimationEnd(view);
        }
        if (b != null) {
            b.run();
        }
        if (this.f1375a != null) {
            this.f1375a.remove(view);
        }
    }

    private void m2830e(el elVar, View view) {
        Runnable runnable = this.f1375a != null ? (Runnable) this.f1375a.get(view) : null;
        if (runnable == null) {
            runnable = new eo(elVar, view, null);
            if (this.f1375a == null) {
                this.f1375a = new WeakHashMap();
            }
            this.f1375a.put(view, runnable);
        }
        view.removeCallbacks(runnable);
        view.post(runnable);
    }

    public long m2831a(el elVar, View view) {
        return 0;
    }

    public void m2832a(el elVar, View view, float f) {
        m2830e(elVar, view);
    }

    public void m2833a(el elVar, View view, long j) {
    }

    public void m2834a(el elVar, View view, fc fcVar) {
        view.setTag(2113929216, fcVar);
    }

    public void m2835a(el elVar, View view, fe feVar) {
    }

    public void m2836a(el elVar, View view, Interpolator interpolator) {
    }

    public void m2837b(el elVar, View view) {
        m2830e(elVar, view);
    }

    public void m2838b(el elVar, View view, float f) {
        m2830e(elVar, view);
    }

    public void m2839b(el elVar, View view, long j) {
    }

    public void m2840c(el elVar, View view) {
        m2828a(view);
        m2829d(elVar, view);
    }

    public void m2841c(el elVar, View view, float f) {
        m2830e(elVar, view);
    }

    public void m2842d(el elVar, View view, float f) {
        m2830e(elVar, view);
    }

    public void m2843e(el elVar, View view, float f) {
        m2830e(elVar, view);
    }

    public void m2844f(el elVar, View view, float f) {
        m2830e(elVar, view);
    }

    public void m2845g(el elVar, View view, float f) {
        m2830e(elVar, view);
    }
}
