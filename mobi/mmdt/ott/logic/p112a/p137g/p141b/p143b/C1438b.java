package mobi.mmdt.ott.logic.p112a.p137g.p141b.p143b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1435g;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1436h;
import mobi.mmdt.ott.logic.p164k.C1548c;
import mobi.mmdt.ott.p095c.p096a.C1247b;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import org.linphone.core.VideoSize;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.g.b.b.b */
public class C1438b extends C0950c {
    private String f4864a;
    private String f4865b;
    private Context f4866c;

    public C1438b(Context context, String str, String str2) {
        super(new C0990j(C1396d.f4796b));
        this.f4864a = str;
        this.f4865b = C1309a.m6935f(str2);
        this.f4866c = context;
    }

    protected boolean m7351a(Throwable th) {
        C0002c.m2a().m17c(new C1436h(th));
        return false;
    }

    public void m7352b() {
    }

    public void m7353c() {
        String str = this.f4864a + this.f4865b.substring(1);
        String a = C1309a.m6934a(this.f4866c).m6937a();
        int i = -1;
        switch (a.hashCode()) {
            case 3259:
                if (a.equals("fa")) {
                    i = 1;
                    break;
                }
                break;
            case 96599618:
                if (a.equals("en-us")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case VideoSize.QCIF /*0*/:
                C1548c.m7822a(this.f4866c).m7826a(str, C1247b.EN);
                break;
            case VideoSize.CIF /*1*/:
                C1548c.m7822a(this.f4866c).m7826a(str, C1247b.FA);
                break;
        }
        C1309a.m6934a(this.f4866c).m6948c(this.f4864a);
        C1309a.m6934a(this.f4866c).m6952d(this.f4865b);
        C1309a.m6934a(this.f4866c).m6944b(str);
        C0002c.m2a().m17c(new C1435g());
    }

    protected void m7354d() {
    }
}
