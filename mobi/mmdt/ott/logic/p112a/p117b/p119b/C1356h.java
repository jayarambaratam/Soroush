package mobi.mmdt.ott.logic.p112a.p117b.p119b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1342h;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1343i;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.b.b.h */
public class C1356h extends C0950c {
    private String f4641a;
    private Context f4642b;

    public C1356h(Context context, String str) {
        super(new C0990j(C1396d.f4796b));
        this.f4642b = context;
        this.f4641a = str;
    }

    protected boolean m7060a(Throwable th) {
        C0002c.m2a().m17c(new C1342h(th));
        return false;
    }

    public void m7061b() {
    }

    public void m7062c() {
        C1309a.m6934a(this.f4642b).m6942b();
        C1546a.m7793a(this.f4642b).m7810e(this.f4641a);
        C1494c.m7540b(new C1354f(this.f4642b, this.f4641a));
        C1494c.m7540b(new C1353e(this.f4642b, this.f4641a, 0, 20));
        C0002c.m2a().m17c(new C1343i(this.f4641a));
    }

    protected void m7063d() {
    }
}
