package com.p032a.p033a.p037d.p039b.p040a;

import android.graphics.Bitmap.Config;

/* renamed from: com.a.a.d.b.a.q */
final class C0615q implements C0601n {
    private final C0616r f2568a;
    private int f2569b;
    private Config f2570c;

    public C0615q(C0616r c0616r) {
        this.f2568a = c0616r;
    }

    public void m4557a() {
        this.f2568a.m4502a(this);
    }

    public void m4558a(int i, Config config) {
        this.f2569b = i;
        this.f2570c = config;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0615q)) {
            return false;
        }
        C0615q c0615q = (C0615q) obj;
        if (this.f2569b != c0615q.f2569b) {
            return false;
        }
        if (this.f2570c == null) {
            if (c0615q.f2570c != null) {
                return false;
            }
        } else if (!this.f2570c.equals(c0615q.f2570c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f2570c != null ? this.f2570c.hashCode() : 0) + (this.f2569b * 31);
    }

    public String toString() {
        return C0613o.m4548b(this.f2569b, this.f2570c);
    }
}
