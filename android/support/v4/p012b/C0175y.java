package android.support.v4.p012b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: android.support.v4.b.y */
final class C0175y implements ThreadFactory {
    private final AtomicInteger f1090a;

    C0175y() {
        this.f1090a = new AtomicInteger(1);
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "ModernAsyncTask #" + this.f1090a.getAndIncrement());
    }
}
