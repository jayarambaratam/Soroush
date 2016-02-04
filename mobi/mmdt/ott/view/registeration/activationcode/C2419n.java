package mobi.mmdt.ott.view.registeration.activationcode;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.activationcode.n */
class C2419n implements Runnable {
    final /* synthetic */ ActivationCodeActivity f7918a;

    C2419n(ActivationCodeActivity activationCodeActivity) {
        this.f7918a = activationCodeActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2420o(this), 50);
        new Handler().postDelayed(new C2421p(this), 100);
    }
}
