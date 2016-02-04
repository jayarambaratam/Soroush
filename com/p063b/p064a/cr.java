package com.p063b.p064a;

import java.util.Locale;
import org.apache.http.myHttp.HttpStatus;

/* renamed from: com.b.a.cr */
public class cr {
    protected String f3517a;
    protected int f3518b;

    public cr(String str) {
        this.f3518b = 0;
        this.f3517a = str.trim();
    }

    private int m5743a() {
        if (m5750c()) {
            return this.f3518b;
        }
        int i = this.f3518b;
        int i2 = this.f3518b;
        int charAt = this.f3517a.charAt(this.f3518b);
        if (charAt == 45 || charAt == 43) {
            charAt = m5759l();
        }
        if (Character.isDigit(charAt)) {
            i = this.f3518b + 1;
            charAt = m5759l();
            while (Character.isDigit(charAt)) {
                i = this.f3518b + 1;
                charAt = m5759l();
            }
        }
        if (charAt == 46) {
            i = this.f3518b + 1;
            charAt = m5759l();
            while (Character.isDigit(charAt)) {
                i = this.f3518b + 1;
                charAt = m5759l();
            }
        }
        if (charAt == HttpStatus.SC_SWITCHING_PROTOCOLS || charAt == 69) {
            charAt = m5759l();
            if (charAt == 45 || charAt == 43) {
                charAt = m5759l();
            }
            if (Character.isDigit(charAt)) {
                i = this.f3518b + 1;
                charAt = m5759l();
                while (Character.isDigit(charAt)) {
                    i = this.f3518b + 1;
                    charAt = m5759l();
                }
            }
        }
        this.f3518b = i2;
        return i;
    }

    private int m5744b() {
        if (m5750c()) {
            return this.f3518b;
        }
        int i = this.f3518b;
        int i2 = this.f3518b;
        int charAt = this.f3517a.charAt(this.f3518b);
        if (charAt == 45 || charAt == 43) {
            charAt = m5759l();
        }
        if (Character.isDigit(charAt)) {
            i = this.f3518b + 1;
            charAt = m5759l();
            while (Character.isDigit(charAt)) {
                i = this.f3518b + 1;
                charAt = m5759l();
            }
        }
        this.f3518b = i2;
        return i;
    }

    public boolean m5745a(char c) {
        boolean z = this.f3518b < this.f3517a.length() && this.f3517a.charAt(this.f3518b) == c;
        if (z) {
            this.f3518b++;
        }
        return z;
    }

    protected boolean m5746a(int i) {
        return i == 32 || i == 10 || i == 13 || i == 9;
    }

    public boolean m5747a(String str) {
        int length = str.length();
        boolean z = this.f3518b <= this.f3517a.length() - length && this.f3517a.substring(this.f3518b, this.f3518b + length).equals(str);
        if (z) {
            this.f3518b = length + this.f3518b;
        }
        return z;
    }

    public String m5748b(char c) {
        if (m5750c()) {
            return null;
        }
        char charAt = this.f3517a.charAt(this.f3518b);
        if (m5746a((int) charAt) || charAt == c) {
            return null;
        }
        int i = this.f3518b;
        int l = m5759l();
        while (l != -1 && l != c && !m5746a(l)) {
            l = m5759l();
        }
        return this.f3517a.substring(i, this.f3518b);
    }

    protected boolean m5749b(int i) {
        return i == 10 || i == 13;
    }

    public boolean m5750c() {
        return this.f3518b == this.f3517a.length();
    }

    public void m5751d() {
        while (this.f3518b < this.f3517a.length() && m5746a(this.f3517a.charAt(this.f3518b))) {
            this.f3518b++;
        }
    }

    public boolean m5752e() {
        m5751d();
        if (this.f3518b == this.f3517a.length() || this.f3517a.charAt(this.f3518b) != ',') {
            return false;
        }
        this.f3518b++;
        m5751d();
        return true;
    }

    public Float m5753f() {
        int a = m5743a();
        if (a == this.f3518b) {
            return null;
        }
        Float valueOf = Float.valueOf(Float.parseFloat(this.f3517a.substring(this.f3518b, a)));
        this.f3518b = a;
        return valueOf;
    }

    public Float m5754g() {
        int i = this.f3518b;
        m5752e();
        Float f = m5753f();
        if (f != null) {
            return f;
        }
        this.f3518b = i;
        return null;
    }

