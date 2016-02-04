package mobi.mmdt.ott.p095c.p096a.p097a;

import mobi.mmdt.ott.p095c.p096a.C1247b;
import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p108d.C1302c;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.a.ae */
public class ae extends C1167x {
    public ae(String str, String str2, String str3, C1247b c1247b, C1263m c1263m) {
        super(str);
        put("PhoneNo", str);
        put("DeviceId", C1302c.m6874a(str2));
        put("ClientNonce", str3);
        String str4 = System.currentTimeMillis() + BuildConfig.FLAVOR;
        put("ClientTimestamp", str4);
        put("Language", c1247b.toString());
        c1263m.m6842b(str3);
        c1263m.m6840a(str4);
    }
}
