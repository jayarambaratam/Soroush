package mobi.mmdt.ott.view.conversation.activities;

import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.l */
class C2004l implements Runnable {
    final /* synthetic */ C2003k f6543a;

    C2004l(C2003k c2003k) {
        this.f6543a = c2003k;
    }

    public void run() {
        if (this.f6543a.f6541a instanceof C2152a) {
            C1583c.m7981c(this.f6543a.f6542b.getApplicationContext(), ((C2152a) this.f6543a.f6541a).m9847k());
        }
    }
}
