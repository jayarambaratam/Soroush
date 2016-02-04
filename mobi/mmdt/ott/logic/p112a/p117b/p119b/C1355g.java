package mobi.mmdt.ott.logic.p112a.p117b.p119b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1340f;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1341g;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.b.b.g */
public class C1355g extends C0950c {
    private String f4639a;
    private Context f4640b;

    public C1355g(Context context, String str) {
        super(new C0990j(C1396d.f4796b));
        this.f4640b = context;
        this.f4639a = str;
    }

    protected boolean m7056a(Throwable th) {
        C0002c.m2a().m17c(new C1340f(th));
        return false;
    }

    public void m7057b() {
    }

    public void m7058c() {
        C1309a.m6934a(this.f4640b).m6942b();
        C0002c.m2a().m17c(new C1341g(C1546a.m7793a(this.f4640b).m7813h(this.f4639a).m6711a()));
    }

    protected void m7059d() {
    }
}
