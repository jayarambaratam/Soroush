package mobi.mmdt.ott.logic.p112a.p117b.p119b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ag;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;

/* renamed from: mobi.mmdt.ott.logic.a.b.b.l */
public class C1360l extends C0950c {
    private String f4650a;
    private int f4651b;
    private int f4652c;
    private Context f4653d;

    public C1360l(Context context, String str, int i, int i2) {
        super(new C0990j(C1396d.f4796b));
        this.f4653d = context;
        this.f4650a = str;
        this.f4651b = i;
        this.f4652c = i2;
    }

    protected boolean m7076a(Throwable th) {
        return false;
    }

    public void m7077b() {
    }

    public void m7078c() {
        C1309a.m6934a(this.f4653d).m6942b();
        String[] a = C1583c.m7973a(this.f4653d, this.f4650a, this.f4651b, this.f4652c);
        if (a.length != 0) {
            for (ag agVar : C1546a.m7793a(this.f4653d).m7803a(a).m6708a()) {
                C1583c.m7974b(this.f4653d, agVar.m6626b(), agVar.m6625a());
            }
        }
    }

    protected void m7079d() {
    }
}
