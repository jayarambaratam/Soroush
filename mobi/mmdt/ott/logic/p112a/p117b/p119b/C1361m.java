package mobi.mmdt.ott.logic.p112a.p117b.p119b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1346l;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ae;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.af;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.b.b.m */
public class C1361m extends C0950c {
    private String f4654a;
    private Context f4655b;
    private boolean f4656c;
    private int f4657d;

    public C1361m(Context context, String str, int i, boolean z) {
        super(new C0990j(C1396d.f4796b));
        this.f4655b = context;
        this.f4654a = str;
        this.f4656c = z;
        this.f4657d = i;
    }

    protected boolean m7080a(Throwable th) {
        C0002c.m2a().m17c(new C1346l(th));
        return false;
    }

    public void m7081b() {
    }

    public void m7082c() {
        C1309a.m6934a(this.f4655b).m6942b();
        ae aeVar = new ae(this.f4654a, this.f4656c ? af.LIKE : af.UNLIKE);
        C1546a.m7793a(this.f4655b).m7796a(new ae[]{aeVar});
        C1583c.m7975b(this.f4655b, this.f4654a, this.f4657d, this.f4656c ? af.LIKE.ordinal() : af.UNLIKE.ordinal());
    }

    protected void m7083d() {
    }
}
