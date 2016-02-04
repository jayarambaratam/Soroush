package mobi.mmdt.ott.view.registeration.profileinfo;

import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p147h.C1451b;
import mobi.mmdt.ott.p109d.p111b.C1309a;

/* renamed from: mobi.mmdt.ott.view.registeration.profileinfo.d */
class C2491d implements Runnable {
    final /* synthetic */ C2489b f8085a;

    C2491d(C2489b c2489b) {
        this.f8085a = c2489b;
    }

    public void run() {
        String b = C1309a.m6934a(this.f8085a.f8083a.getApplicationContext()).m6942b();
        C1494c.m7539a(new C1451b(this.f8085a.f8083a.getApplicationContext(), new String[]{b}, true, true));
    }
}
