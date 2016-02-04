package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ay;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bf;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.w */
public class C1244w extends aj {
    C1263m f4455a;

    public C1244w(C1263m c1263m) {
        this.f4455a = c1263m;
    }

    public C1195v m6766a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("Stars");
        ay ayVar = new ay(jSONObject2.getInt("One"), jSONObject2.getInt("Two"), jSONObject2.getInt("Three"), jSONObject2.getInt("Four"), jSONObject2.getInt("Five"));
        ay ayVar2 = ayVar;
        C1195v bfVar = new bf(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getString("SessionKey"), jSONObject.getString("ID"), jSONObject.getString("CategoryID"), jSONObject.getString("DateAdded"), jSONObject.getString("Title"), jSONObject.getString("Description"), jSONObject.getString("Author"), jSONObject.getString("Price"), jSONObject.getString("Thumbnail"), jSONObject.getString("StickersThumbnail"), jSONObject.getString("StarMean"), ayVar2, jSONObject.getString("Downloads"), jSONObject.getInt("Version"));
        bfVar.m6614b(false);
        return bfVar;
    }
}
