package mobi.mmdt.ott.logic.p112a.p128e.p129a.p131b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.ArrayList;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1334a;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p134b.C1420d;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1197s;
import mobi.mmdt.ott.p109d.p110a.C1307c;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1592l;
import mobi.mmdt.ott.provider.p169c.C1593m;
import mobi.mmdt.ott.provider.p169c.C1594n;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.provider.p172f.C1619f;
import mobi.mmdt.ott.provider.p173g.C1622c;

/* renamed from: mobi.mmdt.ott.logic.a.e.a.b.a */
public class C1403a extends C0950c {
    private final Context f4799a;
    private final C1197s[] f4800b;

    public C1403a(Context context, C1197s[] c1197sArr) {
        super(new C0990j(C1396d.f4796b));
        this.f4799a = context;
        this.f4800b = c1197sArr;
    }

    protected boolean m7259a(Throwable th) {
        return false;
    }

    public void m7260b() {
    }

    public void m7261c() {
        ArrayList arrayList = new ArrayList();
        for (C1197s c1197s : this.f4800b) {
            boolean a = C1622c.m8254a(this.f4799a, c1197s.m6638c());
            C1619f a2 = C1334a.m7023a(c1197s.m6640e());
            if (a) {
                C1622c.m8251a(this.f4799a, c1197s.m6638c(), c1197s.m6639d(), c1197s.m6643h(), c1197s.m6641f(), c1197s.m6642g(), a2, c1197s.m6645j(), C1622c.m8255b(this.f4799a, c1197s.m6638c()).m8250c(), c1197s.m6644i());
            } else {
                arrayList.add(new C1307c(c1197s.m6638c(), c1197s.m6639d(), c1197s.m6643h(), c1197s.m6641f(), c1197s.m6642g(), a2, c1197s.m6645j(), false, c1197s.m6644i()));
                String str = "0_first_message_" + c1197s.m6638c();
                if (!C1583c.m7972a(this.f4799a, str, C1592l.IN)) {
                    C1583c.m7966a(this.f4799a, str, C1594n.REPORT, this.f4799a.getString(2131230897), c1197s.m6645j(), c1197s.m6645j(), C1592l.IN, C1593m.READ, c1197s.m6638c(), C1595o.GROUP, C1309a.m6934a(this.f4799a).m6942b(), null, null);
                }
                C1494c.m7540b(new C1420d(this.f4799a, c1197s.m6638c()));
            }
        }
        if (arrayList.size() > 0) {
            C1622c.m8253a(this.f4799a, arrayList);
        }
    }

    protected void m7262d() {
    }
}
