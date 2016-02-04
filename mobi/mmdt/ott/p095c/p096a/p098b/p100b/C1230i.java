package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1207j;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.i */
public class C1230i extends ai {
    private C1263m f4448a;

    public C1230i(C1263m c1263m) {
        this.f4448a = c1263m;
    }

    public C1195v m6752a(JSONObject jSONObject) {
        C1195v c1207j = new C1207j(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"));
        c1207j.m6614b(false);
        return c1207j;
    }
}
