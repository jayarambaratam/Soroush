package mobi.mmdt.ott.p095c.p107c;

import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.c.q */
public class C1273q extends Exception {
    private int f4514a;
    private String f4515b;
    private JSONObject f4516c;

    public C1273q(int i, String str, JSONObject jSONObject) {
        super(str);
        this.f4514a = i;
        this.f4515b = str;
        this.f4516c = jSONObject;
    }

    public int m6859a() {
        return this.f4514a;
    }

    public JSONObject m6860b() {
        return this.f4516c;
    }

    public String m6861c() {
        return this.f4515b;
    }
}
