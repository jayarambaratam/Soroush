package mobi.mmdt.ott.p095c.p096a.p101c.p102a;

import mobi.mmdt.ott.p095c.p096a.p097a.C1167x;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.c.a.b */
public class C1249b extends C1167x {
    public C1249b(String str, String str2, String str3) {
        super(str);
        put("Username", str);
        put("HashMethod", str2);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str3);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
