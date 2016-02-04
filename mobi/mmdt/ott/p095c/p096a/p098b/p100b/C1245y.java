package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1217w;
import mobi.mmdt.ott.p095c.p107c.C1279f;
import mobi.mmdt.ott.p095c.p107c.C1293u;
import mobi.mmdt.ott.p095c.p107c.aj;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.y */
public class C1245y extends ai {
    private C1263m f4456a;

    public C1245y(C1263m c1263m) {
        this.f4456a = c1263m;
    }

    public C1195v m6767a(JSONObject jSONObject) {
        C1195v c1217w = new C1217w(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"));
        c1217w.m6614b(false);
        return c1217w;
    }

    public C1195v m6768a(JSONObject jSONObject, JSONObject jSONObject2) {
        int parseInt = Integer.parseInt(jSONObject.getString("ResultCode"));
        if (parseInt == 321 || parseInt == 322 || parseInt == 324) {
            throw new C1279f(parseInt, jSONObject.getString("ResultMessage"), jSONObject2);
        } else if (parseInt == 315) {
            throw new C1293u(parseInt, jSONObject.getString("ResultMessage"), jSONObject2);
        } else {
            throw new aj(jSONObject.getInt("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject2);
        }
    }
}
