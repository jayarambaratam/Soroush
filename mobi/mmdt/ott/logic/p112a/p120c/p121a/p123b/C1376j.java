package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.logic.p124j.C1545d;
import mobi.mmdt.ott.logic.p157e.p158a.C1505c;
import mobi.mmdt.ott.logic.p157e.p158a.C1507e;
import mobi.mmdt.ott.logic.p157e.p158a.C1508f;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1588h;
import mobi.mmdt.ott.provider.p170d.C1597b;
import mobi.mmdt.ott.provider.p170d.C1598c;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.provider.p170d.C1605j;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.j */
public class C1376j extends C0950c {
    private Context f4719a;
    private long f4720b;
    private long f4721c;
    private int f4722d;
    private boolean f4723e;
    private C1367c f4724f;
    private String f4725g;
    private String f4726h;
    private String f4727i;
    private String f4728j;
    private String f4729k;
    private C1605j f4730l;
    private C1505c f4731m;

    public C1376j(Context context, long j, boolean z) {
        super(new C0990j(C1396d.f4796b));
        this.f4719a = context;
        this.f4720b = j;
        this.f4723e = z;
    }

    private void m7167j() {
        this.f4724f = new C1377k(this);
    }

    private void m7168k() {
        this.f4724f = new C1378l(this);
    }

    protected boolean m7169a(Throwable th) {
        return false;
    }

    public void m7170b() {
        C1588h a = C1583c.m7968a(this.f4719a, this.f4720b);
        C1597b a2 = C1598c.m8102a(this.f4719a, a.m8048i().longValue());
        C1598c.m8095a(this.f4719a, a2.m8087e(), C1604i.TRANSMITTING);
        this.f4725g = a2.m8088f().getPath();
        this.f4721c = a2.m8087e();
        this.f4730l = a2.m8085c();
        this.f4726h = a.m8043d();
        this.f4728j = a.m8045f();
        this.f4727i = a.m8044e();
        this.f4729k = a.m8051l();
        this.f4722d = a2.m8086d();
        switch (C1379m.f4734a[a.m8049j().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f4731m = C1508f.m7612a(this.f4719a);
            case VideoSize.HVGA /*2*/:
                this.f4731m = C1507e.m7605a(this.f4719a);
            default:
        }
    }

    public void m7171c() {
        if (this.f4723e) {
            m7167j();
            C1597b a = C1598c.m8102a(this.f4719a, C1583c.m7968a(this.f4719a, this.f4720b).m8048i().longValue());
            if (a.m8084b().equals(C1604i.FINISHED) || a.m8084b().equals(C1604i.TRANSMITTING) || a.m8091i() == null || a.m8091i().isEmpty()) {
                C1545d.m7786a(this.f4719a).m7787a(this.f4721c, false, null);
                return;
            } else {
                C1545d.m7786a(this.f4719a).m7787a(this.f4721c, true, this.f4724f);
                return;
            }
        }
        m7168k();
        C1545d.m7786a(this.f4719a).m7792b(this.f4721c, false, this.f4724f);
    }

    protected void m7172d() {
    }
}
