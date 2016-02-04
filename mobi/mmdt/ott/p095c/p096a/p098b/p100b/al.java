package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ao;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.al */
public class al extends ai {
    C1263m f4440a;

    public al(C1263m c1263m) {
        this.f4440a = c1263m;
    }

    public C1195v m6736a(JSONObject jSONObject) {
        C1195v aoVar = new ao(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"));
        aoVar.m6614b(false);
        return aoVar;
    }
}
