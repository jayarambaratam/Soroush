package p000a.p001a.p002a;

/* renamed from: a.a.a.l */
final class C0011l {
    private C0010k f51a;
    private C0010k f52b;

    C0011l() {
    }

    synchronized C0010k m22a() {
        C0010k c0010k;
        c0010k = this.f51a;
        if (this.f51a != null) {
            this.f51a = this.f51a.f50c;
            if (this.f51a == null) {
                this.f52b = null;
            }
        }
        return c0010k;
    }

    synchronized C0010k m23a(int i) {
        if (this.f51a == null) {
            wait((long) i);
        }
        return m22a();
    }

    synchronized void m24a(C0010k c0010k) {
        if (c0010k == null) {
            throw new NullPointerException("null cannot be enqueued");
        }
        if (this.f52b != null) {
            this.f52b.f50c = c0010k;
            this.f52b = c0010k;
        } else if (this.f51a == null) {
            this.f52b = c0010k;
            this.f51a = c0010k;
        } else {
            throw new IllegalStateException("Head present, but no tail");
        }
        notifyAll();
    }
}
