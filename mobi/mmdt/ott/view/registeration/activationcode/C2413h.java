package mobi.mmdt.ott.view.registeration.activationcode;

import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.registeration.activationcode.h */
class C2413h implements Runnable {
    final /* synthetic */ ActivationCodeActivity f7912a;

    C2413h(ActivationCodeActivity activationCodeActivity) {
        this.f7912a = activationCodeActivity;
    }

    public void run() {
        new Handler().postDelayed(new C2414i(this), 50);
        new Handler().postDelayed(new C2415j(this), 100);
    }
}
