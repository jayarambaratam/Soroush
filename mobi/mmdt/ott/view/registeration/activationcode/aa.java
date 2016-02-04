package mobi.mmdt.ott.view.registeration.activationcode;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p187c.C1758b;
import mobi.mmdt.ott.view.components.p184a.p188d.C1761b;

class aa implements Runnable {
    final /* synthetic */ ActivationCodeFragment f7898a;

    aa(ActivationCodeFragment activationCodeFragment) {
        this.f7898a = activationCodeFragment;
    }

    public void run() {
        C1753a.m8688a(new C1761b()).m8701a(500).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7898a.f7894i);
        C1753a.m8688a(new C1758b()).m8701a(500).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7898a.f7892g);
    }
}
