package mobi.mmdt.ott.logic.p112a.p113a.p116b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1324d;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1325e;
import mobi.mmdt.ott.logic.p161g.C1530c;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.a.b.e */
public class C1332e extends C0950c {
    private Context f4604a;
    private boolean f4605b;

    public C1332e(Context context, boolean z) {
        super(new C0990j(C1396d.f4796b));
        this.f4604a = context;
        this.f4605b = z;
    }

    protected boolean m7014a(Throwable th) {
        C0002c.m2a().m17c(new C1324d(th));
        return false;
    }

    public void m7015b() {
    }

    public void m7016c() {
        C1530c.m7703a(this.f4604a).m7713b(this.f4605b);
        C0002c.m2a().m17c(new C1325e());
    }

    protected void m7017d() {
    }
}
