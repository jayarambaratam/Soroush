package mobi.mmdt.ott.view.registeration.activationcode;

import android.os.Handler;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1430b;

/* renamed from: mobi.mmdt.ott.view.registeration.activationcode.u */
class C2426u implements Runnable {
    final /* synthetic */ C1430b f7925a;
    final /* synthetic */ ActivationCodeActivity f7926b;

    C2426u(ActivationCodeActivity activationCodeActivity, C1430b c1430b) {
        this.f7926b = activationCodeActivity;
        this.f7925a = c1430b;
    }

    public void run() {
        new Handler().postDelayed(new C2427v(this), 50);
        new Handler().postDelayed(new C2428w(this), 100);
    }
}
