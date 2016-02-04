package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p124j.C1545d;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p170d.C1598c;
import mobi.mmdt.ott.provider.p170d.C1604i;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.a */
public class C1366a extends C0950c {
    private final Context f4665a;
    private final long f4666b;
    private long f4667c;

    public C1366a(Context context, long j) {
        super(new C0990j(C1396d.f4797c));
        this.f4665a = context;
        this.f4666b = j;
    }

    protected boolean m7088a(Throwable th) {
        return false;
    }

    public void m7089b() {
        this.f4667c = C1598c.m8102a(this.f4665a, C1583c.m7977b(this.f4665a, this.f4666b)).m8087e();
        C1598c.m8095a(this.f4665a, this.f4667c, C1604i.CANCEL);
    }

    public void m7090c() {
        C1545d.m7786a(this.f4665a).m7791a(this.f4667c);
    }

    protected void m7091d() {
    }
}
