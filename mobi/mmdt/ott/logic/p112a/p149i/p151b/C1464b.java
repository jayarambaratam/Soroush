package mobi.mmdt.ott.logic.p112a.p149i.p151b;

import android.content.Context;
import android.net.Uri;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.io.File;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.logic.p124j.C1545d;
import mobi.mmdt.ott.logic.p164k.C1547b;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bd;
import mobi.mmdt.ott.provider.p174h.C1629b;
import mobi.mmdt.ott.provider.p174h.C1632e;
import mobi.mmdt.ott.provider.p174h.C1634g;

/* renamed from: mobi.mmdt.ott.logic.a.i.b.b */
public class C1464b extends C0950c {
    private Context f4902a;
    private Uri f4903b;
    private String f4904c;
    private String f4905d;
    private String f4906e;
    private String f4907f;
    private String f4908g;
    private C1367c f4909h;

    public C1464b(Context context, String str, String str2) {
        super(new C0990j(C1396d.f4796b).m6036a(str2));
        this.f4909h = new C1465c(this);
        this.f4902a = context;
        this.f4904c = str;
        this.f4905d = str2;
        this.f4906e = C1629b.m8297b(str2);
        this.f4907f = C1629b.m8299c(str2);
        this.f4908g = C1629b.m8294a(str2);
    }

    protected boolean m7417a(Throwable th) {
        return false;
    }

    public void m7418b() {
    }

    public void m7419c() {
        int i = 1;
        this.f4903b = Uri.fromFile(new File(C1490b.m7516a(this.f4902a).m7521a(this.f4906e, "v_" + this.f4905d + "_" + "orig" + ".png")));
        C1632e b = C1629b.m8298b(this.f4902a, this.f4905d);
        if (!b.moveToFirst()) {
            C1629b.m8292a(this.f4902a, Integer.parseInt(this.f4906e), Integer.parseInt(this.f4907f), Integer.parseInt(this.f4908g), this.f4905d, this.f4903b.toString(), this.f4903b.toString(), 1, 1, 0, 0, C1634g.NOT_STARTED);
        } else if (!(b.m8318f() == C1634g.NOT_STARTED || b.m8318f() == C1634g.CANCEL || b.m8318f() == C1634g.ERROR)) {
            i = 0;
        }
        if (!(b == null || b.isClosed())) {
            b.close();
        }
        if (i != 0) {
            bd a = C1547b.m7814a(this.f4902a).m7816a(this.f4904c, this.f4908g, this.f4906e, this.f4907f);
            if (a != null) {
                String a2;
                switch (this.f4902a.getResources().getDisplayMetrics().densityDpi) {
                    case 120:
                        a2 = a.m6671a().m6681a();
                        break;
                    case 160:
                        a2 = a.m6671a().m6682b();
                        break;
                    case 240:
                        a2 = a.m6671a().m6685e();
                        break;
                    case 320:
                        a2 = a.m6671a().m6686f();
                        break;
                    case 480:
                        a2 = a.m6671a().m6684d();
                        break;
                    case 640:
                        a2 = a.m6671a().m6683c();
                        break;
                    default:
                        a2 = a.m6671a().m6685e();
                        break;
                }
                if (a2 != null) {
                    C1629b.m8290a(this.f4902a, this.f4905d, C1634g.TRANSMITTING);
                    C1545d.m7786a(this.f4902a).m7788a(a2, this.f4903b, null, this.f4909h);
                }
            }
        }
    }

    protected void m7420d() {
    }
}
