package com.felipecsl.asymmetricgridview.library;

import android.annotation.TargetApi;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

@TargetApi(9)
/* renamed from: com.felipecsl.asymmetricgridview.library.i */
class C1049i implements Executor {
    final ArrayDeque<Runnable> f3939a;
    Runnable f3940b;

    private C1049i() {
        this.f3939a = new ArrayDeque();
    }

    protected synchronized void m6241a() {
        Runnable runnable = (Runnable) this.f3939a.poll();
        this.f3940b = runnable;
        if (runnable != null) {
            C1041b.f3918a.execute(this.f3940b);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.f3939a.offer(new C1050j(this, runnable));
        if (this.f3940b == null) {
            m6241a();
        }
    }
}
