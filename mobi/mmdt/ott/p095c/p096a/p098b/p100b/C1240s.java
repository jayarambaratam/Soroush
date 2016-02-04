package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1201d;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.az;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.s */
public class C1240s extends aj {
    C1263m f4451a;

    public C1240s(C1263m c1263m) {
        this.f4451a = c1263m;
    }

    public C1195v m6762a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("Banners");
        C1201d[] c1201dArr = new C1201d[jSONArray.length()];
        for (int i = 0; i < c1201dArr.length; i++) {
            c1201dArr[i] = new C1201d(jSONArray.getJSONObject(i).getString("BannerId"), jSONArray.getJSONObject(i).getString("LocationUrl"), jSONArray.getJSONObject(i).getInt("ShowTime"));
        }
        return new az(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), c1201dArr);
    }
}
