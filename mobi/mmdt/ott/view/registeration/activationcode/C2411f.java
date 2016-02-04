package mobi.mmdt.ott.view.registeration.activationcode;

import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p143b.C1439c;

/* renamed from: mobi.mmdt.ott.view.registeration.activationcode.f */
class C2411f implements Runnable {
    final /* synthetic */ String f7909a;
    final /* synthetic */ C2409d f7910b;

    C2411f(C2409d c2409d, String str) {
        this.f7910b = c2409d;
        this.f7909a = str;
    }

    public void run() {
        C1494c.m7539a(new C1439c(this.f7910b.f7907a.getApplicationContext(), this.f7909a));
    }
}
