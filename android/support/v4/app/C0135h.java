package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: android.support.v4.app.h */
class C0135h implements OnPreDrawListener {
    final /* synthetic */ View f969a;
    final /* synthetic */ C0137j f970b;
    final /* synthetic */ int f971c;
    final /* synthetic */ Object f972d;
    final /* synthetic */ C0132e f973e;

    C0135h(C0132e c0132e, View view, C0137j c0137j, int i, Object obj) {
        this.f973e = c0132e;
        this.f969a = view;
        this.f970b = c0137j;
        this.f971c = i;
        this.f972d = obj;
    }

    public boolean onPreDraw() {
        this.f969a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f973e.m1261a(this.f970b, this.f971c, this.f972d);
        return true;
    }
}
