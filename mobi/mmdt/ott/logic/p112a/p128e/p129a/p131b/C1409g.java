package mobi.mmdt.ott.logic.p112a.p128e.p129a.p131b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p117b.p119b.C1349a;
import mobi.mmdt.ott.logic.p157e.C1518g;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p095c.p096a.C1258f;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1197s;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1212o;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ak;

/* renamed from: mobi.mmdt.ott.logic.a.e.a.b.g */
public class C1409g extends C0950c {
    private Context f4825a;

    public C1409g(Context context) {
        super(new C0990j(C1396d.f4796b));
        this.f4825a = context;
    }

    protected boolean m7297a(Throwable th) {
        return false;
    }

    public void m7298b() {
    }

    public void m7299c() {
        C1212o a = C1546a.m7793a(this.f4825a).m7804a();
        C1197s[] a2 = a.m6709a();
        C1494c.m7540b(new C1403a(this.f4825a, a2));
        for (ak akVar : a2) {
            try {
                if (!akVar.m6640e().equals(C1258f.NONE)) {
                    try {
                        C1518g.m7654a(this.f4825a).m7663b().m7512c(akVar.m6638c());
                    } catch (Throwable e) {
                        C1104b.m6368b((Object) this, e);
                    }
                }
            } catch (Throwable e2) {
                C1104b.m6368b((Object) this, e2);
            }
        }
        C1494c.m7540b(new C1349a(this.f4825a, a.m6710b(), true));
    }

    protected void m7300d() {
    }
}
