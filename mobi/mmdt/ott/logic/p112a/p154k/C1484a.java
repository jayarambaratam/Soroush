package mobi.mmdt.ott.logic.p112a.p154k;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1393c;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.p178a.C1659a;

/* renamed from: mobi.mmdt.ott.logic.a.k.a */
public class C1484a extends C0950c {
    private Context f4956a;

    public C1484a(Context context) {
        super(new C0990j(C1396d.f4796b));
        this.f4956a = context;
    }

    protected boolean m7490a(Throwable th) {
        return false;
    }

    public void m7491b() {
    }

    public void m7492c() {
        C1309a.m6934a(this.f4956a).m6941a(true);
        C1309a.m6934a(this.f4956a).m6947c(this.f4956a.getPackageManager().getPackageInfo(this.f4956a.getPackageName(), 0).versionCode);
        C1494c.m7539a(new C1393c(this.f4956a));
        C1659a.m8435a(this.f4956a);
    }

    protected void m7493d() {
    }
}
