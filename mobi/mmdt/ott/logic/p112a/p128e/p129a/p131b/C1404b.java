package mobi.mmdt.ott.logic.p112a.p128e.p129a.p131b;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.io.File;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p081b.C1108a;
import mobi.mmdt.componentsutils.p079a.p083d.C1112a;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1397a;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1398b;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p134b.C1417a;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.logic.p124j.C1545d;
import mobi.mmdt.ott.logic.p157e.C1518g;
import mobi.mmdt.ott.logic.p157e.p159b.C1512c;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p095c.p096a.C1258f;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1198u;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1592l;
import mobi.mmdt.ott.provider.p169c.C1593m;
import mobi.mmdt.ott.provider.p169c.C1594n;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p172f.C1619f;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.e.a.b.b */
public class C1404b extends C0950c {
    private final Context f4801a;
    private final String f4802b;
    private final String f4803c;
    private final String f4804d;
    private String f4805e;
    private String f4806f;
    private String f4807g;
    private C1367c f4808h;
    private ArrayList<C1198u> f4809i;
    private ArrayList<C1619f> f4810j;
    private ArrayList<String> f4811k;

    public C1404b(Context context, String str, String str2, String str3, ArrayList<String> arrayList) {
        super(new C0990j(C1396d.f4796b));
        this.f4806f = null;
        this.f4807g = null;
        this.f4809i = new ArrayList();
        this.f4810j = new ArrayList();
        this.f4811k = new ArrayList();
        this.f4801a = context;
        this.f4802b = str;
        this.f4803c = str2;
        for (int i = 0; i < arrayList.size(); i++) {
            this.f4809i.add(new C1198u((String) arrayList.get(i), C1258f.MEMBER));
            this.f4810j.add(C1619f.MEMBER);
            this.f4811k.add(arrayList.get(i));
        }
        this.f4809i.add(new C1198u(C1309a.m6934a(this.f4801a).m6942b(), C1258f.ADMIN));
        this.f4811k.add(C1309a.m6934a(this.f4801a).m6942b());
        this.f4810j.add(C1619f.ADMIN);
        this.f4804d = str3;
    }

    private void m7266j() {
        String b = C1309a.m6934a(this.f4801a).m6942b();
        this.f4805e = C1518g.m7654a(this.f4801a).m7663b().m7511c();
        C1198u[] c1198uArr = new C1198u[this.f4809i.size()];
        for (int i = 0; i < this.f4809i.size(); i++) {
            c1198uArr[i] = (C1198u) this.f4809i.get(i);
        }
        Long valueOf = Long.valueOf(C1113a.m6421a());
        try {
            C1583c.m7966a(this.f4801a, "0_first_message_" + this.f4805e, C1594n.REPORT, this.f4801a.getString(2131230897), valueOf.longValue(), valueOf.longValue(), C1592l.IN, C1593m.READ, this.f4805e, C1595o.GROUP, C1309a.m6934a(this.f4801a).m6942b(), null, null);
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
        try {
            C1583c.m7966a(this.f4801a, C1108a.m6381a(b), C1594n.REPORT, "Group Created by " + C1607a.m8152a(this.f4801a, b).m8202d(), C1113a.m6421a(), C1113a.m6421a(), C1592l.OUT, C1593m.NOT_READ, this.f4805e, C1595o.GROUP, this.f4805e, null, null);
            C1512c.m7631a(this.f4805e);
        } catch (Throwable e2) {
            C1104b.m6368b((Object) this, e2);
        }
        C1546a.m7793a(this.f4801a).m7801a(this.f4805e, this.f4802b, this.f4806f, this.f4807g, this.f4803c, c1198uArr);
        C1494c.m7539a(new C1408f(this.f4801a, this.f4805e));
        C1417a.m7313a(this.f4801a, this.f4805e, this.f4811k, this.f4810j);
        C0002c.m2a().m17c(new C1398b(this.f4805e));
    }

    private void m7267k() {
        this.f4808h = new C1405c(this);
    }

    protected boolean m7268a(Throwable th) {
        C0002c.m2a().m17c(new C1397a(th));
        return false;
    }

    public void m7269b() {
    }

    public void m7270c() {
        if (this.f4804d == null || this.f4804d.isEmpty()) {
            m7266j();
            return;
        }
        m7267k();
        Bitmap b = C1112a.m6420b(this.f4804d);
        String f = C1490b.m7516a(this.f4801a).m7528f(this.f4805e + ".png");
        C1112a.m6419a(b, f);
        C1545d.m7786a(this.f4801a).m7789a(true, Uri.fromFile(new File(this.f4804d)), Uri.fromFile(new File(f)), this.f4808h);
    }

    protected void m7271d() {
    }
}
