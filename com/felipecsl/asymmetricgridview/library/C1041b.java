package com.felipecsl.asymmetricgridview.library;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.linphone.core.VideoSize;

/* renamed from: com.felipecsl.asymmetricgridview.library.b */
public abstract class C1041b<Params, Progress, Result> {
    public static final Executor f3918a;
    public static final Executor f3919b;
    private static final int f3920c;
    private static final int f3921d;
    private static final int f3922e;
    private static final ThreadFactory f3923f;
    private static final BlockingQueue<Runnable> f3924g;
    private static final C1048h f3925h;
    private static volatile Executor f3926i;
    private final C1043l<Params, Result> f3927j;
    private final FutureTask<Result> f3928k;
    private volatile C1051k f3929l;
    private final AtomicBoolean f3930m;
    private final AtomicBoolean f3931n;

    static {
        f3920c = Runtime.getRuntime().availableProcessors();
        f3921d = f3920c + 1;
        f3922e = (f3920c * 2) + 1;
        f3923f = new C1042c();
        f3924g = new LinkedBlockingQueue(128);
        f3918a = new ThreadPoolExecutor(f3921d, f3922e, 1, TimeUnit.SECONDS, f3924g, f3923f);
        f3919b = new C1049i();
        f3925h = new C1048h();
        f3926i = f3919b;
    }

    public C1041b() {
        this.f3929l = C1051k.PENDING;
        this.f3930m = new AtomicBoolean();
        this.f3931n = new AtomicBoolean();
        this.f3927j = new C1044d(this);
        this.f3928k = new C1045e(this, this.f3927j);
    }

    private void m6228c(Result result) {
        if (!this.f3931n.get()) {
            m6229d(result);
        }
    }

    private Result m6229d(Result result) {
        f3925h.obtainMessage(1, new C1047g(this, result)).sendToTarget();
        return result;
    }

    private void m6230e(Result result) {
        if (m6240c()) {
            m6237b((Object) result);
        } else {
            m6234a((Object) result);
        }
        this.f3929l = C1051k.FINISHED;
    }

    public final C1041b<Params, Progress, Result> m6231a(Executor executor, Params... paramsArr) {
        if (this.f3929l != C1051k.PENDING) {
            switch (C1046f.f3936a[this.f3929l.ordinal()]) {
                case VideoSize.CIF /*1*/:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case VideoSize.HVGA /*2*/:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f3929l = C1051k.RUNNING;
        m6233a();
        this.f3927j.f3933b = paramsArr;
        executor.execute(this.f3928k);
        return this;
    }

    protected abstract Result m6232a(Params... paramsArr);

    protected void m6233a() {
    }

    protected void m6234a(Result result) {
    }

    public final boolean m6235a(boolean z) {
        this.f3930m.set(true);
        return this.f3928k.cancel(z);
    }

    protected void m6236b() {
    }

    protected void m6237b(Result result) {
        m6236b();
    }

    protected void m6238b(Progress... progressArr) {
    }

    public final C1041b<Params, Progress, Result> m6239c(Params... paramsArr) {
        return m6231a(f3919b, (Object[]) paramsArr);
    }

    public final boolean m6240c() {
        return this.f3930m.get();
    }
}
