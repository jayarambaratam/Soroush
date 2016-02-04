package mobi.mmdt.ott.p095c.p096a.p097a;

import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bk;
import net.frakbot.glowpadbackport.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.a.am */
public class am extends C1167x {
    public am(String str, bk[] bkVarArr, String str2, String str3) {
        super(str);
        put("Username", str);
        JSONArray jSONArray = new JSONArray();
        for (bk bkVar : bkVarArr) {
            JSONObject jSONObject = new JSONObject();
            if (bkVar.m6690a() == null) {
                jSONObject.put("Name", BuildConfig.FLAVOR);
            } else {
                jSONObject.put("Name", bkVar.m6690a());
            }
            jSONObject.put("Number", bkVar.m6691b());
            jSONObject.put("Action", bkVar.m6692c().toString());
            jSONArray.put(jSONObject);
        }
        put("ContactChangesList", jSONArray);
        put("HashMethod", str2);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str3);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
