package mobi.mmdt.ott.view.registeration.profileinfo;

import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p144c.p146b.C1444a;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.registeration.profileinfo.g */
class C2494g implements Runnable {
    final /* synthetic */ C2492e f8088a;

    C2494g(C2492e c2492e) {
        this.f8088a = c2492e;
    }

    public void run() {
        String d = this.f8088a.f8086a.m;
        String str = BuildConfig.FLAVOR;
        String str2 = BuildConfig.FLAVOR;
        if (!(this.f8088a.f8086a.f8074s == null || this.f8088a.f8086a.f8074s.getText() == null || this.f8088a.f8086a.f8074s.getText().toString().trim().isEmpty())) {
            str = this.f8088a.f8086a.f8074s.getText().toString().trim();
        }
        if (!(this.f8088a.f8086a.f8075t == null || this.f8088a.f8086a.f8075t.getText() == null || this.f8088a.f8086a.f8075t.getText().toString().trim().isEmpty())) {
            str2 = this.f8088a.f8086a.f8075t.getText().toString().trim();
        }
        C1494c.m7539a(new C1444a(this.f8088a.f8086a.getApplicationContext(), d, str, str2, this.f8088a.f8086a.n));
    }
}
