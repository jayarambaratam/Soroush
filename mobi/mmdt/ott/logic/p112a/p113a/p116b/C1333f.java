package mobi.mmdt.ott.logic.p112a.p113a.p116b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1326f;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1327g;
import mobi.mmdt.ott.logic.p161g.C1530c;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.a.b.f */
public class C1333f extends C0950c {
    private Context f4606a;
    private boolean f4607b;

    public C1333f(Context context, boolean z) {
        super(new C0990j(C1396d.f4796b));
        this.f4606a = context;
        this.f4607b = z;
    }

    protected boolean m7018a(Throwable th) {
        C0002c.m2a().m17c(new C1326f(th));
        return false;
    }

    public void m7019b() {
    }

    public void m7020c() {
        C1530c.m7703a(this.f4606a).m7711a(this.f4607b);
        C0002c.m2a().m17c(new C1327g());
    }

    protected void m7021d() {
    }
}
