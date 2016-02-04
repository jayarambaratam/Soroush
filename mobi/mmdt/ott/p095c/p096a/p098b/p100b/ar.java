package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p107c.aj;
import org.apache.http.myHttp.HttpStatus;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.ar */
public class ar {
    public static C1195v m6742a(JSONObject jSONObject, JSONObject jSONObject2, C1221x c1221x) {
        if (!ar.m6743a(jSONObject2)) {
            return c1221x.m6719a(jSONObject2);
        }
        c1221x.m6720a(jSONObject2, jSONObject);
        throw new aj(-1, "Logically Unreachable Code!!!", jSONObject);
    }

    private static boolean m6743a(JSONObject jSONObject) {
        try {
            return jSONObject.getInt("ResultCode") != HttpStatus.SC_OK;
        } catch (Throwable e) {
            C1104b.m6367b(ar.class, e.getMessage(), e);
            return false;
        }
    }
}
