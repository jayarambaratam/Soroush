package mobi.mmdt.ott.logic.p160f;

import java.util.TimerTask;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.provider.p170d.C1598c;

/* renamed from: mobi.mmdt.ott.logic.f.b */
class C1522b extends TimerTask {
    final /* synthetic */ C1521a f5103a;

    C1522b(C1521a c1521a) {
        this.f5103a = c1521a;
    }

    public void run() {
        try {
            if (this.f5103a.f5098c != null) {
                C1598c.m8103b(this.f5103a.f5097b, this.f5103a.f5100e.m8087e(), this.f5103a.f5098c.getCurrentPosition());
            }
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }
}
