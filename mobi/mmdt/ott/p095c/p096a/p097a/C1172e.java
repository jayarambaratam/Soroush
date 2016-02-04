package mobi.mmdt.ott.p095c.p096a.p097a;

import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.a.e */
public class C1172e extends C1167x {
    public C1172e(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(str);
        put("Username", str);
        put("GroupJID", str2);
        put("GroupName", str3);
        put("GroupAvatarURL", str4);
        put("GroupAvatarThumbnailURL", str5);
        put("Description", str6);
        put("HashMethod", str7);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str8);
        remove("AuthValue");
        put("AuthValue", a);
    }
}
