package com.p032a.p033a.p037d.p039b;

import android.os.Handler;
import android.os.Looper;
import com.p032a.p033a.p037d.C0667c;
import com.p032a.p033a.p042j.C0879h;
import com.p032a.p033a.p045h.C0661i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* renamed from: com.a.a.d.b.l */
class C0663l implements C0662v {
    private static final C0665n f2651a;
    private static final Handler f2652b;
    private final List<C0661i> f2653c;
    private final C0665n f2654d;
    private final C0653p f2655e;
    private final C0667c f2656f;
    private final ExecutorService f2657g;
    private final ExecutorService f2658h;
    private final boolean f2659i;
    private boolean f2660j;
    private C0670y<?> f2661k;
    private boolean f2662l;
    private Exception f2663m;
    private boolean f2664n;
    private Set<C0661i> f2665o;
    private C0672u f2666p;
    private C0671s<?> f2667q;
    private volatile Future<?> f2668r;

    static {
        f2651a = new C0665n();
        f2652b = new Handler(Looper.getMainLooper(), new C0666o());
    }

    public C0663l(C0667c c0667c, ExecutorService executorService, ExecutorService executorService2, boolean z, C0653p c0653p) {
        this(c0667c, executorService, executorService2, z, c0653p, f2651a);
    }

    public C0663l(C0667c c0667c, ExecutorService executorService, ExecutorService executorService2, boolean z, C0653p c0653p, C0665n c0665n) {
        this.f2653c = new ArrayList();
        this.f2656f = c0667c;
        this.f2657g = executorService;
        this.f2658h = executorService2;
        this.f2659i = z;
        this.f2655e = c0653p;
        this.f2654d = c0665n;
    }

    private void m4661b() {
        if (this.f2660j) {
            this.f2661k.m4680d();
        } else if (this.f2653c.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else {
            this.f2667q = this.f2654d.m4673a(this.f2661k, this.f2659i);
            this.f2662l = true;
            this.f2667q.m4686e();
            this.f2655e.m4640a(this.f2656f, this.f2667q);
            for (C0661i c0661i : this.f2653c) {
                if (!m4665d(c0661i)) {
                    this.f2667q.m4686e();
                    c0661i.m4657a(this.f2667q);
                }
            }
            this.f2667q.m4687f();
        }
    }

    private void m4663c() {
        if (!this.f2660j) {
            if (this.f2653c.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            this.f2664n = true;
            this.f2655e.m4640a(this.f2656f, null);
            for (C0661i c0661i : this.f2653c) {
                if (!m4665d(c0661i)) {
                    c0661i.m4658a(this.f2663m);
                }
            }
        }
    }

    private void m4664c(C0661i c0661i) {
        if (this.f2665o == null) {
            this.f2665o = new HashSet();
        }
        this.f2665o.add(c0661i);
    }

    private boolean m4665d(C0661i c0661i) {
        return this.f2665o != null && this.f2665o.contains(c0661i);
    }

    void m4666a() {
        if (!this.f2664n && !this.f2662l && !this.f2660j) {
            this.f2666p.m4694a();
            Future future = this.f2668r;
            if (future != null) {
                future.cancel(true);
            }
            this.f2660j = true;
            this.f2655e.m4639a(this, this.f2656f);
        }
    }

    public void m4667a(C0672u c0672u) {
        this.f2666p = c0672u;
        this.f2668r = this.f2657g.submit(c0672u);
    }

    public void m4668a(C0670y<?> c0670y) {
        this.f2661k = c0670y;
        f2652b.obtainMessage(1, this).sendToTarget();
    }

    public void m4669a(C0661i c0661i) {
        C0879h.m5307a();
        if (this.f2662l) {
            c0661i.m4657a(this.f2667q);
        } else if (this.f2664n) {
            c0661i.m4658a(this.f2663m);
        } else {
            this.f2653c.add(c0661i);
        }
    }

    public void m4670a(Exception exception) {
        this.f2663m = exception;
        f2652b.obtainMessage(2, this).sendToTarget();
    }

    public void m4671b(C0672u c0672u) {
        this.f2668r = this.f2658h.submit(c0672u);
    }

    public void m4672b(C0661i c0661i) {
        C0879h.m5307a();
        if (this.f2662l || this.f2664n) {
            m4664c(c0661i);
            return;
        }
        this.f2653c.remove(c0661i);
        if (this.f2653c.isEmpty()) {
            m4666a();
        }
    }
}
