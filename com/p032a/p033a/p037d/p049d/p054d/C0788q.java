package com.p032a.p033a.p037d.p049d.p054d;

import com.p032a.p033a.p035b.C0576a;
import com.p032a.p033a.p035b.C0577b;
import com.p032a.p033a.p042j.C0879h;
import java.util.Queue;

/* renamed from: com.a.a.d.d.d.q */
class C0788q {
    private final Queue<C0576a> f2872a;

    C0788q() {
        this.f2872a = C0879h.m5306a(0);
    }

    public synchronized C0576a m4988a(C0577b c0577b) {
        C0576a c0576a;
        c0576a = (C0576a) this.f2872a.poll();
        if (c0576a == null) {
            c0576a = new C0576a(c0577b);
        }
        return c0576a;
    }

    public synchronized void m4989a(C0576a c0576a) {
        c0576a.m4348g();
        this.f2872a.offer(c0576a);
    }
}
