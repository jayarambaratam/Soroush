package android.support.v4.p012b;

import android.os.Handler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.linphone.core.VideoSize;

/* renamed from: android.support.v4.b.x */
abstract class C0156x<Params, Progress, Result> {
    private static final ThreadFactory f1067a;
    private static final BlockingQueue<Runnable> f1068b;
    public static final Executor f1069c;
    private static ad f1070d;
    private static volatile Executor f1071e;
    private final af<Params, Result> f1072f;
    private final FutureTask<Result> f1073g;
    private volatile ae f1074h;
    private final AtomicBoolean f1075i;

    static {
        f1067a = new C0175y();
        f1068b = new LinkedBlockingQueue(10);
        f1069c = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f1068b, f1067a);
        f1071e = f1069c;
    }

    public C0156x() {
        this.f1074h = ae.PENDING;
        this.f1075i = new AtomicBoolean();
        this.f1072f = new C0176z(this);
        this.f1073g = new aa(this, this.f1072f);
    }

    private void m1497c(Result result) {
        if (!this.f1075i.get()) {
            m1499d(result);
        }
    }

    private static Handler m1498d() {
        Handler handler;
        synchronized (C0156x.class) {
            if (f1070d == null) {
                f1070d = new ad();
            }
            handler = f1070d;
        }
        return handler;
    }

    private Result m1499d(Result result) {
        C0156x.m1498d().obtainMessage(1, new ac(this, result)).sendToTarget();
        return result;
    }

    private void m1500e(Result result) {
        if (m1509c()) {
            m1507b((Object) result);
        } else {
            m1504a((Object) result);
        }
        this.f1074h = ae.FINISHED;
    }

    public final C0156x<Params, Progress, Result> m1501a(Executor executor, Params... paramsArr) {
        if (this.f1074h != ae.PENDING) {
            switch (ab.f1059a[this.f1074h.ordinal()]) {
                case VideoSize.CIF /*1*/:
                    throw new IllegalStateException("Cannot execute task: the task is already running.");
                case VideoSize.HVGA /*2*/:
                    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.f1074h = ae.RUNNING;
        m1503a();
        this.f1072f.f1066b = paramsArr;
        executor.execute(this.f1073g);
        return this;
    }

    protected abstract Result m1502a(Params... paramsArr);

    protected void m1503a() {
    }

    protected void m1504a(Result result) {
    }

    public final boolean m1505a(boolean z) {
        return this.f1073g.cancel(z);
    }

    protected void m1506b() {
    }

    protected void m1507b(Result result) {
        m1506b();
    }

    protected void m1508b(Progress... progressArr) {
    }

    public final boolean m1509c() {
        return this.f1073g.isCancelled();
    }
}
