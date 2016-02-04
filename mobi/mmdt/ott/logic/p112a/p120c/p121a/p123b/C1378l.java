package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import java.io.File;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.p089b.p094b.C1156c;
import mobi.mmdt.ott.p089b.p094b.C1157d;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.l */
class C1378l implements C1367c {
    final /* synthetic */ C1376j f4733a;

    C1378l(C1376j c1376j) {
        this.f4733a = c1376j;
    }

    public void m7179a(int i) {
    }

    public void m7180a(int i, int i2) {
    }

    public void m7181a(int i, Object obj) {
    }

    public void m7182a(int i, String str, String str2, String str3) {
        Throwable e;
        File file = new File(this.f4733a.f4725g);
        try {
            switch (C1379m.f4735b[this.f4733a.f4730l.ordinal()]) {
                case VideoSize.CIF /*1*/:
                    this.f4733a.f4731m.m7597a(this.f4733a.f4726h, this.f4733a.f4727i, this.f4733a.f4728j, str3, str, str2, Long.valueOf(file.length()), file.getName(), this.f4733a.f4729k, C1113a.m6421a());
                case VideoSize.HVGA /*2*/:
                    this.f4733a.f4731m.m7596a(this.f4733a.f4726h, this.f4733a.f4727i, this.f4733a.f4728j, str3, str, str2, Long.valueOf(file.length()), file.getName(), Integer.valueOf(this.f4733a.f4722d), this.f4733a.f4729k, C1113a.m6421a());
                case Version.API03_CUPCAKE_15 /*3*/:
                    this.f4733a.f4731m.m7593a(this.f4733a.f4726h, this.f4733a.f4727i, str3, str, Long.valueOf(file.length()), file.getName(), Integer.valueOf(this.f4733a.f4722d), this.f4733a.f4729k, C1113a.m6421a());
                case Version.API04_DONUT_16 /*4*/:
                    this.f4733a.f4731m.m7593a(this.f4733a.f4726h, this.f4733a.f4727i, str3, str, Long.valueOf(file.length()), file.getName(), Integer.valueOf(this.f4733a.f4722d), this.f4733a.f4729k, C1113a.m6421a());
                case Version.API05_ECLAIR_20 /*5*/:
                    this.f4733a.f4731m.m7594a(this.f4733a.f4726h, this.f4733a.f4727i, str3, str, Long.valueOf(file.length()), file.getName(), this.f4733a.f4729k, C1113a.m6421a());
                default:
            }
        } catch (C1156c e2) {
            e = e2;
            C1104b.m6367b(C1376j.class, "NotConnectedException", e);
        } catch (C1157d e3) {
            e = e3;
            C1104b.m6367b(C1376j.class, "NotConnectedException", e);
        }
    }

    public void m7183b(int i) {
    }

    public void m7184c(int i) {
    }
}
