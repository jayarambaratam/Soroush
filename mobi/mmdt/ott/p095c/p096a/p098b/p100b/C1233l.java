package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1210m;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.l */
public class C1233l extends ai {
    public C1195v m6755a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("Messages");
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.getString(i);
        }
        C1195v c1210m = new C1210m(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), strArr);
        c1210m.m6614b(false);
        return c1210m;
    }
}
