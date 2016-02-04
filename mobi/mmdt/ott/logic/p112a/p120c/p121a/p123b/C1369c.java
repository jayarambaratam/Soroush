package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.logic.p124j.C1543a;
import mobi.mmdt.ott.logic.p124j.C1545d;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p170d.C1605j;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.c */
class C1369c implements C1367c {
    final /* synthetic */ String f4702a;
    final /* synthetic */ Long f4703b;
    final /* synthetic */ C1368b f4704c;

    C1369c(C1368b c1368b, String str, Long l) {
        this.f4704c = c1368b;
        this.f4702a = str;
        this.f4703b = l;
    }

    public void m7138a(int i) {
    }

    public void m7139a(int i, int i2) {
    }

    public void m7140a(int i, Object obj) {
    }

    public void m7141a(int i, String str, String str2, String str3) {
    }

    public void m7142b(int i) {
    }

    public void m7143c(int i) {
        String str = this.f4702a;
        boolean z = true;
        switch (str.hashCode()) {
            case 796404377:
                if (str.equals("FILE_TYPE_IMAGE")) {
                    z = false;
                    break;
                }
                break;
            case 808293817:
                if (str.equals("FILE_TYPE_VIDEO")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case VideoSize.QCIF /*0*/:
                if (C1543a.m7782a(this.f4704c.f4699a, C1605j.IMAGE)) {
                    C1545d.m7786a(this.f4704c.f4699a).m7787a(this.f4703b.longValue(), false, null);
                }
            case VideoSize.CIF /*1*/:
                if (C1309a.m6934a(this.f4704c.f4699a).m6977t()) {
                    C1545d.m7786a(this.f4704c.f4699a).m7787a(this.f4703b.longValue(), false, null);
                }
            default:
        }
    }
}
