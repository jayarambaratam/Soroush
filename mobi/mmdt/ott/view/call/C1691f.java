package mobi.mmdt.ott.view.call;

import android.os.Handler;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p187c.C1757a;

/* renamed from: mobi.mmdt.ott.view.call.f */
class C1691f implements Runnable {
    final /* synthetic */ CallActivity f5583a;

    C1691f(CallActivity callActivity) {
        this.f5583a = callActivity;
    }

    public void run() {
        C1753a.m8688a(new C1757a()).m8701a(250).m8704a(this.f5583a.f5567n);
        new Handler().postDelayed(new C1692g(this), 250);
    }
}
