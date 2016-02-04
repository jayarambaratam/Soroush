package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1205h;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.f */
public class C1227f extends ai {
    C1263m f4446a;

    public C1227f(C1263m c1263m) {
        this.f4446a = c1263m;
    }

    public C1195v m6749a(JSONObject jSONObject) {
        C1195v c1205h = new C1205h(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getString("CountryCode"), jSONObject.getString("CountryPrefix"));
        c1205h.m6614b(false);
        return c1205h;
    }
}
