package mobi.mmdt.ott.view.main.basenavigation;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p190f.C1766a;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.v */
class C2325v implements Runnable {
    final /* synthetic */ int f7659a;
    final /* synthetic */ C2322s f7660b;

    C2325v(C2322s c2322s, int i) {
        this.f7660b = c2322s;
        this.f7659a = i;
    }

    public void run() {
        C1753a.m8688a(new C1766a()).m8701a((long) (this.f7659a * 4)).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7660b.f7638c);
    }
}
