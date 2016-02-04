package com.p032a.p033a.p037d.p039b.p043c;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.a.a.d.b.c.c */
public class C0642c implements ThreadFactory {
    int f2611a;

    public C0642c() {
        this.f2611a = 0;
    }

    public Thread newThread(Runnable runnable) {
        Thread c0643d = new C0643d(this, runnable, "fifo-pool-thread-" + this.f2611a);
        this.f2611a++;
        return c0643d;
    }
}
