package mobi.mmdt.ott.p095c.p096a;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: mobi.mmdt.ott.c.a.m */
public class C1263m {
    SharedPreferences f4498a;
    String f4499b;
    Context f4500c;
    String f4501d;
    String f4502e;
    String f4503f;
    String f4504g;
    String f4505h;
    String f4506i;
    String f4507j;
    String f4508k;
    String f4509l;
    String f4510m;
    String f4511n;

    public C1263m(Context context) {
        this.f4499b = "TestWebService";
        this.f4501d = "ClientTimeStamp";
        this.f4502e = "ClientNonce";
        this.f4503f = "ServerTimeStamp";
        this.f4504g = "ServerNonce";
        this.f4505h = "ServerHashMethod";
        this.f4506i = "ServerEncryptionMethod";
        this.f4507j = "ServerEToken";
        this.f4508k = "ServerIv";
        this.f4509l = "Token";
        this.f4510m = "ServerAddress";
        this.f4511n = "FileId";
        this.f4500c = context;
        this.f4498a = this.f4500c.getSharedPreferences(this.f4499b, 0);
    }

    public String m6839a() {
        return this.f4498a.getString(this.f4501d, null);
    }

    public void m6840a(String str) {
        this.f4498a.edit().putString(this.f4501d, str).apply();
    }

    public String m6841b() {
        return this.f4498a.getString(this.f4502e, null);
    }

    public void m6842b(String str) {
        this.f4498a.edit().putString(this.f4502e, str).apply();
    }

    public String m6843c() {
        return this.f4498a.getString(this.f4503f, null);
    }

    public void m6844c(String str) {
        this.f4498a.edit().putString(this.f4503f, str).apply();
    }

    public String m6845d() {
        return this.f4498a.getString(this.f4504g, null);
    }

    public void m6846d(String str) {
        this.f4498a.edit().putString(this.f4504g, str).apply();
    }

    public String m6847e() {
        return this.f4498a.getString(this.f4505h, null);
    }

    public void m6848e(String str) {
        this.f4498a.edit().putString(this.f4505h, str).apply();
    }

    public String m6849f() {
        return this.f4498a.getString(this.f4506i, null);
    }

    public void m6850f(String str) {
        this.f4498a.edit().putString(this.f4506i, str).apply();
    }

    public String m6851g() {
        return this.f4498a.getString(this.f4509l, null);
    }

    public void m6852g(String str) {
        this.f4498a.edit().putString(this.f4509l, str).apply();
    }
}
