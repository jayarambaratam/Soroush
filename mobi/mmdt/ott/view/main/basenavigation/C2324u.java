package mobi.mmdt.ott.view.main.basenavigation;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p190f.C1767b;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.u */
class C2324u implements Runnable {
    final /* synthetic */ int f7657a;
    final /* synthetic */ C2322s f7658b;

    C2324u(C2322s c2322s, int i) {
        this.f7658b = c2322s;
        this.f7657a = i;
    }

    public void run() {
        C1753a.m8688a(new C1767b()).m8701a((long) (this.f7657a * 3)).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7658b.f7639d);
    }
}
