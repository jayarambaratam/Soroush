package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.be;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bh;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.v */
public class C1243v extends aj {
    C1263m f4454a;

    public C1243v(C1263m c1263m) {
        this.f4454a = c1263m;
    }

    public C1195v m6765a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("PackageData");
        C1195v beVar = new be(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getString("SessionKey"), jSONObject.getString("PackageID"), new bh(jSONObject2.getString("ldpi"), jSONObject2.getString("mdpi"), jSONObject2.getString("hdpi"), jSONObject2.getString("xhdpi"), jSONObject2.getString("xxhdpi"), jSONObject2.getString("xxxhdpi")));
        beVar.m6614b(false);
        return beVar;
    }
}
