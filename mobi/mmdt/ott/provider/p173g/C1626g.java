package mobi.mmdt.ott.provider.p173g;

import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.provider.g.g */
public class C1626g {
    private int f5435a;
    private JSONObject f5436b;

    public C1626g(int i) {
        this.f5435a = i;
        this.f5436b = new JSONObject();
        try {
            this.f5436b.put("MEMBER_COUNT", this.f5435a);
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }

    public C1626g(String str) {
        try {
            this.f5436b = new JSONObject(str);
            this.f5435a = this.f5436b.getInt("MEMBER_COUNT");
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }

    public String m8278a() {
        return this.f5436b.toString();
    }

    public int m8279b() {
        return this.f5435a;
    }
}
