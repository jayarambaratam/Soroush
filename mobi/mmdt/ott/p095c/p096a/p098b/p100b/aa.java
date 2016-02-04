package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1219y;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.aa */
public class aa extends ai {
    private C1263m f4432a;

    public aa(C1263m c1263m) {
        this.f4432a = c1263m;
    }

    public C1195v m6724a(JSONObject jSONObject) {
        C1195v c1219y = new C1219y(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getLong("LastSeen"));
        c1219y.m6614b(false);
        return c1219y;
    }
}
