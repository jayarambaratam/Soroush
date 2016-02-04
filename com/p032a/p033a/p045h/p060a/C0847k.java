package com.p032a.p033a.p045h.p060a;

/* renamed from: com.a.a.h.a.k */
public class C0847k<R> implements C0837f<R> {
    private final C0839j f2961a;
    private C0841d<R> f2962b;

    C0847k(C0839j c0839j) {
        this.f2961a = c0839j;
    }

    public C0841d<R> m5147a(boolean z, boolean z2) {
        if (z || !z2) {
            return C0844g.m5142b();
        }
        if (this.f2962b == null) {
            this.f2962b = new C0846i(this.f2961a);
        }
        return this.f2962b;
    }
}
