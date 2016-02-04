package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.componentsutils.p079a.p081b.C1108a;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1592l;
import mobi.mmdt.ott.provider.p169c.C1593m;
import mobi.mmdt.ott.provider.p169c.C1594n;
import mobi.mmdt.ott.provider.p169c.C1595o;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.w */
public class C1389w extends C0950c {
    private Context f4769a;
    private String f4770b;
    private String f4771c;
    private C1595o f4772d;

    public C1389w(Context context, String str, String str2, boolean z) {
        super(new C0990j(C1396d.f4796b));
        this.f4769a = context;
        this.f4770b = str;
        this.f4771c = str2;
        this.f4772d = z ? C1595o.GROUP : C1595o.SINGLE;
    }

    protected boolean m7219a(Throwable th) {
        return false;
    }

    public void m7220b() {
    }

    public void m7221c() {
        String b = C1309a.m6934a(this.f4769a).m6942b();
        String a = C1108a.m6381a(b);
        if (this.f4772d.equals(C1595o.SINGLE)) {
            C1583c.m7966a(this.f4769a, a, C1594n.TEXT, this.f4770b, C1113a.m6421a(), C1113a.m6421a(), C1592l.OUT, C1593m.DRAFT, this.f4771c, this.f4772d, this.f4771c, null, null);
        } else {
            C1583c.m7966a(this.f4769a, a, C1594n.TEXT, this.f4770b, C1113a.m6421a(), C1113a.m6421a(), C1592l.OUT, C1593m.DRAFT, this.f4771c, this.f4772d, b, null, null);
        }
    }

    protected void m7222d() {
    }
}
