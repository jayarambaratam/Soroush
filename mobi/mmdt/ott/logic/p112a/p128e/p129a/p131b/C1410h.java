package mobi.mmdt.ott.logic.p112a.p128e.p129a.p131b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p081b.C1108a;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1401e;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1402f;
import mobi.mmdt.ott.logic.p157e.C1518g;
import mobi.mmdt.ott.logic.p157e.p158a.C1504b;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p172f.C1614a;
import mobi.mmdt.ott.provider.p173g.C1622c;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.e.a.b.h */
public class C1410h extends C0950c {
    private Context f4826a;
    private String f4827b;
    private boolean f4828c;

    public C1410h(Context context, String str, boolean z) {
        super(new C0990j(C1396d.f4796b));
        this.f4826a = context;
        this.f4827b = str;
        this.f4828c = z;
    }

    protected boolean m7301a(Throwable th) {
        C0002c.m2a().m17c(new C1401e(th));
        return false;
    }

    public void m7302b() {
    }

    public void m7303c() {
        String b = C1309a.m6934a(this.f4826a).m6942b();
        try {
            C1546a.m7793a(this.f4826a).m7794a(this.f4827b);
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
        C1504b.m7583a(this.f4826a).m7586a(this.f4827b, C1607a.m8152a(this.f4826a, b).m8202d() + " Leaved group", b, C1108a.m6381a(b));
        C1518g.m7654a(this.f4826a).m7663b().m7507b(this.f4827b);
        if (this.f4828c) {
            C1622c.m8258e(this.f4826a, this.f4827b);
            C1614a.m8234d(this.f4826a, this.f4827b);
            C1583c.m7982c(this.f4826a, this.f4827b);
        }
        C0002c.m2a().m17c(new C1402f());
    }

    protected void m7304d() {
    }
}
