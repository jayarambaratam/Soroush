package mobi.mmdt.ott.logic.p112a.p117b.p119b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1344j;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1345k;
import mobi.mmdt.ott.logic.p157e.p159b.C1512c;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.b.b.i */
public class C1357i extends C0950c {
    private String f4643a;
    private Context f4644b;

    public C1357i(Context context, String str) {
        super(new C0990j(C1396d.f4796b));
        this.f4644b = context;
        this.f4643a = str;
    }

    protected boolean m7064a(Throwable th) {
        C0002c.m2a().m17c(new C1344j(th));
        return false;
    }

    public void m7065b() {
    }

    public void m7066c() {
        C1309a.m6934a(this.f4644b).m6942b();
        C1546a.m7793a(this.f4644b).m7811f(this.f4643a);
        C1494c.m7540b(new C1354f(this.f4644b, this.f4643a));
        C1512c.m7635c(this.f4643a);
        C1583c.m7989e(this.f4644b, this.f4643a);
        C0002c.m2a().m17c(new C1345k(this.f4643a));
    }

    protected void m7067d() {
    }
}
