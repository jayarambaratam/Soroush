package com.p065c.p066a.p067a;

import com.p065c.p066a.p067a.p071d.C0952b;
import com.p065c.p066a.p067a.p072e.C0956b;
import com.p065c.p066a.p067a.p073f.C0960a;
import java.util.concurrent.TimeUnit;

/* renamed from: com.c.a.a.g */
class C0976g implements C0952b {
    final /* synthetic */ C0959e f3684a;

    C0976g(C0959e c0959e) {
        this.f3684a = c0959e;
    }

    public C0954d m5993a(int i, TimeUnit timeUnit) {
        C0954d c = this.f3684a.m5930d();
        if (c == null) {
            long nanoTime = System.nanoTime() + timeUnit.toNanos((long) i);
            long a = this.f3684a.m5915a(null);
            while (c == null && nanoTime > System.nanoTime()) {
                C0954d c2;
                if (this.f3684a.f3646b) {
                    c2 = this.f3684a.m5930d();
                } else {
                    Object obj = null;
                }
                if (c2 == null) {
                    long nanoTime2 = nanoTime - System.nanoTime();
                    if (nanoTime2 > 0) {
                        nanoTime2 = Math.min(a, TimeUnit.NANOSECONDS.toMillis(nanoTime2));
                        if (nanoTime2 < 1) {
                            c = c2;
                        } else if (this.f3684a.f3648d instanceof C0960a) {
                            synchronized (this.f3684a.f3654j) {
                                try {
                                    this.f3684a.f3654j.wait(nanoTime2);
                                } catch (Throwable e) {
                                    C0956b.m5905a(e, "exception while waiting for a new job.", new Object[0]);
                                }
                            }
                        } else {
                            synchronized (this.f3684a.f3654j) {
                                try {
                                    this.f3684a.f3654j.wait(Math.min(500, nanoTime2));
                                } catch (Throwable e2) {
                                    C0956b.m5905a(e2, "exception while waiting for a new job.", new Object[0]);
                                }
                            }
                        }
                    }
                    c = c2;
                } else {
                    c = c2;
                }
            }
        }
        return c;
    }

    public void m5994a(C0954d c0954d) {
        this.f3684a.m5917a(c0954d);
    }

    public boolean m5995a() {
        return this.f3684a.f3646b;
    }

    public int m5996b() {
        return this.f3684a.m5921b(this.f3684a.f3648d instanceof C0960a ? this.f3684a.m5929c() : true);
    }

    public void m5997b(C0954d c0954d) {
        this.f3684a.m5923b(c0954d);
    }
}
