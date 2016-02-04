package mobi.mmdt.ott.p095c.p096a.p101c.p103b.p105b;

import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.ai;
import mobi.mmdt.ott.p095c.p096a.p101c.p103b.p104a.C1250a;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.c.b.b.a */
public class C1252a extends ai {
    C1263m f4468a;

    public C1252a(C1263m c1263m) {
        this.f4468a = c1263m;
    }

    public C1195v m6780a(JSONObject jSONObject) {
        C1195v c1250a = new C1250a(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getString("FileURL"), jSONObject.getString("ThumbnailURL"), jSONObject.getString("FileId"), jSONObject.getString("State"));
        c1250a.m6614b(false);
        return c1250a;
    }
}
