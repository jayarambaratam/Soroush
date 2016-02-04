package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1200c;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.c */
public class C1224c implements C1221x {
    private C1263m f4445a;

    public C1224c(C1263m c1263m) {
        this.f4445a = c1263m;
    }

    public C1195v m6745a(JSONObject jSONObject) {
        C1195v c1200c = new C1200c(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getString("HashMethod"), jSONObject.getString("EncryptionMethod"));
        this.f4445a.m6848e(jSONObject.getString("HashMethod"));
        this.f4445a.m6850f(jSONObject.getString("EncryptionMethod"));
        c1200c.m6614b(false);
        c1200c.m6696a(true);
        return c1200c;
    }

    public C1195v m6746a(JSONObject jSONObject, JSONObject jSONObject2) {
        return new C1200c(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), null, null);
    }
}
