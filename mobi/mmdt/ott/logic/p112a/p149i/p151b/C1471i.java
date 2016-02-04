package mobi.mmdt.ott.logic.p112a.p149i.p151b;

import java.io.File;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.logic.p162h.C1540e;
import mobi.mmdt.ott.provider.p175i.C1635a;
import mobi.mmdt.ott.provider.p175i.C1640f;

/* renamed from: mobi.mmdt.ott.logic.a.i.b.i */
class C1471i implements C1367c {
    final /* synthetic */ C1470h f4923a;

    C1471i(C1470h c1470h) {
        this.f4923a = c1470h;
    }

    public void m7452a(int i) {
        C1635a.m8333a(this.f4923a.f4919a, this.f4923a.f4921c, C1640f.TRANSMITTING);
    }

    public void m7453a(int i, int i2) {
        C1635a.m8333a(this.f4923a.f4919a, this.f4923a.f4921c, C1640f.TRANSMITTING);
        C1635a.m8331a(this.f4923a.f4919a, this.f4923a.f4921c, i2);
    }

    public void m7454a(int i, Object obj) {
        C1635a.m8333a(this.f4923a.f4919a, this.f4923a.f4921c, C1640f.ERROR);
        C1635a.m8331a(this.f4923a.f4919a, this.f4923a.f4921c, 0);
        File file = new File(C1490b.m7516a(this.f4923a.f4919a).m7529g(this.f4923a.f4921c + ".zip"));
        if (file != null && file.isFile()) {
            file.delete();
        }
    }

    public void m7455a(int i, String str, String str2, String str3) {
    }

    public void m7456b(int i) {
        C1635a.m8333a(this.f4923a.f4919a, this.f4923a.f4921c, C1640f.CANCEL);
        C1635a.m8331a(this.f4923a.f4919a, this.f4923a.f4921c, 0);
        File file = new File(C1490b.m7516a(this.f4923a.f4919a).m7529g(this.f4923a.f4921c + ".zip"));
        if (file != null && file.isFile()) {
            file.delete();
        }
    }

    public void m7457c(int i) {
        new C1540e(this.f4923a.f4919a, null).m7780a(this.f4923a.f4920b.getPath(), this.f4923a.f4921c);
        C1635a.m8331a(this.f4923a.f4919a, this.f4923a.f4921c, 100);
        C1635a.m8333a(this.f4923a.f4919a, this.f4923a.f4921c, C1640f.READY);
    }
}
