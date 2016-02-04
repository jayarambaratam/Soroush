package mobi.mmdt.ott.logic.p112a.p117b.p119b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1335a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.b.b.b */
public class C1350b extends C0950c {
    private Context f4622a;
    private String f4623b;
    private int f4624c;
    private String f4625d;

    public C1350b(Context context, String str, int i, String str2) {
        super(new C0990j(C1396d.f4796b));
        this.f4622a = context;
        this.f4623b = str;
        this.f4624c = i;
        this.f4625d = str2;
    }

    protected boolean m7037a(Throwable th) {
        return false;
    }

    public void m7038b() {
    }

    public void m7039c() {
        if (C1583c.m7995g(this.f4622a, this.f4623b) > this.f4624c) {
            C0002c.m2a().m17c(new C1335a(true, this.f4625d, this.f4624c));
        } else {
            C0002c.m2a().m17c(new C1335a(false, this.f4625d, this.f4624c));
        }
    }

    protected void m7040d() {
    }
}
