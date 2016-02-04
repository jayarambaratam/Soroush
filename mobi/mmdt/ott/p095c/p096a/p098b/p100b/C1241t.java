package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ba;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bb;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.t */
public class C1241t extends aj {
    C1263m f4452a;

    public C1241t(C1263m c1263m) {
        this.f4452a = c1263m;
    }

    public C1195v m6763a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("Categories");
        bb[] bbVarArr = new bb[jSONArray.length()];
        for (int i = 0; i < bbVarArr.length; i++) {
            bbVarArr[i] = new bb(jSONArray.getJSONObject(i).getString("ID"), jSONArray.getJSONObject(i).getString("Name"), jSONArray.getJSONObject(i).getString("Description"), jSONArray.getJSONObject(i).getString("Thumbnail"));
        }
        C1195v baVar = new ba(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getString("SessionKey"), jSONObject.getInt("Count"), bbVarArr);
        baVar.m6614b(false);
        return baVar;
    }
}
