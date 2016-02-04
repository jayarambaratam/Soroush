package com.p032a.p033a.p045h;

/* renamed from: com.a.a.h.j */
public class C0867j implements C0860d, C0863e {
    private C0860d f3030a;
    private C0860d f3031b;
    private C0863e f3032c;

    public C0867j() {
        this(null);
    }

    public C0867j(C0863e c0863e) {
        this.f3032c = c0863e;
    }

    private boolean m5240j() {
        return this.f3032c == null || this.f3032c.m5220a(this);
    }

    private boolean m5241k() {
        return this.f3032c == null || this.f3032c.m5221b(this);
    }

    private boolean m5242l() {
        return this.f3032c != null && this.f3032c.m5223c();
    }

    public void m5243a() {
        this.f3030a.m5185a();
        this.f3031b.m5185a();
    }

    public void m5244a(C0860d c0860d, C0860d c0860d2) {
        this.f3030a = c0860d;
        this.f3031b = c0860d2;
    }

    public boolean m5245a(C0860d c0860d) {
        return m5240j() && (c0860d.equals(this.f3030a) || !this.f3030a.m5191h());
    }

    public void m5246b() {
        if (!this.f3031b.m5189f()) {
            this.f3031b.m5186b();
        }
        if (!this.f3030a.m5189f()) {
            this.f3030a.m5186b();
        }
    }

    public boolean m5247b(C0860d c0860d) {
        return m5241k() && c0860d.equals(this.f3030a) && !m5249c();
    }

    public void m5248c(C0860d c0860d) {
        if (!c0860d.equals(this.f3031b)) {
            if (this.f3032c != null) {
                this.f3032c.m5222c(this);
            }
            if (!this.f3031b.m5190g()) {
                this.f3031b.m5187d();
            }
        }
    }

    public boolean m5249c() {
        return m5242l() || m5254h();
    }

    public void m5250d() {
        this.f3031b.m5187d();
        this.f3030a.m5187d();
    }

    public void m5251e() {
        this.f3030a.m5188e();
        this.f3031b.m5188e();
    }

    public boolean m5252f() {
        return this.f3030a.m5189f();
    }

    public boolean m5253g() {
        return this.f3030a.m5190g() || this.f3031b.m5190g();
    }

    public boolean m5254h() {
        return this.f3030a.m5191h() || this.f3031b.m5191h();
    }

    public boolean m5255i() {
        return this.f3030a.m5192i();
    }
}
