package com.felipecsl.asymmetricgridview.library;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.felipecsl.asymmetricgridview.library.c */
final class C1042c implements ThreadFactory {
    private final AtomicInteger f3932a;

    C1042c() {
        this.f3932a = new AtomicInteger(1);
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AsyncTaskCompat #" + this.f3932a.getAndIncrement());
    }
}
