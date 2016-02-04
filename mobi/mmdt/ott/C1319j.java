package mobi.mmdt.ott;

import java.util.TimerTask;

/* renamed from: mobi.mmdt.ott.j */
class C1319j extends TimerTask {
    final /* synthetic */ C1318i f4592a;

    C1319j(C1318i c1318i) {
        this.f4592a = c1318i;
    }

    public void run() {
        new Thread(this.f4592a).start();
    }
}
