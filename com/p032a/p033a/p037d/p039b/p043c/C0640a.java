package com.p032a.p033a.p037d.p039b.p043c;

import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.a.a.d.b.c.a */
public class C0640a extends ThreadPoolExecutor {
    private final AtomicInteger f2609a;
    private final C0645f f2610b;

    public C0640a(int i) {
        this(i, C0645f.LOG);
    }

    public C0640a(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory, C0645f c0645f) {
        super(i, i2, j, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.f2609a = new AtomicInteger();
        this.f2610b = c0645f;
    }

    public C0640a(int i, C0645f c0645f) {
        this(i, i, 0, TimeUnit.MILLISECONDS, new C0642c(), c0645f);
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (future.isDone() && !future.isCancelled()) {
                try {
                    future.get();
                } catch (Throwable e) {
                    this.f2610b.m4631a(e);
                } catch (Throwable e2) {
                    this.f2610b.m4631a(e2);
                }
            }
        }
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C0644e(runnable, t, this.f2609a.getAndIncrement());
    }
}
