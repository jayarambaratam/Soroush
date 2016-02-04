package android.support.v4.app;

import android.support.v4.p016f.C0223a;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: android.support.v4.app.g */
class C0134g implements OnPreDrawListener {
    final /* synthetic */ View f961a;
    final /* synthetic */ Object f962b;
    final /* synthetic */ ArrayList f963c;
    final /* synthetic */ C0137j f964d;
    final /* synthetic */ boolean f965e;
    final /* synthetic */ Fragment f966f;
    final /* synthetic */ Fragment f967g;
    final /* synthetic */ C0132e f968h;

    C0134g(C0132e c0132e, View view, Object obj, ArrayList arrayList, C0137j c0137j, boolean z, Fragment fragment, Fragment fragment2) {
        this.f968h = c0132e;
        this.f961a = view;
        this.f962b = obj;
        this.f963c = arrayList;
        this.f964d = c0137j;
        this.f965e = z;
        this.f966f = fragment;
        this.f967g = fragment2;
    }

    public boolean onPreDraw() {
        this.f961a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f962b != null) {
            ao.m1074a(this.f962b, this.f963c);
            this.f963c.clear();
            C0223a a = this.f968h.m1252a(this.f964d, this.f965e, this.f966f);
            ao.m1071a(this.f962b, this.f964d.f986d, (Map) a, this.f963c);
            this.f968h.m1266a(a, this.f964d);
            this.f968h.m1262a(this.f964d, this.f966f, this.f967g, this.f965e, a);
        }
        return true;
    }
}
