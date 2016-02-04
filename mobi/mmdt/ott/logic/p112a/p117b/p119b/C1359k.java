package mobi.mmdt.ott.logic.p112a.p117b.p119b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ag;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;

/* renamed from: mobi.mmdt.ott.logic.a.b.b.k */
public class C1359k extends C0950c {
    private String f4648a;
    private Context f4649b;

    public C1359k(Context context, String str) {
        super(new C0990j(C1396d.f4796b));
        this.f4649b = context;
        this.f4648a = str;
    }

    protected boolean m7072a(Throwable th) {
        return false;
    }

    public void m7073b() {
    }

    public void m7074c() {
        int i = 0;
        C1309a.m6934a(this.f4649b).m6942b();
        ag[] a = C1546a.m7793a(this.f4649b).m7803a(new String[]{this.f4648a}).m6708a();
        int length = a.length;
        while (i < length) {
            ag agVar = a[i];
            C1583c.m7974b(this.f4649b, agVar.m6626b(), agVar.m6625a());
            i++;
        }
    }

    protected void m7075d() {
    }
}
