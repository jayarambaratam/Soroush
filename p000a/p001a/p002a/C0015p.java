package p000a.p001a.p002a;

/* renamed from: a.a.a.p */
final class C0015p {
    final Object f63a;
    final C0013n f64b;
    final int f65c;
    volatile boolean f66d;

    C0015p(Object obj, C0013n c0013n, int i) {
        this.f63a = obj;
        this.f64b = c0013n;
        this.f65c = i;
        this.f66d = true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0015p)) {
            return false;
        }
        C0015p c0015p = (C0015p) obj;
        return this.f63a == c0015p.f63a && this.f64b.equals(c0015p.f64b);
    }

    public int hashCode() {
        return this.f63a.hashCode() + this.f64b.f60d.hashCode();
    }
}
