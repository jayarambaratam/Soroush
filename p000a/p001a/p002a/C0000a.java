package p000a.p001a.p002a;

/* renamed from: a.a.a.a */
class C0000a implements Runnable {
    private final C0011l f0a;
    private final C0002c f1b;

    C0000a(C0002c c0002c) {
        this.f1b = c0002c;
        this.f0a = new C0011l();
    }

    public void m0a(C0015p c0015p, Object obj) {
        this.f0a.m24a(C0010k.m20a(c0015p, obj));
        this.f1b.m15b().execute(this);
    }

    public void run() {
        C0010k a = this.f0a.m22a();
        if (a == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f1b.m12a(a);
    }
}
