package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import java.io.File;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.logic.p157e.p158a.C1506d;
import mobi.mmdt.ott.logic.p157e.p158a.C1507e;
import mobi.mmdt.ott.logic.p157e.p158a.C1508f;
import mobi.mmdt.ott.p089b.p094b.C1156c;
import mobi.mmdt.ott.p089b.p094b.C1157d;
import mobi.mmdt.ott.provider.p169c.C1588h;
import mobi.mmdt.ott.provider.p170d.C1597b;
import mobi.mmdt.ott.provider.p170d.C1598c;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.ad */
class ad implements C1367c {
    final /* synthetic */ C1588h f4674a;
    final /* synthetic */ ac f4675b;

    ad(ac acVar, C1588h c1588h) {
        this.f4675b = acVar;
        this.f4674a = c1588h;
    }

    public void m7112a(int i) {
    }

    public void m7113a(int i, int i2) {
    }

    public void m7114a(int i, Object obj) {
    }

    public void m7115a(int i, String str, String str2, String str3) {
        Throwable e;
        switch (ae.f4676a[this.f4674a.m8049j().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f4675b.f4673b = C1508f.m7612a(this.f4675b.f4672a);
                break;
            case VideoSize.HVGA /*2*/:
                this.f4675b.f4673b = C1507e.m7605a(this.f4675b.f4672a);
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f4675b.f4673b = C1506d.m7598a(this.f4675b.f4672a);
                break;
        }
        C1597b a = C1598c.m8102a(this.f4675b.f4672a, this.f4674a.m8048i().longValue());
        File file = new File(String.valueOf(a.m8088f()));
        long a2 = C1113a.m6421a();
        try {
            switch (ae.f4678c[a.m8085c().ordinal()]) {
                case VideoSize.CIF /*1*/:
                    this.f4675b.f4673b.m7597a(this.f4674a.m8043d(), this.f4674a.m8044e(), this.f4674a.m8045f(), str3, str, str2, Long.valueOf(file.length()), file.getName(), this.f4674a.m8051l(), a2);
                case VideoSize.HVGA /*2*/:
                    this.f4675b.f4673b.m7593a(this.f4674a.m8043d(), this.f4674a.m8044e(), str3, str, Long.valueOf(file.length()), file.getName(), Integer.valueOf(a.m8086d()), this.f4674a.m8051l(), a2);
                case Version.API03_CUPCAKE_15 /*3*/:
                    this.f4675b.f4673b.m7596a(this.f4674a.m8043d(), this.f4674a.m8044e(), this.f4674a.m8045f(), str3, str, str2, Long.valueOf(file.length()), file.getName(), Integer.valueOf(a.m8086d()), this.f4674a.m8051l(), a2);
                case Version.API04_DONUT_16 /*4*/:
                    this.f4675b.f4673b.m7594a(this.f4674a.m8043d(), this.f4674a.m8044e(), str3, str, Long.valueOf(file.length()), file.getName(), this.f4674a.m8051l(), a2);
                default:
            }
        } catch (C1156c e2) {
            e = e2;
            C1104b.m6367b(ac.class, "NotConnectedException", e);
        } catch (C1157d e3) {
            e = e3;
            C1104b.m6367b(ac.class, "NotConnectedException", e);
        }
    }

    public void m7116b(int i) {
    }

    public void m7117c(int i) {
    }
}
