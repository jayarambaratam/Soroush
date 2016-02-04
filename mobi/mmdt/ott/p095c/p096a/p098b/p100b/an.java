package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.aw;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.an */
public class an extends ai {
    C1263m f4442a;

    public an(C1263m c1263m) {
        this.f4442a = c1263m;
    }

    public C1195v m6738a(JSONObject jSONObject) {
        C1195v awVar = new aw(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"));
        awVar.m6614b(false);
        return awVar;
    }
}
