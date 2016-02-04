package mobi.mmdt.ott.logic.p112a.p137g.p141b.p143b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.core.StartUpService;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1429a;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p142a.C1430b;
import mobi.mmdt.ott.logic.p164k.C1548c;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.g.b.b.c */
public class C1439c extends C0950c {
    private String f4867a;
    private Context f4868b;

    public C1439c(Context context, String str) {
        super(new C0990j(C1396d.f4796b));
        this.f4867a = str;
        this.f4868b = context;
    }

    protected boolean m7355a(Throwable th) {
        C0002c.m2a().m17c(new C1430b(th));
        return false;
    }

    public void m7356b() {
    }

    public void m7357c() {
        C1548c.m7822a(this.f4868b).m7824a(C1309a.m6934a(this.f4868b).m6942b(), this.f4867a);
        C1309a.m6934a(this.f4868b).m6955e(this.f4867a);
        StartUpService.m7549c(this.f4868b);
        C0002c.m2a().m17c(new C1429a());
    }

    protected void m7358d() {
    }
}
