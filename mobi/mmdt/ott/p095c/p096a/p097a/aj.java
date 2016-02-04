package mobi.mmdt.ott.p095c.p096a.p097a;

import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.a.aj */
public class aj extends C1167x {
    public aj(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        super(str);
        put("Username", str);
        put("AvatarURL", str2);
        put("AvatarThumbnailURL", str3);
        put("Nickname", str4);
        put("Motto", str5);
        put("HashMethod", str6);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str7);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
