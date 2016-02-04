package mobi.mmdt.ott.logic.p155b;

import java.util.TimerTask;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1380n;
import mobi.mmdt.ott.provider.p169c.C1583c;

/* renamed from: mobi.mmdt.ott.logic.b.c */
class C1489c extends TimerTask {
    final /* synthetic */ C1488b f5015a;

    C1489c(C1488b c1488b) {
        this.f5015a = c1488b;
    }

    public void run() {
        if (C1583c.m7985d(this.f5015a.f5012b) != 0) {
            C1494c.m7539a(new C1380n(this.f5015a.f5012b));
        }
    }
}
