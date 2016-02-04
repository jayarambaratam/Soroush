package mobi.mmdt.ott.logic.p112a.p117b.p119b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.provider.p168b.C1573b;

/* renamed from: mobi.mmdt.ott.logic.a.b.b.j */
public class C1358j extends C0950c {
    private String f4645a;
    private Context f4646b;
    private boolean f4647c;

    public C1358j(Context context, String str, boolean z) {
        super(new C0990j(C1396d.f4796b));
        this.f4646b = context;
        this.f4645a = str;
        this.f4647c = z;
    }

    protected boolean m7068a(Throwable th) {
        return false;
    }

    public void m7069b() {
    }

    public void m7070c() {
        C1573b.m7921a(this.f4646b, this.f4645a, this.f4647c);
    }

    protected void m7071d() {
    }
}
