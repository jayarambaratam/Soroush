package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p155b.C1487a;
import mobi.mmdt.ott.p089b.C1162g;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.y */
public class C1391y extends C0950c {
    private Context f4775a;
    private String f4776b;
    private boolean f4777c;
    private C1162g f4778d;

    public C1391y(Context context, String str, C1162g c1162g, boolean z) {
        super(new C0990j(C1396d.f4796b));
        this.f4775a = context;
        this.f4776b = str;
        this.f4778d = c1162g;
        this.f4777c = z;
    }

    protected boolean m7228a(Throwable th) {
        return false;
    }

    public void m7229b() {
    }

    public void m7230c() {
        if (this.f4777c) {
            C1487a.m7494a(this.f4775a).m7509b(this.f4778d, this.f4776b);
        } else {
            C1487a.m7494a(this.f4775a).m7502a(this.f4778d, this.f4776b);
        }
    }

    protected void m7231d() {
    }
}
