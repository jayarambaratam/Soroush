package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bd;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bh;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.r */
public class C1239r extends aj {
    C1263m f4450a;

    public C1239r(C1263m c1263m) {
        this.f4450a = c1263m;
    }

    public C1195v m6761a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("StickerURL");
        C1195v bdVar = new bd(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getString("StickerVersion"), jSONObject.getString("StickerID"), jSONObject.getString("PackageStickerID"), jSONObject.getString("FromUsername"), jSONObject.getString("Resolution"), new bh(jSONObject2.getString("ldpi"), jSONObject2.getString("mdpi"), jSONObject2.getString("hdpi"), jSONObject2.getString("xhdpi"), jSONObject2.getString("xxhdpi"), jSONObject2.getString("xxxhdpi")));
        bdVar.m6614b(false);
        return bdVar;
    }
}
