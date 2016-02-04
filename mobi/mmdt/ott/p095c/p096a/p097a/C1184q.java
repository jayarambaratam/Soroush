package mobi.mmdt.ott.p095c.p096a.p097a;

import mobi.mmdt.ott.p095c.p108d.C1302c;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.a.q */
public class C1184q extends C1167x {
    public C1184q(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        super(str);
        put("PhoneNo", str);
        put("FromUsername", str2);
        put("StickerVersion", str3);
        put("PackageID", str4);
        put("StickerID", str5);
        put("Resolution", str6);
        put("DeviceId", m6586a(str7));
        put("HashMethod", str8);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str9);
        remove("AuthValue");
        put("AuthValue", a);
    }

    private String m6586a(String str) {
        return C1302c.m6874a(str);
    }
}
