package mobi.mmdt.ott.view.main.basenavigation;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p196j.C1781a;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.m */
class C2316m implements Runnable {
    final /* synthetic */ C2285a f7631a;

    C2316m(C2285a c2285a) {
        this.f7631a = c2285a;
    }

    public void run() {
        C1753a.m8688a(new C1781a()).m8701a(200).m8705b(new C2317n(this)).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7631a.f7536G);
    }
}
