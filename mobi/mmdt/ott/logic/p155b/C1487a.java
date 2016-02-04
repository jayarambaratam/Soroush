package mobi.mmdt.ott.logic.p155b;

import android.content.Context;
import java.util.Map;
import mobi.mmdt.ott.p089b.C1143f;
import mobi.mmdt.ott.p089b.C1153a;
import mobi.mmdt.ott.p089b.C1159c;
import mobi.mmdt.ott.p089b.C1161e;
import mobi.mmdt.ott.p089b.C1162g;
import mobi.mmdt.ott.p089b.C1164i;

/* renamed from: mobi.mmdt.ott.logic.b.a */
public class C1487a {
    private static C1487a f5008a;
    private C1164i f5009b;
    private C1143f f5010c;

    private C1487a(Context context) {
        this.f5010c = C1159c.m6571a(context);
    }

    public static C1487a m7494a(Context context) {
        if (f5008a == null) {
            f5008a = new C1487a(context);
        }
        return f5008a;
    }

    public long m7495a(String str) {
        return this.f5010c.m6498a(str) * 1000;
    }

    public String m7496a(String str, String str2, String str3, Map<String, String> map) {
        return this.f5010c.m6499a(str, str2, str3, map);
    }

    public String m7497a(String str, String str2, String str3, Map<String, String> map, boolean z) {
        return this.f5010c.m6500a(str, str2, str3, map, z);
    }

    public void m7498a(String str, int i) {
        this.f5010c.m6502a(str, i);
    }

    public void m7499a(String str, String str2) {
        this.f5010c.m6503a(str, str2);
    }

    public void m7500a(String str, String str2, String str3) {
        this.f5010c.m6504a(str, str2, str3);
    }

    public void m7501a(C1153a c1153a) {
        this.f5010c.m6506a(c1153a);
    }

    public void m7502a(C1162g c1162g, String str) {
        this.f5010c.m6507a(c1162g, str);
    }

    public void m7503a(C1164i c1164i) {
        if (this.f5009b == null) {
            this.f5009b = c1164i;
            this.f5010c.m6508a(this.f5009b);
        }
    }

    public boolean m7504a() {
        return this.f5010c.m6513b();
    }

    public boolean m7505a(boolean z, boolean z2) {
        return this.f5010c.m6509a(z, z2);
    }

    public void m7506b() {
        this.f5010c.m6501a();
    }

    public void m7507b(String str) {
        this.f5010c.m6510b(str);
    }

    public void m7508b(String str, String str2) {
        this.f5010c.m6505a(str, str2, C1161e.Owner);
    }

    public void m7509b(C1162g c1162g, String str) {
        this.f5010c.m6511b(c1162g, str);
    }

    public void m7510b(C1164i c1164i) {
        this.f5009b = c1164i;
        this.f5010c.m6512b(this.f5009b);
    }

    public String m7511c() {
        return this.f5010c.m6514c();
    }

    public void m7512c(String str) {
        this.f5010c.m6515c(str);
    }
}