    public Integer m5755h() {
        int b = m5744b();
        if (b == this.f3518b) {
            return null;
        }
        Integer valueOf = Integer.valueOf(Integer.parseInt(this.f3517a.substring(this.f3518b, b)));
        this.f3518b = b;
        return valueOf;
    }

    public Integer m5756i() {
        if (this.f3518b == this.f3517a.length()) {
            return null;
        }
        String str = this.f3517a;
        int i = this.f3518b;
        this.f3518b = i + 1;
        return Integer.valueOf(str.charAt(i));
    }

    public ac m5757j() {
        Float f = m5753f();
        if (f == null) {
            return null;
        }
        by p = m5763p();
        return p == null ? new ac(f.floatValue(), by.px) : new ac(f.floatValue(), p);
    }

    public Boolean m5758k() {
        if (this.f3518b == this.f3517a.length()) {
            return null;
        }
        char charAt = this.f3517a.charAt(this.f3518b);
        if (charAt != '0' && charAt != '1') {
            return null;
        }
        this.f3518b++;
        return Boolean.valueOf(charAt == '1');
    }

    protected int m5759l() {
        if (this.f3518b == this.f3517a.length()) {
            return -1;
        }
        this.f3518b++;
        return this.f3518b < this.f3517a.length() ? this.f3517a.charAt(this.f3518b) : -1;
    }

    public String m5760m() {
        return m5748b(' ');
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String m5761n() {
        /*
        r5 = this;
        r1 = 0;
        r0 = r5.m5750c();
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        r0 = r1;
    L_0x0008:
        return r0;
    L_0x0009:
        r2 = r5.f3518b;
        r0 = r5.f3517a;
        r3 = r5.f3518b;
        r0 = r0.charAt(r3);
    L_0x0013:
        r3 = 97;
        if (r0 < r3) goto L_0x001b;
    L_0x0017:
        r3 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        if (r0 <= r3) goto L_0x003c;
    L_0x001b:
        r3 = 65;
        if (r0 < r3) goto L_0x0023;
    L_0x001f:
        r3 = 90;
        if (r0 <= r3) goto L_0x003c;
    L_0x0023:
        r3 = r5.f3518b;
    L_0x0025:
        r4 = r5.m5746a(r0);
        if (r4 != 0) goto L_0x0041;
    L_0x002b:
        r4 = 40;
        if (r0 != r4) goto L_0x0046;
    L_0x002f:
        r0 = r5.f3518b;
        r0 = r0 + 1;
        r5.f3518b = r0;
        r0 = r5.f3517a;
        r0 = r0.substring(r2, r3);
        goto L_0x0008;
    L_0x003c:
        r0 = r5.m5759l();
        goto L_0x0013;
    L_0x0041:
        r0 = r5.m5759l();
        goto L_0x0025;
    L_0x0046:
        r5.f3518b = r2;
        r0 = r1;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.b.a.cr.n():java.lang.String");
    }

    public String m5762o() {
        int i = this.f3518b;
        while (!m5750c() && !m5746a(this.f3517a.charAt(this.f3518b))) {
            this.f3518b++;
        }
        String substring = this.f3517a.substring(i, this.f3518b);
        this.f3518b = i;
        return substring;
    }

    public by m5763p() {
        if (m5750c()) {
            return null;
        }
        if (this.f3517a.charAt(this.f3518b) == '%') {
            this.f3518b++;
            return by.percent;
        } else if (this.f3518b > this.f3517a.length() - 2) {
            return null;
        } else {
            try {
                by valueOf = by.valueOf(this.f3517a.substring(this.f3518b, this.f3518b + 2).toLowerCase(Locale.US));
                this.f3518b += 2;
                return valueOf;
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    public boolean m5764q() {
        if (this.f3518b == this.f3517a.length()) {
            return false;
        }
        char charAt = this.f3517a.charAt(this.f3518b);
        return (charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z');
    }

    public String m5765r() {
        if (m5750c()) {
            return null;
        }
        int i = this.f3518b;
        char charAt = this.f3517a.charAt(this.f3518b);
        if (charAt != '\'' && charAt != '\"') {
            return null;
        }
        char l = m5759l();
        while (l != '\uffff' && l != charAt) {
            l = m5759l();
        }
        if (l == '\uffff') {
            this.f3518b = i;
            return null;
        }
        this.f3518b++;
        return this.f3517a.substring(i + 1, this.f3518b - 1);
    }

    public String m5766s() {
        if (m5750c()) {
            return null;
        }
        int i = this.f3518b;
        this.f3518b = this.f3517a.length();
        return this.f3517a.substring(i);
    }
}
