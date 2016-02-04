package com.p032a.p033a.p037d.p039b.p040a;

import com.p032a.p033a.p042j.C0879h;
import java.util.Queue;

/* renamed from: com.a.a.d.b.a.d */
abstract class C0603d<T extends C0601n> {
    private final Queue<T> f2542a;

    C0603d() {
        this.f2542a = C0879h.m5306a(20);
    }

    public void m4502a(T t) {
        if (this.f2542a.size() < 20) {
            this.f2542a.offer(t);
        }
    }

    protected abstract T m4503b();

    protected T m4504c() {
        C0601n c0601n = (C0601n) this.f2542a.poll();
        return c0601n == null ? m4503b() : c0601n;
    }
}
