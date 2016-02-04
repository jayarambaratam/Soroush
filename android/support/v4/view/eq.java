package android.support.v4.view;

import android.view.View;

class eq implements fc {
    el f1380a;

    eq(el elVar) {
        this.f1380a = elVar;
    }

    public void onAnimationCancel(View view) {
        Object tag = view.getTag(2113929216);
        fc fcVar = tag instanceof fc ? (fc) tag : null;
        if (fcVar != null) {
            fcVar.onAnimationCancel(view);
        }
    }

    public void onAnimationEnd(View view) {
        if (this.f1380a.f1374e >= 0) {
            cb.m2396a(view, this.f1380a.f1374e, null);
            this.f1380a.f1374e = -1;
        }
        if (this.f1380a.f1373d != null) {
            this.f1380a.f1373d.run();
        }
        Object tag = view.getTag(2113929216);
        fc fcVar = tag instanceof fc ? (fc) tag : null;
        if (fcVar != null) {
            fcVar.onAnimationEnd(view);
        }
    }

    public void onAnimationStart(View view) {
        if (this.f1380a.f1374e >= 0) {
            cb.m2396a(view, 2, null);
        }
        if (this.f1380a.f1372c != null) {
            this.f1380a.f1372c.run();
        }
        Object tag = view.getTag(2113929216);
        fc fcVar = tag instanceof fc ? (fc) tag : null;
        if (fcVar != null) {
            fcVar.onAnimationStart(view);
        }
    }
}
