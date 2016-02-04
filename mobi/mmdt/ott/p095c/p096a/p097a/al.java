package mobi.mmdt.ott.p095c.p096a.p097a;

import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bi;
import net.frakbot.glowpadbackport.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.a.al */
public class al extends C1167x {
    public al(String str, bi[] biVarArr, String str2, String str3) {
        super(str);
        put("Username", str);
        JSONArray jSONArray = new JSONArray();
        for (bi biVar : biVarArr) {
            JSONObject jSONObject = new JSONObject();
            if (biVar.m6687a() == null) {
                jSONObject.put("Name", BuildConfig.FLAVOR);
            } else {
                jSONObject.put("Name", biVar.m6687a());
            }
            jSONObject.put("Number", biVar.m6688b());
            jSONArray.put(jSONObject);
        }
        put("ContactList", jSONArray);
        put("HashMethod", str2);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str3);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
