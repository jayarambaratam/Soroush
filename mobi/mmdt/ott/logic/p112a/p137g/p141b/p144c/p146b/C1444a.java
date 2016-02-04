package mobi.mmdt.ott.logic.p112a.p137g.p141b.p144c.p146b;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.io.File;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.p079a.p083d.C1112a;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p144c.p145a.C1441a;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p144c.p145a.C1442b;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.logic.p124j.C1545d;
import mobi.mmdt.ott.logic.p164k.C1548c;
import mobi.mmdt.ott.p095c.p108d.C1302c;
import mobi.mmdt.ott.p109d.p110a.C1308d;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p171e.C1611e;
import net.frakbot.glowpadbackport.BuildConfig;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.g.b.c.b.a */
public class C1444a extends C0950c {
    private Context f4871a;
    private boolean f4872b;
    private String f4873c;
    private String f4874d;
    private String f4875e;
    private String f4876f;
    private String f4877g;
    private C1367c f4878h;

    public C1444a(Context context, String str, String str2, String str3, boolean z) {
        super(new C0990j(C1396d.f4796b));
        this.f4873c = null;
        this.f4874d = BuildConfig.FLAVOR;
        this.f4875e = BuildConfig.FLAVOR;
        this.f4871a = context;
        this.f4872b = z;
        this.f4873c = str;
        this.f4876f = str2;
        if (str3 != null) {
            this.f4877g = str3;
        } else {
            this.f4877g = BuildConfig.FLAVOR;
        }
        m7368k();
    }

    private void m7364a(String str, String str2) {
        if (C1607a.m8167d(this.f4871a, str)) {
            C1611e a = C1607a.m8152a(this.f4871a, str);
            C1607a.m8150a(this.f4871a, this.f4876f, this.f4877g, this.f4874d, this.f4875e, str, a.m8204f(), a.m8209k(), a.m8210l(), a.m8211m(), a.m8205g(), a.m8200b());
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C1308d(this.f4876f, this.f4877g, this.f4874d, this.f4875e, str, str2, false, false, true, null, null, false, false));
            C1607a.m8153a(this.f4871a, arrayList);
        }
        C0002c.m2a().m17c(new C1442b());
    }

    private void m7367j() {
        String b = C1309a.m6934a(this.f4871a).m6942b();
        String f = C1309a.m6934a(this.f4871a).m6957f();
        C1548c.m7822a(this.f4871a).m7828a(this.f4874d, this.f4875e, this.f4876f, this.f4877g);
        m7364a(b, f);
    }

    private void m7368k() {
        this.f4878h = new C1445b(this);
    }

    protected boolean m7369a(Throwable th) {
        C0002c.m2a().m17c(new C1441a(th));
        return false;
    }

    public void m7370b() {
    }

    public void m7371c() {
        String b = C1309a.m6934a(this.f4871a).m6942b();
        if (!this.f4872b) {
            this.f4874d = C1607a.m8152a(this.f4871a, b).m8206h();
            this.f4875e = C1607a.m8152a(this.f4871a, b).m8199a();
            m7367j();
        } else if (this.f4873c == null || this.f4873c.isEmpty()) {
            this.f4874d = null;
            this.f4875e = null;
            m7367j();
        } else {
            Bitmap b2 = C1112a.m6420b(this.f4873c);
            b = C1490b.m7516a(this.f4871a).m7528f(C1302c.m6878d(b) + ".png");
            C1112a.m6419a(b2, b);
            C1545d.m7786a(this.f4871a).m7789a(true, Uri.fromFile(new File(this.f4873c)), Uri.fromFile(new File(b)), this.f4878h);
        }
    }

    protected void m7372d() {
    }
}
