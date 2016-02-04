package mobi.mmdt.ott.view.main.basenavigation;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p190f.C1769d;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.t */
class C2323t implements Runnable {
    final /* synthetic */ int f7655a;
    final /* synthetic */ C2322s f7656b;

    C2323t(C2322s c2322s, int i) {
        this.f7656b = c2322s;
        this.f7655a = i;
    }

    public void run() {
        C1753a.m8688a(new C1769d()).m8701a((long) (this.f7655a * 2)).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7656b.f7637b);
    }
}
