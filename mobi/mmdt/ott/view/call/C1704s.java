package mobi.mmdt.ott.view.call;

import mobi.mmdt.componentsutils.p079a.p080a.C1104b;

/* renamed from: mobi.mmdt.ott.view.call.s */
class C1704s implements Runnable {
    final /* synthetic */ CallActivity f5600a;

    C1704s(CallActivity callActivity) {
        this.f5600a = callActivity;
    }

    public void run() {
        while (this.f5600a.f5568o) {
            try {
                Thread.sleep(1000);
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
            }
            this.f5600a.runOnUiThread(new C1705t(this));
            try {
                Thread.sleep(1000);
            } catch (Throwable e2) {
                C1104b.m6368b((Object) this, e2);
            }
        }
    }
}
