package com.p032a.p033a;

/* renamed from: com.a.a.q */
public final class C0888q {
    final /* synthetic */ C0887p f3096a;
    private final A f3097b;
    private final Class<A> f3098c;
    private final boolean f3099d;

    C0888q(C0887p c0887p, A a) {
        this.f3096a = c0887p;
        this.f3099d = true;
        this.f3097b = a;
        this.f3098c = C0884m.m5322b((Object) a);
    }

    public <Z> C0868h<A, T, Z> m5345a(Class<Z> cls) {
        C0868h<A, T, Z> c0868h = (C0868h) this.f3096a.f3093a.f3089f.m5346a(new C0868h(this.f3096a.f3093a.f3084a, this.f3096a.f3093a.f3088e, this.f3098c, this.f3096a.f3094b, this.f3096a.f3095c, cls, this.f3096a.f3093a.f3087d, this.f3096a.f3093a.f3085b, this.f3096a.f3093a.f3089f));
        if (this.f3099d) {
            c0868h.m4294b(this.f3097b);
        }
        return c0868h;
    }
}
