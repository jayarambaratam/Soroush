package mobi.mmdt.ott.p095c.p096a.p097a;

import java.util.ArrayList;
import java.util.Arrays;
import net.frakbot.glowpadbackport.BuildConfig;
import org.json.JSONArray;

/* renamed from: mobi.mmdt.ott.c.a.a.ad */
public class ad extends C1167x {
    public ad(String str, String[] strArr, String str2, String str3) {
        super(str);
        put("Username", str);
        put("ContactList", new JSONArray(new ArrayList(Arrays.asList(strArr))));
        put("HashMethod", str2);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str3);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
