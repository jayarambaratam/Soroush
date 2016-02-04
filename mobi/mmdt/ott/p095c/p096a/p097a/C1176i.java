package mobi.mmdt.ott.p095c.p096a.p097a;

import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.a.i */
public class C1176i extends C1167x {
    public C1176i(String str, String str2, String str3) {
        super(str);
        put("Username", str);
        put("HashMethod", str2);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str3);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
