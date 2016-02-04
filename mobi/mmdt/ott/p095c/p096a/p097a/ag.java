package mobi.mmdt.ott.p095c.p096a.p097a;

import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.a.ag */
public class ag extends C1167x {
    public ag(String str, String str2, String str3, String str4, String str5) {
        super(str);
        put("Username", str);
        put("NetType", str2);
        put("HashMethod", str3);
        put("EncryptionMethod", str4);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str5);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
