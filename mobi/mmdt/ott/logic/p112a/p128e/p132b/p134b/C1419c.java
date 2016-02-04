package mobi.mmdt.ott.logic.p112a.p128e.p132b.p134b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.componentsutils.p079a.p081b.C1108a;
import mobi.mmdt.ott.logic.p112a.C1334a;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p133a.C1414c;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p133a.C1415d;
import mobi.mmdt.ott.logic.p157e.p158a.C1504b;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p095c.p096a.C1258f;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p172f.C1619f;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.e.b.b.c */
public class C1419c extends C0950c {
    private final Context f4842a;
    private final String f4843b;
    private final String[] f4844c;
    private final C1619f[] f4845d;
    private final C1619f[] f4846e;

    public C1419c(Context context, String str, String[] strArr, C1619f[] c1619fArr, C1619f[] c1619fArr2) {
        super(new C0990j(C1396d.f4796b));
        this.f4842a = context;
        this.f4843b = str;
        this.f4844c = strArr;
        this.f4845d = c1619fArr2;
        this.f4846e = c1619fArr;
    }

    protected boolean m7320a(Throwable th) {
        C0002c.m2a().m17c(new C1414c(th, this.f4844c, this.f4845d, this.f4846e));
        return false;
    }

    public void m7321b() {
    }

    public void m7322c() {
        String b = C1309a.m6934a(this.f4842a).m6942b();
        for (int i = 0; i < this.f4845d.length; i++) {
            C1258f a = C1334a.m7022a(this.f4845d[i]);
            C1546a.m7793a(this.f4842a).m7799a(this.f4843b, this.f4844c[i], a);
            C1504b.m7583a(this.f4842a).m7588a(this.f4843b, "Role of " + C1607a.m8152a(this.f4842a, this.f4844c[i]).m8202d() + " Changed to " + this.f4845d[i].name() + " by " + C1607a.m8152a(this.f4842a, b).m8202d(), b, this.f4844c[i], C1334a.m7022a(this.f4846e[i]).name(), a.name(), C1108a.m6381a(b));
        }
        C0002c.m2a().m17c(new C1415d());
    }

    protected void m7323d() {
    }
}
