package mobi.mmdt.ott.view.call;

import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p186b.C1754a;

/* renamed from: mobi.mmdt.ott.view.call.d */
class C1689d implements Runnable {
    final /* synthetic */ CallActivity f5581a;

    C1689d(CallActivity callActivity) {
        this.f5581a = callActivity;
    }

    public void run() {
        this.f5581a.f5567n.setVisibility(0);
        C1753a.m8688a(new C1754a()).m8701a(250).m8704a(this.f5581a.f5567n);
    }
}
