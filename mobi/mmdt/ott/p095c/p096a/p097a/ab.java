package mobi.mmdt.ott.p095c.p096a.p097a;

import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.a.ab */
public class ab extends C1167x {
    public ab(String str, String str2, String str3, String str4) {
        super(str);
        put("Username", str);
        put("ChannelID", str2);
        put("HashMethod", str3);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str4);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
