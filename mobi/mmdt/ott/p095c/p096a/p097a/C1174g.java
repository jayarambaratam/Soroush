package mobi.mmdt.ott.p095c.p096a.p097a;

import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1198u;
import net.frakbot.glowpadbackport.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.a.g */
public class C1174g extends C1167x {
    public C1174g(String str, String str2, String str3, String str4, String str5, String str6, C1198u[] c1198uArr, String str7, String str8) {
        super(str);
        put("Username", str);
        put("GroupJID", str2);
        put("GroupName", str3);
        put("GroupAvatarURL", str4);
        put("GroupAvatarThumbnailURL", str5);
        put("Description", str6);
        JSONArray jSONArray = new JSONArray();
        for (C1198u c1198u : c1198uArr) {
            JSONObject jSONObject = new JSONObject();
            if (c1198u.m6646a() == null) {
                jSONObject.put("Username", BuildConfig.FLAVOR);
            } else {
                jSONObject.put("Username", c1198u.m6646a());
            }
            jSONObject.put("Role", c1198u.m6647b().toString());
            jSONArray.put(jSONObject);
        }
        put("Members", jSONArray);
        put("HashMethod", str7);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str8);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
