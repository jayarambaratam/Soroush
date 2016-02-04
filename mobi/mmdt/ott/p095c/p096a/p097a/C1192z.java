package mobi.mmdt.ott.p095c.p096a.p097a;

import mobi.mmdt.ott.p095c.p096a.C1255d;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.a.z */
public class C1192z extends C1167x {
    public C1192z(String str, C1255d c1255d, String str2, String str3) {
        super(str);
        put("Username", str);
        put("Format", m6587a(c1255d));
        put("HashMethod", str2);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str3);
        remove("AuthValue");
        put("AuthValue", a);
    }

    private String m6587a(C1255d c1255d) {
        return c1255d == C1255d.DateTime ? "datetime" : "timestamp";
    }
}
