package mobi.mmdt.ott.p095c.p096a.p097a;

import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ae;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.af;
import net.frakbot.glowpadbackport.BuildConfig;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.a.ah */
public class ah extends C1167x {
    public ah(String str, ae[] aeVarArr, String str2, String str3) {
        super(str);
        put("Username", str);
        JSONObject jSONObject = new JSONObject();
        for (ae aeVar : aeVarArr) {
            int i = aeVar.m6623a() == af.f4281b ? 1 : aeVar.m6623a() == af.f4280a ? 0 : 0;
            jSONObject.put(aeVar.m6624b(), i);
        }
        put("MessageLikes", jSONObject);
        put("HashMethod", str2);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str3);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
