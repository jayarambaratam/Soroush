package mobi.mmdt.ott.p095c.p096a.p097a;

import mobi.mmdt.ott.p095c.p108d.C1302c;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.a.f */
public class C1173f extends C1167x {
    public C1173f(String str, String str2, String str3, String str4, String[] strArr, String str5) {
        super(str);
        put("PhoneNo", str);
        put("Language", str3);
        put("HashMethod", str2);
        put("DeviceId", m6584a(str4));
        put("Resolution", m6585a(strArr));
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str5);
        remove("AuthValue");
        put("AuthValue", a);
    }

    private String m6584a(String str) {
        return C1302c.m6874a(str);
    }

    private String m6585a(String[] strArr) {
        String str = strArr[0];
        for (int i = 1; i < strArr.length; i++) {
            str = str + "," + strArr[i];
        }
        return str;
    }
}
