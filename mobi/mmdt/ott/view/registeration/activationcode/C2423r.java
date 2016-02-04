package mobi.mmdt.ott.view.registeration.activationcode;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.activationcode.r */
class C2423r implements Runnable {
    final /* synthetic */ ActivationCodeActivity f7922a;

    C2423r(ActivationCodeActivity activationCodeActivity) {
        this.f7922a = activationCodeActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2424s(this), 50);
        new Handler().postDelayed(new C2425t(this), 100);
    }
}
