package mobi.mmdt.ott.view.main.basenavigation;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p190f.C1768c;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.w */
class C2339w implements Runnable {
    final /* synthetic */ int f7729a;
    final /* synthetic */ C2322s f7730b;

    C2339w(C2322s c2322s, int i) {
        this.f7730b = c2322s;
        this.f7729a = i;
    }

    public void run() {
        C1753a.m8688a(new C1768c()).m8701a((long) (this.f7729a * 5)).m8702a(new AccelerateDecelerateInterpolator()).m8705b(new C2340x(this)).m8704a(this.f7730b.f7640e);
    }
}
