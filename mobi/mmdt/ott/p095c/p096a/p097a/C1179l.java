package mobi.mmdt.ott.p095c.p096a.p097a;

import java.util.ArrayList;
import java.util.Arrays;
import net.frakbot.glowpadbackport.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.a.l */
public class C1179l extends C1167x {
    public C1179l(String str, String[] strArr, String str2, String str3) {
        super(str);
        put("Username", str);
        JSONObject jSONObject = new JSONObject();
        put("MessageIDs", new JSONArray(new ArrayList(Arrays.asList(strArr))));
        put("HashMethod", str2);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str3);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
