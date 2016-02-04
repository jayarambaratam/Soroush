package mobi.mmdt.ott.view.registeration.activationcode;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p188d.C1761b;

class ad implements Runnable {
    final /* synthetic */ ac f7901a;

    ad(ac acVar) {
        this.f7901a = acVar;
    }

    public void run() {
        C1753a.m8688a(new C1761b()).m8701a(500).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7901a.f7900a.f7893h);
    }
}
