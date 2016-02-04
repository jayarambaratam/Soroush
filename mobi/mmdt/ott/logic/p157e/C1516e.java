package mobi.mmdt.ott.logic.p157e;

import java.util.TimerTask;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1380n;

/* renamed from: mobi.mmdt.ott.logic.e.e */
class C1516e extends TimerTask {
    final /* synthetic */ String f5085a;
    final /* synthetic */ C1515d f5086b;

    C1516e(C1515d c1515d, String str) {
        this.f5086b = c1515d;
        this.f5085a = str;
    }

    public void run() {
        C1494c.m7539a(new C1380n(this.f5086b.f5084b, this.f5085a));
    }
}
