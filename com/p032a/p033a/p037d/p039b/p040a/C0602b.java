package com.p032a.p033a.p037d.p039b.p040a;

import android.graphics.Bitmap.Config;

/* renamed from: com.a.a.d.b.a.b */
class C0602b implements C0601n {
    private final C0604c f2538a;
    private int f2539b;
    private int f2540c;
    private Config f2541d;

    public C0602b(C0604c c0604c) {
        this.f2538a = c0604c;
    }

    public void m4500a() {
        this.f2538a.m4502a(this);
    }

    public void m4501a(int i, int i2, Config config) {
        this.f2539b = i;
        this.f2540c = i2;
        this.f2541d = config;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0602b)) {
            return false;
        }
        C0602b c0602b = (C0602b) obj;
        return this.f2539b == c0602b.f2539b && this.f2540c == c0602b.f2540c && this.f2541d == c0602b.f2541d;
    }

    public int hashCode() {
        return (this.f2541d != null ? this.f2541d.hashCode() : 0) + (((this.f2539b * 31) + this.f2540c) * 31);
    }

    public String toString() {
        return C0600a.m4491d(this.f2539b, this.f2540c, this.f2541d);
    }
}
