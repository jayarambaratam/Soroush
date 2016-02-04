package mobi.mmdt.ott.p095c.p096a.p097a;

import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import net.frakbot.glowpadbackport.BuildConfig;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.a.ak */
public class ak extends C1167x {
    public ak(String str, String str2, String[] strArr, String str3, String str4, String str5) {
        super(str);
        put("Username", str);
        put("PollID", str2);
        put("VoteData", m6583a(strArr, str3));
        put("HashMethod", str4);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str5);
        remove("AuthValue");
        put("AuthValue", a);
    }

    private JSONObject m6583a(String[] strArr, String str) {
        JSONObject jSONObject = new JSONObject();
        String str2 = BuildConfig.FLAVOR;
        int i = 0;
        while (i < strArr.length) {
            str2 = i == 0 ? str2 + strArr[i] : str2 + "," + strArr[i];
            i++;
        }
        try {
            jSONObject.put("QuestionAnswer", str2);
            jSONObject.put("QuestionComment", str);
        } catch (Throwable e) {
            C1104b.m6367b(this, e.getMessage(), e);
        }
        return jSONObject;
    }
}
