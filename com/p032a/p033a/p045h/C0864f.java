package com.p032a.p033a.p045h;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.p032a.p033a.p042j.C0879h;
import com.p032a.p033a.p045h.p056b.C0855h;
import com.p032a.p033a.p045h.p060a.C0841d;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.a.a.h.f */
public class C0864f<T, R> implements C0848a<R>, Runnable {
    private static final C0865g f3018a;
    private final Handler f3019b;
    private final int f3020c;
    private final int f3021d;
    private final boolean f3022e;
    private final C0865g f3023f;
    private R f3024g;
    private C0860d f3025h;
    private boolean f3026i;
    private Exception f3027j;
    private boolean f3028k;
    private boolean f3029l;

    static {
        f3018a = new C0865g();
    }

    public C0864f(Handler handler, int i, int i2) {
        this(handler, i, i2, true, f3018a);
    }

    C0864f(Handler handler, int i, int i2, boolean z, C0865g c0865g) {
        this.f3019b = handler;
        this.f3020c = i;
        this.f3021d = i2;
        this.f3022e = z;
        this.f3023f = c0865g;
    }

    private synchronized R m5224a(Long l) {
        R r;
        if (this.f3022e) {
            C0879h.m5309b();
        }
        if (this.f3026i) {
            throw new CancellationException();
        } else if (this.f3029l) {
            throw new ExecutionException(this.f3027j);
        } else if (this.f3028k) {
            r = this.f3024g;
        } else {
            if (l == null) {
                this.f3023f.m5237a(this, 0);
            } else if (l.longValue() > 0) {
                this.f3023f.m5237a(this, l.longValue());
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.f3029l) {
                throw new ExecutionException(this.f3027j);
            } else if (this.f3026i) {
                throw new CancellationException();
            } else if (this.f3028k) {
                r = this.f3024g;
            } else {
                throw new TimeoutException();
            }
        }
        return r;
    }

    public C0860d m5225a() {
        return this.f3025h;
    }

    public void m5226a(Drawable drawable) {
    }

    public void m5227a(C0855h c0855h) {
        c0855h.m5171a(this.f3020c, this.f3021d);
    }

    public void m5228a(C0860d c0860d) {
        this.f3025h = c0860d;
    }

    public synchronized void m5229a(Exception exception, Drawable drawable) {
        this.f3029l = true;
        this.f3027j = exception;
        this.f3023f.m5236a(this);
    }

    public synchronized void m5230a(R r, C0841d<? super R> c0841d) {
        this.f3028k = true;
        this.f3024g = r;
        this.f3023f.m5236a(this);
    }

    public void m5231b() {
        this.f3019b.post(this);
    }

    public void m5232b(Drawable drawable) {
    }

    public synchronized boolean cancel(boolean z) {
        boolean z2 = true;
        synchronized (this) {
            if (!this.f3026i) {
                if (isDone()) {
                    z2 = false;
                }
                if (z2) {
                    this.f3026i = true;
                    if (z) {
                        m5231b();
                    }
                    this.f3023f.m5236a(this);
                }
            }
        }
        return z2;
    }

    public void m5233d() {
    }

    public void m5234e() {
    }

    public void m5235f() {
    }

    public R get() {
        try {
            return m5224a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public R get(long j, TimeUnit timeUnit) {
        return m5224a(Long.valueOf(timeUnit.toMillis(j)));
    }

    public synchronized boolean isCancelled() {
        return this.f3026i;
    }

    public synchronized boolean isDone() {
        boolean z;
        z = this.f3026i || this.f3028k;
        return z;
    }

    public void run() {
        if (this.f3025h != null) {
            this.f3025h.m5187d();
            cancel(false);
        }
    }
}
