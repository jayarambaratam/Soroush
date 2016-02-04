package com.p032a.p033a.p037d.p046c;

import com.p032a.p033a.p042j.C0879h;
import java.util.Queue;

/* renamed from: com.a.a.d.c.r */
final class C0724r<A> {
    private static final Queue<C0724r<?>> f2742a;
    private int f2743b;
    private int f2744c;
    private A f2745d;

    static {
        f2742a = C0879h.m5306a(0);
    }

    private C0724r() {
    }

    static <A> C0724r<A> m4783a(A a, int i, int i2) {
        C0724r<A> c0724r = (C0724r) f2742a.poll();
        if (c0724r == null) {
            c0724r = new C0724r();
        }
        c0724r.m4784b(a, i, i2);
        return c0724r;
    }

    private void m4784b(A a, int i, int i2) {
        this.f2745d = a;
        this.f2744c = i;
        this.f2743b = i2;
    }

    public void m4785a() {
        f2742a.offer(this);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0724r)) {
            return false;
        }
        C0724r c0724r = (C0724r) obj;
        return this.f2744c == c0724r.f2744c && this.f2743b == c0724r.f2743b && this.f2745d.equals(c0724r.f2745d);
    }

    public int hashCode() {
        return (((this.f2743b * 31) + this.f2744c) * 31) + this.f2745d.hashCode();
    }
}
