package mobi.mmdt.ott.logic.p112a.p128e.p129a.p131b;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.io.File;
import mobi.mmdt.componentsutils.p079a.p081b.C1108a;
import mobi.mmdt.componentsutils.p079a.p083d.C1112a;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1399c;
import mobi.mmdt.ott.logic.p112a.p128e.p129a.p130a.C1400d;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.logic.p124j.C1545d;
import mobi.mmdt.ott.logic.p157e.p158a.C1504b;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p173g.C1621b;
import mobi.mmdt.ott.provider.p173g.C1622c;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.e.a.b.d */
public class C1406d extends C0950c {
    private Context f4813a;
    private String f4814b;
    private String f4815c;
    private String f4816d;
    private String f4817e;
    private String f4818f;
    private String f4819g;
    private C1367c f4820h;
    private boolean f4821i;

    public C1406d(Context context, String str, String str2, String str3, boolean z, String str4) {
        super(new C0990j(C1396d.f4796b));
        this.f4813a = context;
        this.f4814b = str;
        this.f4815c = str2;
        this.f4816d = str3;
        this.f4821i = z;
        this.f4817e = str4;
    }

    private void m7281j() {
        String b = C1309a.m6934a(this.f4813a).m6942b();
        C1546a.m7793a(this.f4813a).m7800a(this.f4814b, this.f4815c, this.f4818f, this.f4819g, this.f4816d);
        C1504b.m7583a(this.f4813a).m7591b(this.f4814b, "Group Edited by " + C1607a.m8152a(this.f4813a, b).m8202d(), b, C1108a.m6381a(b));
        C0002c.m2a().m17c(new C1400d());
    }

    private void m7282k() {
        this.f4820h = new C1407e(this);
    }

    protected boolean m7283a(Throwable th) {
        C0002c.m2a().m17c(new C1399c(th));
        return false;
    }

    public void m7284b() {
    }

    public void m7285c() {
        if (!this.f4821i) {
            C1621b b = C1622c.m8255b(this.f4813a, this.f4814b);
            this.f4818f = b.m8249b();
            this.f4819g = b.m8248a();
            m7281j();
        } else if (this.f4817e == null || this.f4817e.isEmpty()) {
            this.f4818f = null;
            this.f4819g = null;
            this.f4817e = null;
            m7281j();
        } else {
            m7282k();
            Bitmap b2 = C1112a.m6420b(this.f4817e);
            String f = C1490b.m7516a(this.f4813a).m7528f(this.f4814b + ".png");
            C1112a.m6419a(b2, f);
            C1545d.m7786a(this.f4813a).m7789a(true, Uri.fromFile(new File(this.f4817e)), Uri.fromFile(new File(f)), this.f4820h);
        }
    }

    protected void m7286d() {
    }
}
