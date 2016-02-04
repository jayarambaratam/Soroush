package mobi.mmdt.ott.view.registeration.activationcode;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p186b.C1755b;
import mobi.mmdt.ott.view.components.p184a.p188d.C1760a;

class ae implements Runnable {
    final /* synthetic */ ac f7902a;

    ae(ac acVar) {
        this.f7902a = acVar;
    }

    public void run() {
        C1753a.m8688a(new C1760a()).m8701a(500).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7902a.f7900a.f7894i);
        C1753a.m8688a(new C1755b()).m8701a(500).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7902a.f7900a.f7892g);
    }
}
