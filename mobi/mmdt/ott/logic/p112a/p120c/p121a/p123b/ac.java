package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.logic.p124j.C1545d;
import mobi.mmdt.ott.logic.p157e.p158a.C1505c;
import mobi.mmdt.ott.logic.p157e.p158a.C1506d;
import mobi.mmdt.ott.logic.p157e.p158a.C1507e;
import mobi.mmdt.ott.logic.p157e.p158a.C1508f;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1588h;
import mobi.mmdt.ott.provider.p174h.C1629b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.ac */
public class ac extends C0950c {
    private Context f4672a;
    private C1505c f4673b;

    public ac(Context context) {
        super(new C0990j(C1396d.f4797c));
        this.f4672a = context;
    }

    private C1367c m7106a(C1588h c1588h) {
        return new ad(this, c1588h);
    }

    protected boolean m7108a(Throwable th) {
        return false;
    }

    public void m7109b() {
    }

    public void m7110c() {
        for (C1588h c1588h : C1583c.m7984c(this.f4672a)) {
            switch (ae.f4676a[c1588h.m8049j().ordinal()]) {
                case VideoSize.CIF /*1*/:
                    this.f4673b = C1508f.m7612a(this.f4672a);
                    break;
                case VideoSize.HVGA /*2*/:
                    this.f4673b = C1507e.m7605a(this.f4672a);
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    this.f4673b = C1506d.m7598a(this.f4672a);
                    break;
            }
            switch (ae.f4677b[c1588h.m8050k().ordinal()]) {
                case VideoSize.CIF /*1*/:
                    C1104b.m6366b((Object) ac.class, "resend message to " + c1588h.m8043d());
                    this.f4673b.m7592a(c1588h.m8043d(), c1588h.m8045f(), c1588h.m8044e(), c1588h.m8051l(), C1113a.m6421a());
                    break;
                case VideoSize.HVGA /*2*/:
                    String b = c1588h.m8041b();
                    if (!(b == null || b.isEmpty())) {
                        String a = C1629b.m8294a(b);
                        String b2 = C1629b.m8297b(b);
                        String c = C1629b.m8299c(b);
                        if (!(a == null || b2 == null || c == null || a.isEmpty() || b2.isEmpty() || c.isEmpty())) {
                            this.f4673b.m7595a(c1588h.m8043d(), c1588h.m8044e(), a, b2, c, c1588h.m8051l(), C1113a.m6421a());
                            break;
                        }
                    }
                default:
                    C1545d.m7786a(this.f4672a).m7792b(c1588h.m8048i().longValue(), false, m7106a(c1588h));
                    break;
            }
        }
    }

    protected void m7111d() {
    }
}
