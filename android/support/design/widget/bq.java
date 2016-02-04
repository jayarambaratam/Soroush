package android.support.design.widget;

import java.lang.ref.WeakReference;

class bq {
    private final WeakReference<bp> f506a;
    private int f507b;

    bq(int i, bp bpVar) {
        this.f506a = new WeakReference(bpVar);
        this.f507b = i;
    }

    boolean m596a(bp bpVar) {
        return bpVar != null && this.f506a.get() == bpVar;
    }
}
