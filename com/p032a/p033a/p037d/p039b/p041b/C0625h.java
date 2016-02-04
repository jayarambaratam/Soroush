package com.p032a.p033a.p037d.p039b.p041b;

import java.util.ArrayDeque;
import java.util.Queue;

/* renamed from: com.a.a.d.b.b.h */
class C0625h {
    private final Queue<C0624g> f2588a;

    private C0625h() {
        this.f2588a = new ArrayDeque();
    }

    C0624g m4586a() {
        C0624g c0624g;
        synchronized (this.f2588a) {
            c0624g = (C0624g) this.f2588a.poll();
        }
        return c0624g == null ? new C0624g() : c0624g;
    }

    void m4587a(C0624g c0624g) {
        synchronized (this.f2588a) {
            if (this.f2588a.size() < 10) {
                this.f2588a.offer(c0624g);
            }
        }
    }
}
