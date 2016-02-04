package mobi.mmdt.ott.logic.p112a.p149i.p151b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1457c;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1458d;
import mobi.mmdt.ott.logic.p164k.C1547b;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bf;
import net.frakbot.glowpadbackport.BuildConfig;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.i.b.g */
public class C1469g extends C0950c {
    private Context f4917a;
    private String f4918b;

    public C1469g(Context context, String str) {
        super(new C0990j(C1396d.f4796b));
        this.f4917a = context;
        this.f4918b = str;
    }

    protected boolean m7441a(Throwable th) {
        C0002c.m2a().m17c(new C1457c());
        return false;
    }

    public void m7442b() {
    }

    public void m7443c() {
        bf a = C1547b.m7814a(this.f4917a).m7817a(this.f4918b + BuildConfig.FLAVOR);
        C0002c.m2a().m17c(new C1458d(a.m6675c(), a.m6674b(), a.m6678f(), a.m6677e(), a.m6679g(), a.m6676d(), a.m6673a()));
    }

    protected void m7444d() {
    }
}
