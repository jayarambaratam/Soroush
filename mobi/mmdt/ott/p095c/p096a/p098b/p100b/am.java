package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ap;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.am */
public class am extends ai {
    C1263m f4441a;

    public am(C1263m c1263m) {
        this.f4441a = c1263m;
    }

    public C1195v m6737a(JSONObject jSONObject) {
        C1195v apVar = new ap(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"));
        apVar.m6614b(false);
        return apVar;
    }
}
