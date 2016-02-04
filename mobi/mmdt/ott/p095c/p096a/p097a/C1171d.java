package mobi.mmdt.ott.p095c.p096a.p097a;

import mobi.mmdt.ott.p095c.p096a.C1258f;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.a.d */
public class C1171d extends C1167x {
    public C1171d(String str, String str2, String str3, C1258f c1258f, String str4, String str5) {
        super(str);
        put("Username", str);
        put("GroupJID", str2);
        put("MemberUsername", str3);
        put("MemberNewRole", c1258f.toString());
        put("HashMethod", str4);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str5);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
