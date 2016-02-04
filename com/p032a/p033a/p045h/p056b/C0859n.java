package com.p032a.p033a.p045h.p056b;

import android.util.Log;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.lang.ref.WeakReference;

/* renamed from: com.a.a.h.b.n */
class C0859n implements OnPreDrawListener {
    private final WeakReference<C0858m> f2978a;

    public C0859n(C0858m c0858m) {
        this.f2978a = new WeakReference(c0858m);
    }

    public boolean onPreDraw() {
        if (Log.isLoggable("ViewTarget", 2)) {
            Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
        }
        C0858m c0858m = (C0858m) this.f2978a.get();
        if (c0858m != null) {
            c0858m.m5177a();
        }
        return true;
    }
}
