package mobi.mmdt.ott.view.call;

import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1320a;

/* renamed from: mobi.mmdt.ott.view.call.i */
class C1694i implements Runnable {
    final /* synthetic */ C1320a f5586a;
    final /* synthetic */ CallActivity f5587b;

    C1694i(CallActivity callActivity, C1320a c1320a) {
        this.f5587b = callActivity;
        this.f5586a = c1320a;
    }

    public void run() {
        if (this.f5587b.f5563i != null) {
            this.f5587b.f5563i.m8536a(this.f5586a.m6994b());
        }
    }
}
