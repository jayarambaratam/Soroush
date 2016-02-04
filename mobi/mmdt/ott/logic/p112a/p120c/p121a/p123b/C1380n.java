package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
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
import mobi.mmdt.ott.provider.p169c.C1593m;
import mobi.mmdt.ott.provider.p174h.C1629b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.n */
public class C1380n extends C0950c {
    private final Context f4736a;
    private String f4737b;
    private C1505c f4738c;
    private C1588h[] f4739d;

    public C1380n(Context context) {
        super(new C0990j(C1396d.f4796b));
        this.f4737b = null;
        this.f4736a = context;
    }

    public C1380n(Context context, String str) {
        super(new C0990j(C1396d.f4796b));
        this.f4737b = null;
        this.f4736a = context;
        this.f4737b = str;
    }

    private C1367c m7187a(C1588h c1588h) {
        return new C1381o(this, c1588h);
    }

    private void m7188a(String str) {
        C1593m h = C1583c.m7997h(this.f4736a, str);
        if (h != null && !h.equals(C1593m.DELIVERED) && !h.equals(C1593m.SEEN)) {
            C1583c.m7965a(this.f4736a, str, C1593m.PENDING_RETRANSMIT);
        }
    }

    protected boolean m7190a(Throwable th) {
        return false;
    }

    public void m7191b() {
        if (this.f4737b == null) {
            this.f4739d = C1583c.m7988d(this.f4736a, C1113a.m6421a() - 60000);
        } else {
            this.f4739d = C1583c.m7994f(this.f4736a, this.f4737b);
        }
    }

    public void m7192c() {
        for (C1588h c1588h : this.f4739d) {
            switch (C1382p.f4742a[c1588h.m8049j().ordinal()]) {
                case VideoSize.CIF /*1*/:
                    this.f4738c = C1508f.m7612a(this.f4736a);
                    break;
                case VideoSize.HVGA /*2*/:
                    this.f4738c = C1507e.m7605a(this.f4736a);
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    this.f4738c = C1506d.m7598a(this.f4736a);
                    break;
            }
            switch (C1382p.f4743b[c1588h.m8050k().ordinal()]) {
                case VideoSize.CIF /*1*/:
                    this.f4738c.m7592a(c1588h.m8043d(), c1588h.m8045f(), c1588h.m8044e(), c1588h.m8051l(), c1588h.m8046g());
                    m7188a(c1588h.m8044e());
                    break;
                case VideoSize.HVGA /*2*/:
                    String b = c1588h.m8041b();
                    if (!(b == null || b.isEmpty())) {
                        String a = C1629b.m8294a(b);
                        String b2 = C1629b.m8297b(b);
                        String c = C1629b.m8299c(b);
                        if (!(a == null || b2 == null || c == null || a.isEmpty() || b2.isEmpty() || c.isEmpty())) {
                            this.f4738c.m7595a(c1588h.m8043d(), c1588h.m8044e(), a, b2, c, c1588h.m8051l(), c1588h.m8046g());
                        }
                    }
                    m7188a(c1588h.m8044e());
                    break;
                default:
                    C1545d.m7786a(this.f4736a).m7792b(c1588h.m8048i().longValue(), false, m7187a(c1588h));
                    m7188a(c1588h.m8044e());
                    break;
            }
        }
    }

    protected void m7193d() {
    }
}
