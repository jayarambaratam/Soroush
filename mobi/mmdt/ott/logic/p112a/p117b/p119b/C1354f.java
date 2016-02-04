package mobi.mmdt.ott.logic.p112a.p117b.p119b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1204g;
import mobi.mmdt.ott.p109d.p111b.C1309a;

/* renamed from: mobi.mmdt.ott.logic.a.b.b.f */
public class C1354f extends C0950c {
    private String f4637a;
    private Context f4638b;

    public C1354f(Context context, String str) {
        super(new C0990j(C1396d.f4796b));
        this.f4638b = context;
        this.f4637a = str;
    }

    protected boolean m7052a(Throwable th) {
        return false;
    }

    public void m7053b() {
    }

    public void m7054c() {
        C1309a.m6934a(this.f4638b).m6942b();
        C1204g a = C1546a.m7793a(this.f4638b).m7812g(this.f4637a).m6706a();
        C1494c.m7540b(new C1349a(this.f4638b, new C1204g[]{a}, true));
    }

    protected void m7055d() {
    }
}
