package mobi.mmdt.ott.p095c.p096a.p097a;

import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.a.af */
public class af extends C1167x {
    public af(String str, String str2, String str3, String str4, String str5) {
        super(str);
        put("Username", str);
        put("GroupJID", str2);
        put("MemberUsername", str3);
        put("HashMethod", str4);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str5);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
