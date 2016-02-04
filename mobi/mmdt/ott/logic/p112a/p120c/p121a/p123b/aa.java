package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import java.io.File;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p122a.C1365b;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.provider.p170d.C1598c;
import mobi.mmdt.ott.provider.p170d.C1604i;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.aa */
class aa implements C1367c {
    final /* synthetic */ int f4668a;
    final /* synthetic */ C1392z f4669b;

    aa(C1392z c1392z, int i) {
        this.f4669b = c1392z;
        this.f4668a = i;
    }

    public void m7098a(int i) {
    }

    public void m7099a(int i, int i2) {
    }

    public void m7100a(int i, Object obj) {
    }

    public void m7101a(int i, String str, String str2, String str3) {
        File file = new File(this.f4669b.f4781c);
        long a = C1113a.m6421a();
        try {
            switch (ab.f4671b[this.f4669b.f4785g.ordinal()]) {
                case VideoSize.CIF /*1*/:
                    this.f4669b.f4789k.m7597a((String) this.f4669b.f4784f.get(this.f4668a), (String) this.f4669b.f4783e.get(this.f4668a), this.f4669b.f4782d, str3, str, str2, Long.valueOf(file.length()), file.getName(), this.f4669b.f4791m, a);
                case VideoSize.HVGA /*2*/:
                    this.f4669b.f4789k.m7596a((String) this.f4669b.f4784f.get(this.f4668a), (String) this.f4669b.f4783e.get(this.f4668a), this.f4669b.f4782d, str3, str, str2, Long.valueOf(file.length()), file.getName(), Integer.valueOf(this.f4669b.f4788j), this.f4669b.f4791m, a);
                case Version.API03_CUPCAKE_15 /*3*/:
                    this.f4669b.f4789k.m7593a((String) this.f4669b.f4784f.get(this.f4668a), (String) this.f4669b.f4783e.get(this.f4668a), str3, str, Long.valueOf(file.length()), file.getName(), Integer.valueOf(this.f4669b.f4788j), this.f4669b.f4791m, a);
                case Version.API04_DONUT_16 /*4*/:
                    this.f4669b.f4789k.m7593a((String) this.f4669b.f4784f.get(this.f4668a), (String) this.f4669b.f4783e.get(this.f4668a), str3, str, Long.valueOf(file.length()), file.getName(), Integer.valueOf(this.f4669b.f4788j), this.f4669b.f4791m, a);
                case Version.API05_ECLAIR_20 /*5*/:
                    this.f4669b.f4789k.m7594a((String) this.f4669b.f4784f.get(this.f4668a), (String) this.f4669b.f4783e.get(this.f4668a), str3, str, Long.valueOf(file.length()), file.getName(), this.f4669b.f4791m, a);
                default:
            }
        } catch (Throwable e) {
            C1104b.m6367b(C1392z.class, "NotConnectedException", e);
            C1598c.m8095a(this.f4669b.f4779a, this.f4669b.f4786h, C1604i.ERROR);
            C0002c.m2a().m17c(new C1365b(e));
        } catch (Throwable e2) {
            C1104b.m6367b(C1392z.class, "ProtocolException", e2);
            C1598c.m8095a(this.f4669b.f4779a, this.f4669b.f4786h, C1604i.ERROR);
            C0002c.m2a().m17c(new C1365b(e2));
        }
    }

    public void m7102b(int i) {
    }

    public void m7103c(int i) {
    }
}
