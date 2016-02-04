package android.support.v4.app;

import android.view.View;

/* renamed from: android.support.v4.app.n */
class C0142n extends C0141u {
    final /* synthetic */ Fragment f988a;

    C0142n(Fragment fragment) {
        this.f988a = fragment;
    }

    public View m1298a(int i) {
        if (this.f988a.f736J != null) {
            return this.f988a.f736J.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }

    public boolean m1299a() {
        return this.f988a.f736J != null;
    }
}
