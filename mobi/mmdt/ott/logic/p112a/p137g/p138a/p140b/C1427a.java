package mobi.mmdt.ott.logic.p112a.p137g.p138a.p140b;

import android.content.Context;
import android.content.Intent;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.io.IOException;
import mobi.mmdt.componentsutils.p079a.C1107a;
import mobi.mmdt.componentsutils.p079a.p081b.C1108a;
import mobi.mmdt.ott.logic.core.StartUpService;
import mobi.mmdt.ott.logic.notifications.C1557d;
import mobi.mmdt.ott.logic.notifications.notifsData.NewUpdateNotificationService;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p137g.p138a.p139a.C1425a;
import mobi.mmdt.ott.logic.p112a.p137g.p138a.p139a.C1426b;
import mobi.mmdt.ott.logic.p157e.C1518g;
import mobi.mmdt.ott.logic.p157e.p158a.C1504b;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.logic.p164k.C1548c;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1212o;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ak;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.C1606d;
import mobi.mmdt.ott.provider.p171e.C1607a;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.g.a.b.a */
public class C1427a extends C0950c {
    private Context f4859a;
    private C1309a f4860b;

    public C1427a(Context context) {
        super(new C0990j(C1396d.f4796b));
        this.f4859a = context;
        this.f4860b = C1309a.m6934a(this.f4859a);
    }

    protected boolean m7342a(Throwable th) {
        C0002c.m2a().m17c(new C1426b(th));
        return false;
    }

    public void m7343b() {
    }

    public void m7344c() {
        if (C1107a.m6377b(this.f4859a)) {
            this.f4860b.m6942b();
            C1212o a = C1546a.m7793a(this.f4859a).m7804a();
            C1546a.m7793a(this.f4859a).m7808c();
            if (a.m6709a() != null) {
                for (ak akVar : a.m6709a()) {
                    String b = C1309a.m6934a(this.f4859a).m6942b();
                    C1504b.m7583a(this.f4859a).m7586a(akVar.m6638c(), C1607a.m8152a(this.f4859a, b).m8202d() + " Leaved group", b, C1108a.m6381a(b));
                    C1518g.m7654a(this.f4859a).m7663b().m7507b(akVar.m6638c());
                }
            }
            C1548c.m7822a(this.f4859a).m7833b();
            this.f4860b.m6941a(true);
            StartUpService.m7553e(this.f4859a);
            C1557d.m7850a(this.f4859a);
            this.f4859a.stopService(new Intent(this.f4859a, NewUpdateNotificationService.class));
            C1606d.m8145a(this.f4859a).m8149a();
            this.f4860b.m6936A();
            C0002c.m2a().m17c(new C1425a());
            new Thread(new C1428b(this)).start();
            return;
        }
        throw new IOException();
    }

    protected void m7345d() {
    }
}
