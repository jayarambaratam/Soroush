package mobi.mmdt.ott.logic.p112a.p152j;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1476c;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1478e;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1479f;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.j.a */
public abstract class C1481a extends C0950c {
    protected boolean f4943a;
    protected final Context f4944b;
    protected final C1309a f4945c;
    protected final int f4946d;
    protected final boolean f4947e;
    protected Exception f4948f;
    protected final boolean f4949g;

    public C1481a(Context context, int i, boolean z, boolean z2) {
        super(new C0990j(C1396d.f4796b));
        this.f4943a = false;
        this.f4944b = context;
        this.f4946d = i;
        this.f4947e = z;
        this.f4945c = C1309a.m6934a(this.f4944b);
        this.f4949g = z2;
    }

    protected boolean m7479a(Throwable th) {
        this.f4948f = (Exception) th;
        C0002c.m2a().m17c(new C1479f(th));
        return false;
    }

    public void m7480b() {
        C0002c.m2a().m17c(new C1478e(this.f4946d, this.f4949g));
    }

    protected void m7481d() {
        C0002c.m2a().m17c(new C1476c(this.f4946d, this.f4948f, this.f4949g));
    }

    public void m7482j() {
        this.f4943a = true;
    }

    protected abstract void m7483k();
}
