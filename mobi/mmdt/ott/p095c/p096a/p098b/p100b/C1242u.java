package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bc;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bg;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.u */
public class C1242u extends aj {
    C1263m f4453a;

    public C1242u(C1263m c1263m) {
        this.f4453a = c1263m;
    }

    public C1195v m6764a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("Packages");
        bc[] bcVarArr = new bc[jSONArray.length()];
        for (int i = 0; i < bcVarArr.length; i++) {
            bcVarArr[i] = new bc(jSONArray.getJSONObject(i).getString("ID"), jSONArray.getJSONObject(i).getString("Title"), jSONArray.getJSONObject(i).getString("Thumbnail"), jSONArray.getJSONObject(i).getString("Price"), jSONArray.getJSONObject(i).getString("Downloads"));
        }
        C1195v bgVar = new bg(jSONObject.getInt("Count"), jSONObject.getInt("Offset"), jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getString("SessionKey"), bcVarArr);
        bgVar.m6614b(false);
        return bgVar;
    }
}
