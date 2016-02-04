package mobi.mmdt.ott.logic.p157e;

import android.content.Context;
import java.util.Map;
import java.util.Timer;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.C1502d;
import mobi.mmdt.ott.logic.core.StartUpService;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1372f;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1383q;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1384r;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1385s;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1386t;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.ac;
import mobi.mmdt.ott.logic.p112a.p147h.C1454e;
import mobi.mmdt.ott.logic.p155b.C1488b;
import mobi.mmdt.ott.p089b.C1162g;
import mobi.mmdt.ott.p089b.C1163h;
import mobi.mmdt.ott.p089b.C1165j;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1593m;

/* renamed from: mobi.mmdt.ott.logic.e.d */
public class C1515d {
    private static C1515d f5083a;
    private Context f5084b;

    private C1515d(Context context) {
        this.f5084b = context;
    }

    public static C1515d m7645a(Context context) {
        if (f5083a == null) {
            f5083a = new C1515d(context);
        }
        return f5083a;
    }

    private void m7646b(String str, String str2, String str3, String str4, Map<String, String> map) {
        String str5 = (String) map.get("MAJOR_TYPE");
        String str6 = (String) map.get("MINOR_TYPE");
        C1104b.m6366b((Object) this, "Received Successfully - MAJOR_TYPE : " + str5);
        C1104b.m6366b((Object) this, "Received Successfully - MINOR_TYPE : " + str6);
        if (str5 != null && !str5.isEmpty() && str6 != null && !str6.isEmpty()) {
            if (str5.equals("CONTROL_MESSAGE")) {
                C1494c.m7539a(new C1384r(this.f5084b, str, map, str4, str3));
            } else if (str5.equals("SIMPLE_CHAT")) {
                C1494c.m7539a(new C1386t(this.f5084b, str2, str3, str4, map));
            } else if (str5.equals("GROUP_CHAT")) {
                C1494c.m7539a(new C1385s(this.f5084b, str2, str, str3, str4, map));
            } else if (str5.equals("CHANNEL_CHAT")) {
                C1494c.m7539a(new C1383q(this.f5084b, (String) map.get("USER_ID"), (String) map.get("CHANNEL_ID"), str3, str4, map, C1593m.NOT_READ));
            }
        }
    }

    public void m7647a(String str, String str2) {
        C1104b.m6366b((Object) C1515d.class, "Received Delivery from " + str2);
        C1583c.m7965a(this.f5084b, str, C1593m.DELIVERED);
        C1583c.m7960a(this.f5084b);
        C1488b.m7514a(this.f5084b).m7515a();
    }

    public void m7648a(String str, String str2, String str3, String str4, Map<String, String> map) {
        m7646b(str, str2, str3, str4, map);
    }

    public void m7649a(String str, String str2, String str3, Map<String, String> map) {
        m7646b(str, str, str2, str3, map);
    }

    public void m7650a(String str, String str2, C1162g c1162g) {
        C1494c.m7540b(new C1372f(this.f5084b, str, str2, c1162g));
    }

    public void m7651a(String str, C1163h c1163h) {
        C1494c.m7541c(new C1454e(this.f5084b, false, new String[]{str}));
        if (c1163h.equals(C1163h.Online)) {
            new Timer().schedule(new C1516e(this, str), 15000);
        }
    }

    public void m7652a(C1165j c1165j) {
        StartUpService.m7544a(this.f5084b, c1165j);
        if (c1165j.equals(C1165j.CONNECTED)) {
            C1494c.m7539a(new ac(this.f5084b));
            C1494c.m7540b(new C1454e(this.f5084b, true, null));
            new Timer().schedule(new C1517f(this), 2000);
            if (!C1309a.m6934a(this.f5084b).m6972o()) {
                C1502d.m7573a(this.f5084b);
            }
        }
    }

    public void m7653b(String str, String str2, C1162g c1162g) {
        C1494c.m7539a(new C1372f(this.f5084b, str, str2, c1162g));
    }
}
