package mobi.mmdt.ott.logic.p112a.p117b.p119b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1336b;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1337c;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1204g;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1208k;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1216t;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.b.b.d */
public class C1352d extends C0950c {
    private Context f4628a;
    private String f4629b;

    public C1352d(Context context, String str) {
        super(new C0990j(C1396d.f4795a));
        this.f4629b = null;
        this.f4628a = context;
        this.f4629b = str;
    }

    protected boolean m7043a(Throwable th) {
        C0002c.m2a().m17c(new C1336b(th));
        return false;
    }

    public void m7044b() {
    }

    public void m7045c() {
        C1216t[] a;
        C1204g[] b;
        C1309a.m6934a(this.f4628a).m6942b();
        C1208k b2;
        if (this.f4629b == null) {
            b2 = C1546a.m7793a(this.f4628a).m7805b();
            a = b2.m6704a();
            b = b2.m6705b();
        } else {
            b2 = C1546a.m7793a(this.f4628a).m7809d(this.f4629b);
            a = b2.m6704a();
            b = b2.m6705b();
        }
        C1494c.m7540b(new C1349a(this.f4628a, b, false));
        C0002c.m2a().m17c(new C1337c(new C1351c(b, a)));
    }

    protected void m7046d() {
    }
}
