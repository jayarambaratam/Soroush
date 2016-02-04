package mobi.mmdt.ott.logic.p112a.p128e.p129a.p131b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1197s;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ak;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p173g.C1621b;
import mobi.mmdt.ott.provider.p173g.C1622c;

/* renamed from: mobi.mmdt.ott.logic.a.e.a.b.f */
public class C1408f extends C0950c {
    private Context f4823a;
    private String f4824b;

    public C1408f(Context context, String str) {
        super(new C0990j(C1396d.f4797c));
        this.f4823a = context;
        this.f4824b = str;
    }

    protected boolean m7293a(Throwable th) {
        return false;
    }

    public void m7294b() {
    }

    public void m7295c() {
        C1309a.m6934a(this.f4823a).m6942b();
        ak a = C1546a.m7793a(this.f4823a).m7807c(this.f4824b).m6712a();
        boolean a2 = C1622c.m8254a(this.f4823a, this.f4824b);
        C1621b b = C1622c.m8255b(this.f4823a, this.f4824b);
        if (a2 && b.m8249b() != null && b.m8249b().equals(a.m6641f())) {
            C1494c.m7540b(new C1403a(this.f4823a, new C1197s[]{a}));
            return;
        }
        C1494c.m7540b(new C1403a(this.f4823a, new C1197s[]{a}));
    }

    protected void m7296d() {
    }
}
