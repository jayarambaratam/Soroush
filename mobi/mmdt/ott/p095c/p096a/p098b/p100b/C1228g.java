package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.av;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.g */
public class C1228g extends aj {
    C1263m f4447a;

    public C1228g(C1263m c1263m) {
        this.f4447a = c1263m;
    }

    public C1195v m6750a(JSONObject jSONObject) {
        C1195v avVar = new av(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getString("SessionKey"));
        avVar.m6614b(false);
        return avVar;
    }
}
