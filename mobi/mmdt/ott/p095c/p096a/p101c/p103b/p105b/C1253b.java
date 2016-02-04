package mobi.mmdt.ott.p095c.p096a.p101c.p103b.p105b;

import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.ai;
import mobi.mmdt.ott.p095c.p096a.p101c.p103b.p104a.C1251b;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.c.b.b.b */
public class C1253b extends ai {
    public C1195v m6781a(JSONObject jSONObject) {
        C1195v c1251b = new C1251b(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getString("FileURL"), jSONObject.getString("ThumbnailURL"), jSONObject.getString("FileId"));
        c1251b.m6614b(false);
        return c1251b;
    }
}
