package mobi.mmdt.ott.logic.p112a.p117b.p119b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1347m;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1348n;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p095c.C1303d;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bn;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.b.b.n */
public class C1362n extends C0950c {
    private String f4658a;
    private String f4659b;
    private String f4660c;
    private String[] f4661d;
    private Context f4662e;

    public C1362n(Context context, String str, String str2, String[] strArr, String str3) {
        super(new C0990j(C1396d.f4796b));
        this.f4662e = context;
        this.f4658a = str2;
        this.f4659b = str;
        this.f4661d = strArr;
        this.f4660c = str3;
    }

    protected boolean m7084a(Throwable th) {
        C0002c.m2a().m17c(new C1347m(th));
        return false;
    }

    public void m7085b() {
    }

    public void m7086c() {
        C1309a.m6934a(this.f4662e).m6942b();
        C1546a.m7793a(this.f4662e).m7797a(this.f4658a, this.f4661d, this.f4660c);
        C1583c.m7963a(this.f4662e, this.f4659b, C1303d.m6880a(new bn(this.f4661d, this.f4660c)).toString());
        C0002c.m2a().m17c(new C1348n());
    }

    protected void m7087d() {
    }
}
