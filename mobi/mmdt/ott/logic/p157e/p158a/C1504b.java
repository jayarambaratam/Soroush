package mobi.mmdt.ott.logic.p157e.p158a;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.logic.p157e.C1518g;
import mobi.mmdt.ott.provider.p172f.C1619f;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.logic.e.a.b */
public class C1504b {
    private static C1504b f5061a;
    private Context f5062b;
    private C1518g f5063c;

    private C1504b(Context context) {
        this.f5062b = context;
        this.f5063c = C1518g.m7654a(this.f5062b);
    }

    private Map<String, String> m7582a() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("SEND_TIME_IN_GMT", BuildConfig.FLAVOR + C1113a.m6421a());
        hashMap.put("LONGITUDE", null);
        hashMap.put("LATITUDE", null);
        hashMap.put("VERSION", "1");
        hashMap.put("ENCRYPTED", "FALSE");
        hashMap.put("TIMEOUT", "0");
        return hashMap;
    }

    public static C1504b m7583a(Context context) {
        if (f5061a == null) {
            f5061a = new C1504b(context);
        }
        return f5061a;
    }

    public void m7584a(String str, String str2) {
        Map a = m7582a();
        a.put("MAJOR_TYPE", "CONTROL_MESSAGE");
        a.put("MINOR_TYPE", "SEEN");
        a.put("SEEN_TIME_IN_GMT", BuildConfig.FLAVOR + C1113a.m6421a());
        this.f5063c.m7663b().m7497a(str, BuildConfig.FLAVOR, str2, a, false);
    }

    public void m7585a(String str, String str2, String str3) {
        Map a = m7582a();
        a.put("MAJOR_TYPE", "CONTROL_MESSAGE");
        a.put("MINOR_TYPE", "CALL_REQUEST");
        a.put("CALLER", str3);
        a.put("CALLEE", str2);
        this.f5063c.m7663b().m7497a(str2, BuildConfig.FLAVOR, str, a, false);
    }

    public void m7586a(String str, String str2, String str3, String str4) {
        Map a = m7582a();
        a.put("MAJOR_TYPE", "CONTROL_MESSAGE");
        a.put("MINOR_TYPE", "GROUP_LEAVE");
        a.put("SEND_TIME_IN_GMT", BuildConfig.FLAVOR + C1113a.m6421a());
        a.put("JID", str);
        a.put("USER_ID", str3);
        this.f5063c.m7663b().m7496a(str, str2, str4, a);
    }

    public void m7587a(String str, String str2, String str3, String str4, String str5) {
        Map a = m7582a();
        a.put("MAJOR_TYPE", "CONTROL_MESSAGE");
        a.put("MINOR_TYPE", "GROUP_REMOVE");
        a.put("SEND_TIME_IN_GMT", BuildConfig.FLAVOR + C1113a.m6421a());
        a.put("JID", str);
        a.put("USER_ID", str2);
        a.put("REMOVED_USER_ID", String.valueOf(str4));
        this.f5063c.m7663b().m7496a(str, str3, str5, a);
    }

    public void m7588a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Map a = m7582a();
        a.put("MAJOR_TYPE", "CONTROL_MESSAGE");
        a.put("MINOR_TYPE", "GROUP_CHANGE_ROLE");
        a.put("SEND_TIME_IN_GMT", BuildConfig.FLAVOR + C1113a.m6421a());
        a.put("JID", str);
        a.put("USER_ID", str3);
        a.put("CHANGE_USER_ID", str4);
        a.put("OLD_ROLE", str5);
        a.put("NEW_ROLE", str6);
        this.f5063c.m7663b().m7496a(str, str2, str7, a);
    }

    public void m7589a(String str, String str2, String str3, String str4, C1619f c1619f) {
        Map a = m7582a();
        a.put("MAJOR_TYPE", "CONTROL_MESSAGE");
        a.put("MINOR_TYPE", "GROUP_JOIN");
        a.put("JID", str3);
        a.put("USER_ID", str4);
        a.put("USER_ROLE", String.valueOf(c1619f));
        this.f5063c.m7663b().m7496a(str3, str2, str, a);
    }

    public void m7590a(String str, String str2, String str3, C1619f c1619f, String str4) {
        Map a = m7582a();
        a.put("MAJOR_TYPE", "CONTROL_MESSAGE");
        a.put("MINOR_TYPE", "GROUP_INVITATION");
        a.put("SEND_TIME_IN_GMT", BuildConfig.FLAVOR + C1113a.m6421a());
        a.put("JID", str);
        a.put("USER_ID", str3);
        a.put("USER_ROLE", String.valueOf(c1619f));
        this.f5063c.m7663b().m7497a(str3, str2, str4, a, false);
    }

    public void m7591b(String str, String str2, String str3, String str4) {
        Map a = m7582a();
        a.put("MAJOR_TYPE", "CONTROL_MESSAGE");
        a.put("MINOR_TYPE", "GROUP_CHANGE_METADATA");
        a.put("SEND_TIME_IN_GMT", BuildConfig.FLAVOR + C1113a.m6421a());
        a.put("JID", str);
        a.put("USER_ID", str3);
        this.f5063c.m7663b().m7496a(str, str2, str4, a);
    }
}
