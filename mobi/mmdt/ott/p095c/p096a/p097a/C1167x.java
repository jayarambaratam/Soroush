package mobi.mmdt.ott.p095c.p096a.p097a;

import mobi.mmdt.ott.p095c.p108d.C1301b;
import mobi.mmdt.ott.p095c.p108d.C1302c;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.a.x */
public abstract class C1167x extends JSONObject {
    public C1167x(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        put("RequestId", m6579a(currentTimeMillis + C1301b.m6869a(20) + str));
    }

    private String m6579a(String str) {
        return C1302c.m6877c(str);
    }

    protected static String m6580a(C1167x c1167x, String str) {
        return C1302c.m6874a(c1167x + str);
    }
}
