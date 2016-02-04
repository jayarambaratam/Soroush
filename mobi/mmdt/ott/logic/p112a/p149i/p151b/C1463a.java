package mobi.mmdt.ott.logic.p112a.p149i.p151b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p124j.C1545d;
import mobi.mmdt.ott.provider.p175i.C1635a;
import mobi.mmdt.ott.provider.p175i.C1640f;

/* renamed from: mobi.mmdt.ott.logic.a.i.b.a */
public class C1463a extends C0950c {
    private final Context f4900a;
    private final int f4901b;

    public C1463a(Context context, int i) {
        super(new C0990j(C1396d.f4797c));
        this.f4900a = context;
        this.f4901b = i;
    }

    protected boolean m7410a(Throwable th) {
        return false;
    }

    public void m7411b() {
        C1635a.m8333a(this.f4900a, this.f4901b, C1640f.CANCEL);
    }

    public void m7412c() {
        C1545d.m7786a(this.f4900a).m7790a(C1635a.m8330a(this.f4900a, this.f4901b));
    }

    protected void m7413d() {
    }
}
