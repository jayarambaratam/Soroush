package com.p032a.p033a.p037d.p049d.p054d;

import com.p032a.p033a.p035b.C0580e;
import com.p032a.p033a.p042j.C0879h;
import java.util.Queue;

/* renamed from: com.a.a.d.d.d.r */
class C0789r {
    private final Queue<C0580e> f2873a;

    C0789r() {
        this.f2873a = C0879h.m5306a(0);
    }

    public synchronized C0580e m4990a(byte[] bArr) {
        C0580e c0580e;
        c0580e = (C0580e) this.f2873a.poll();
        if (c0580e == null) {
            c0580e = new C0580e();
        }
        return c0580e.m4367a(bArr);
    }

    public synchronized void m4991a(C0580e c0580e) {
        c0580e.m4368a();
        this.f2873a.offer(c0580e);
    }
}
