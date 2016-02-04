package mobi.mmdt.ott.view.registeration.activationcode;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.activationcode.k */
class C2416k implements Runnable {
    final /* synthetic */ ActivationCodeActivity f7915a;

    C2416k(ActivationCodeActivity activationCodeActivity) {
        this.f7915a = activationCodeActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2417l(this), 50);
        new Handler().postDelayed(new C2418m(this), 100);
    }
}
