package com.p032a.p033a.p037d.p039b.p043c;

import java.util.concurrent.FutureTask;

/* renamed from: com.a.a.d.b.c.e */
class C0644e<T> extends FutureTask<T> implements Comparable<C0644e<?>> {
    private final int f2613a;
    private final int f2614b;

    public C0644e(Runnable runnable, T t, int i) {
        super(runnable, t);
        if (runnable instanceof C0648i) {
            this.f2613a = ((C0648i) runnable).m4634b();
            this.f2614b = i;
            return;
        }
        throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
    }

    public int m4630a(C0644e<?> c0644e) {
        int i = this.f2613a - c0644e.f2613a;
        return i == 0 ? this.f2614b - c0644e.f2614b : i;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m4630a((C0644e) obj);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0644e)) {
            return false;
        }
        C0644e c0644e = (C0644e) obj;
        return this.f2614b == c0644e.f2614b && this.f2613a == c0644e.f2613a;
    }

    public int hashCode() {
        return (this.f2613a * 31) + this.f2614b;
    }
}
