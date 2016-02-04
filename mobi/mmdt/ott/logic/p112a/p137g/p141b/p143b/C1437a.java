package mobi.mmdt.ott.logic.p112a.p137g.p141b.p143b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1431c;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1432d;
import mobi.mmdt.ott.logic.p164k.C1548c;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1205h;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.g.b.b.a */
public class C1437a extends C0950c {
    private Context f4863a;

    public C1437a(Context context) {
        super(new C0990j(C1396d.f4796b));
        this.f4863a = context;
    }

    protected boolean m7347a(Throwable th) {
        C0002c.m2a().m17c(new C1432d(th));
        return false;
    }

    public void m7348b() {
    }

    public void m7349c() {
        C1205h a = C1548c.m7822a(this.f4863a).m7831a();
        C1104b.m6366b((Object) "CountryJOB", "CountryCode: " + a.m6702a());
        C1104b.m6366b((Object) "CountryJOB", "CountryPrefix: " + a.m6703b());
        C0002c.m2a().m17c(new C1431c(a));
    }

    protected void m7350d() {
    }
}
