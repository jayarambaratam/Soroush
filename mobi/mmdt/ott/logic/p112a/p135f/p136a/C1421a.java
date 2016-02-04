package mobi.mmdt.ott.logic.p112a.p135f.p136a;

import android.content.Context;
import android.graphics.Bitmap;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.notifications.C1558e;
import mobi.mmdt.ott.logic.notifications.p165a.C1549a;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p147h.C1451b;
import mobi.mmdt.ott.logic.p161g.C1533f;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p171e.C1611e;
import mobi.mmdt.ott.view.p178a.ah;
import mobi.mmdt.ott.view.p178a.aj;

/* renamed from: mobi.mmdt.ott.logic.a.f.a.a */
public class C1421a extends C0950c {
    private Context f4849a;
    private C1533f f4850b;
    private String f4851c;

    public C1421a(Context context, C1533f c1533f, String str) {
        super(new C0990j(C1396d.f4797c));
        this.f4849a = context;
        this.f4850b = c1533f;
        this.f4851c = str;
    }

    protected boolean m7328a(Throwable th) {
        return false;
    }

    public void m7329b() {
        if (!C1607a.m8167d(this.f4849a, this.f4851c)) {
            C1494c.m7540b(new C1451b(this.f4849a, new String[]{this.f4851c}, false, true));
        }
    }

    public void m7330c() {
        C1611e a = C1607a.m8152a(this.f4849a, this.f4851c);
        String a2 = a.m8209k() ? ah.m8469a(a.m8205g(), a.m8204f()) : ah.m8470b(a.m8202d(), a.m8201c());
        Bitmap a3 = (a.m8206h() == null || a.m8206h().isEmpty()) ? C1558e.m7853a(this.f4849a) : C1111c.m6391a(this.f4849a, aj.m8474a(a.m8206h()));
        if (!this.f4850b.equals(C1533f.f5133a)) {
            if (this.f4850b.equals(C1533f.f5134b)) {
                C1549a.m7838a(this.f4849a, this.f4851c, a2, "Incoming Call ...", a3);
            } else if (this.f4850b.equals(C1533f.f5135c)) {
                C1549a.m7841c(this.f4849a, this.f4851c, a2, "Dialing ...", a3);
            } else if (!this.f4850b.equals(C1533f.f5136d) && !this.f4850b.equals(C1533f.f5137e) && !this.f4850b.equals(C1533f.f5138f) && !this.f4850b.equals(C1533f.f5139g)) {
                if (this.f4850b.equals(C1533f.f5140h)) {
                    C1549a.m7840b(this.f4849a, this.f4851c, a2, "In Call", a3);
                } else if (!this.f4850b.equals(C1533f.f5141i) && !this.f4850b.equals(C1533f.f5142j) && !this.f4850b.equals(C1533f.f5143k) && !this.f4850b.equals(C1533f.f5144l)) {
                    if (this.f4850b.equals(C1533f.f5145m)) {
                        C1549a.m7837a(this.f4849a);
                    } else if (this.f4850b.equals(C1533f.f5146n)) {
                        C1549a.m7837a(this.f4849a);
                    } else if (!this.f4850b.equals(C1533f.f5147o) && !this.f4850b.equals(C1533f.f5148p) && !this.f4850b.equals(C1533f.f5149q) && !this.f4850b.equals(C1533f.f5150r) && this.f4850b.equals(C1533f.f5151s)) {
                        C1549a.m7837a(this.f4849a);
                    }
                }
            }
        }
    }

    protected void m7331d() {
    }
}
