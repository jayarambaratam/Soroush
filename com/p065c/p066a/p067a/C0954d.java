package com.p065c.p066a.p067a;

/* renamed from: com.c.a.a.d */
public class C0954d {
    protected Long f3635a;
    protected int f3636b;
    protected String f3637c;
    protected int f3638d;
    protected long f3639e;
    protected long f3640f;
    protected long f3641g;
    protected boolean f3642h;
    transient C0944a f3643i;

    public C0954d(int i, C0944a c0944a, long j, long j2) {
        this(null, i, c0944a.m5835f(), 0, c0944a, System.nanoTime(), j, j2);
    }

    public C0954d(Long l, int i, String str, int i2, C0944a c0944a, long j, long j2, long j3) {
        this.f3635a = l;
        this.f3636b = i;
        this.f3637c = str;
        this.f3638d = i2;
        this.f3640f = j;
        this.f3639e = j2;
        this.f3643i = c0944a;
        this.f3641g = j3;
        this.f3642h = c0944a.m5834e();
    }

    public Long m5886a() {
        return this.f3635a;
    }

    public void m5887a(long j) {
        this.f3641g = j;
    }

    public void m5888a(Long l) {
        this.f3635a = l;
    }

    public final boolean m5889a(int i) {
        return this.f3643i.m5829a(i);
    }

    public void m5890b(int i) {
        this.f3638d = i;
    }

    public boolean m5891b() {
        return this.f3642h;
    }

    public int m5892c() {
        return this.f3636b;
    }

    public int m5893d() {
        return this.f3638d;
    }

    public long m5894e() {
        return this.f3640f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0954d)) {
            return false;
        }
        C0954d c0954d = (C0954d) obj;
        return (this.f3635a == null || c0954d.f3635a == null) ? false : this.f3635a.equals(c0954d.f3635a);
    }

    public long m5895f() {
        return this.f3641g;
    }

    public long m5896g() {
        return this.f3639e;
    }

    public C0944a m5897h() {
        return this.f3643i;
    }

    public int hashCode() {
        return this.f3635a == null ? super.hashCode() : this.f3635a.intValue();
    }

    public String m5898i() {
        return this.f3637c;
    }
}
