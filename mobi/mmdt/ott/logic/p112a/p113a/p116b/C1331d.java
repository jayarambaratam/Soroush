package mobi.mmdt.ott.logic.p112a.p113a.p116b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p081b.C1108a;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1320a;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1322b;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1323c;
import mobi.mmdt.ott.logic.p157e.p158a.C1504b;
import mobi.mmdt.ott.logic.p161g.C1530c;
import mobi.mmdt.ott.logic.p161g.C1533f;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.a.b.d */
public class C1331d extends C0950c {
    private Context f4602a;
    private String f4603b;

    public C1331d(Context context, String str) {
        super(new C0990j(C1396d.f4797c));
        this.f4602a = context;
        this.f4603b = str;
    }

    protected boolean m7010a(Throwable th) {
        C0002c.m2a().m17c(new C1320a(C1533f.f5145m, "Can't Make Call", this.f4603b));
        C0002c.m2a().m17c(new C1322b(th));
        return false;
    }

    public void m7011b() {
    }

    public void m7012c() {
        String b = C1309a.m6934a(this.f4602a).m6942b();
        try {
            C1504b.m7583a(this.f4602a).m7585a(C1108a.m6381a(C1309a.m6934a(this.f4602a).m6942b()), this.f4603b, b);
        } catch (Throwable e) {
            C1104b.m6367b(C1331d.class, "Can't send callRequest Control message", e);
        }
        C1530c.m7703a(this.f4602a).m7710a(this.f4603b);
        C0002c.m2a().m17c(new C1323c());
    }

    protected void m7013d() {
    }
}
