package mobi.mmdt.ott.logic.p112a.p137g.p141b.p144c.p146b;

import mobi.mmdt.ott.logic.p112a.p137g.p141b.p144c.p145a.C1441a;
import mobi.mmdt.ott.logic.p112a.p137g.p141b.p144c.p145a.C1443c;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.p095c.p107c.aj;
import org.json.JSONObject;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.g.b.c.b.b */
class C1445b implements C1367c {
    final /* synthetic */ C1444a f4879a;

    C1445b(C1444a c1444a) {
        this.f4879a = c1444a;
    }

    public void m7373a(int i) {
    }

    public void m7374a(int i, int i2) {
    }

    public void m7375a(int i, Object obj) {
        if (obj instanceof Exception) {
            C0002c.m2a().m17c(new C1443c((long) i, (Exception) obj));
            return;
        }
        try {
            C0002c.m2a().m17c(new C1443c((long) i, new aj(((JSONObject) obj).getInt("ResultCode"), ((JSONObject) obj).getString("ResultMessage"), new JSONObject())));
        } catch (Exception e) {
            C0002c.m2a().m17c(new C1443c((long) i, e));
        }
    }

    public void m7376a(int i, String str, String str2, String str3) {
        this.f4879a.f4874d = str;
        this.f4879a.f4875e = str2;
        try {
            this.f4879a.m7367j();
        } catch (Throwable e) {
            C0002c.m2a().m17c(new C1441a(e));
        }
    }

    public void m7377b(int i) {
    }

    public void m7378c(int i) {
    }
}
