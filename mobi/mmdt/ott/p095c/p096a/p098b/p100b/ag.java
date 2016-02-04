package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.am;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.ag */
public class ag extends ai {
    C1263m f4438a;

    public ag(C1263m c1263m) {
        this.f4438a = c1263m;
    }

    public C1195v m6732a(JSONObject jSONObject) {
        C1195v amVar = new am(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getString("PhoneNo"), jSONObject.getString("DeviceId"));
        amVar.m6614b(false);
        this.f4438a.m6846d(jSONObject.getString("ServerNonce"));
        this.f4438a.m6844c(jSONObject.getString("ServerTimestamp"));
        this.f4438a.m6848e(jSONObject.getString("HashMethod"));
        this.f4438a.m6850f(jSONObject.getString("EncryptionMethod"));
        return amVar;
    }
}
