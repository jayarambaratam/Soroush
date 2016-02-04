package mobi.mmdt.ott.view.registeration.activationcode;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p188d.C1760a;

class ab implements Runnable {
    final /* synthetic */ ActivationCodeFragment f7899a;

    ab(ActivationCodeFragment activationCodeFragment) {
        this.f7899a = activationCodeFragment;
    }

    public void run() {
        C1753a.m8688a(new C1760a()).m8701a(500).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7899a.f7893h);
        this.f7899a.f7896k = false;
        this.f7899a.f7886a = 61;
        this.f7899a.m10612e();
    }
}
