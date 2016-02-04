package mobi.mmdt.ott.p095c.p096a.p097a;

import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.a.k */
public class C1178k extends C1167x {
    public C1178k(String str, String str2, int i, int i2, String str3, String str4, String str5) {
        super(str);
        put("Username", str);
        put("ChannelID", str2);
        if (str3 != null) {
            put("MessageID", str3);
        }
        put("Offset", Integer.toString(i));
        put("Count", Integer.toString(i2));
        put("HashMethod", str4);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str5);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
