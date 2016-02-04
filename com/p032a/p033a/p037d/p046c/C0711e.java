package com.p032a.p033a.p037d.p046c;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.util.Map;

/* renamed from: com.a.a.d.c.e */
public class C0711e {
    private final URL f2715a;
    private final C0712f f2716b;
    private final String f2717c;
    private String f2718d;
    private URL f2719e;

    public C0711e(String str) {
        this(str, C0712f.f2721b);
    }

    public C0711e(String str, C0712f c0712f) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + str);
        } else if (c0712f == null) {
            throw new IllegalArgumentException("Headers must not be null");
        } else {
            this.f2717c = str;
            this.f2715a = null;
            this.f2716b = c0712f;
        }
    }

    public C0711e(URL url) {
        this(url, C0712f.f2721b);
    }

    public C0711e(URL url, C0712f c0712f) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        } else if (c0712f == null) {
            throw new IllegalArgumentException("Headers must not be null");
        } else {
            this.f2715a = url;
            this.f2717c = null;
            this.f2716b = c0712f;
        }
    }

    private URL m4756d() {
        if (this.f2719e == null) {
            this.f2719e = new URL(m4757e());
        }
        return this.f2719e;
    }

    private String m4757e() {
        if (TextUtils.isEmpty(this.f2718d)) {
            String str = this.f2717c;
            if (TextUtils.isEmpty(str)) {
                str = this.f2715a.toString();
            }
            this.f2718d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        }
        return this.f2718d;
    }

    public URL m4758a() {
        return m4756d();
    }

    public Map<String, String> m4759b() {
        return this.f2716b.m4761a();
    }

    public String m4760c() {
        return this.f2717c != null ? this.f2717c : this.f2715a.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0711e)) {
            return false;
        }
        C0711e c0711e = (C0711e) obj;
        return m4760c().equals(c0711e.m4760c()) && this.f2716b.equals(c0711e.f2716b);
    }

    public int hashCode() {
        return (m4760c().hashCode() * 31) + this.f2716b.hashCode();
    }

    public String toString() {
        return m4760c() + '\n' + this.f2716b.toString();
    }
}
