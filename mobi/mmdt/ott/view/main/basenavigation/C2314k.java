package mobi.mmdt.ott.view.main.basenavigation;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p195i.C1780a;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.k */
class C2314k implements Runnable {
    final /* synthetic */ C2285a f7629a;

    C2314k(C2285a c2285a) {
        this.f7629a = c2285a;
    }

    public void run() {
        C1753a.m8688a(new C1780a()).m8701a(200).m8703a(new C2315l(this)).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7629a.f7536G);
    }
}
