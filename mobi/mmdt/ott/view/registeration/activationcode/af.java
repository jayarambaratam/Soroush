package mobi.mmdt.ott.view.registeration.activationcode;

import android.view.animation.AccelerateDecelerateInterpolator;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p185a.C1752a;

class af implements Runnable {
    final /* synthetic */ ActivationCodeFragment f7903a;

    af(ActivationCodeFragment activationCodeFragment) {
        this.f7903a = activationCodeFragment;
    }

    public void run() {
        C1753a.m8688a(new C1752a()).m8701a(750).m8702a(new AccelerateDecelerateInterpolator()).m8704a(this.f7903a.f7890e);
    }
}
