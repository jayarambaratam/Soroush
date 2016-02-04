package com.p065c.p066a.p067a;

import android.content.Context;
import com.p065c.p066a.p067a.p069b.C0945a;
import com.p065c.p066a.p067a.p070c.C0949a;
import com.p065c.p066a.p067a.p071d.C0951a;
import com.p065c.p066a.p067a.p071d.C0952b;
import com.p065c.p066a.p067a.p072e.C0956b;
import com.p065c.p066a.p067a.p073f.C0958b;
import com.p065c.p066a.p067a.p073f.C0960a;
import com.p065c.p066a.p067a.p073f.C0961c;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: com.c.a.a.e */
public class C0959e implements C0958b {
    private final long f3645a;
    private boolean f3646b;
    private final Context f3647c;
    private final C0961c f3648d;
    private final C0949a f3649e;
    private final C0939i f3650f;
    private final C0939i f3651g;
    private final C0948b f3652h;
    private final C0951a f3653i;
    private final Object f3654j;
    private final ConcurrentHashMap<Long, CountDownLatch> f3655k;
    private final ConcurrentHashMap<Long, CountDownLatch> f3656l;
    private final ScheduledExecutorService f3657m;
    private final Object f3658n;
    private final Runnable f3659o;
    private final C0952b f3660p;

    public C0959e(Context context, C0945a c0945a) {
        this.f3654j = new Object();
        this.f3658n = new Object();
        this.f3659o = new C0964f(this);
        this.f3660p = new C0976g(this);
        if (c0945a.m5853h() != null) {
            C0956b.m5903a(c0945a.m5853h());
        }
        this.f3647c = context.getApplicationContext();
        this.f3646b = true;
        this.f3652h = new C0948b();
        this.f3645a = System.nanoTime();
        this.f3650f = c0945a.m5847b().m6032a(context, Long.valueOf(this.f3645a), c0945a.m5846a());
        this.f3651g = c0945a.m5847b().m6033b(context, Long.valueOf(this.f3645a), c0945a.m5846a());
        this.f3655k = new ConcurrentHashMap();
        this.f3656l = new ConcurrentHashMap();
        this.f3648d = c0945a.m5850e();
        this.f3649e = c0945a.m5848c();
        if (this.f3648d instanceof C0960a) {
            ((C0960a) this.f3648d).m5938a(this);
        }
        this.f3653i = new C0951a(c0945a, this.f3660p);
        this.f3657m = Executors.newSingleThreadScheduledExecutor();
        m5936a();
    }

    private long m5915a(Boolean bool) {
        if (bool == null) {
            bool = Boolean.valueOf(this.f3648d instanceof C0960a ? m5929c() : true);
        }
        synchronized (this.f3651g) {
            Long a = this.f3651g.m5813a(bool.booleanValue());
        }
        if (a == null || a.longValue() > System.nanoTime()) {
            Long a2;
            synchronized (this.f3650f) {
                a2 = this.f3650f.m5813a(bool.booleanValue());
            }
            if (a2 == null || (a != null && a2.longValue() >= a.longValue())) {
                a2 = a;
            }
            if (a2 == null) {
                return Long.MAX_VALUE;
            }
            if (a2.longValue() < System.nanoTime()) {
                m5922b();
                return 0;
            }
            long ceil = (long) Math.ceil(((double) (a2.longValue() - System.nanoTime())) / 1000000.0d);
            m5916a(ceil);
            return ceil;
        }
        m5922b();
        return 0;
    }

    private void m5916a(long j) {
        this.f3657m.schedule(this.f3659o, j, TimeUnit.MILLISECONDS);
    }

    private void m5917a(C0954d c0954d) {
        C0956b.m5904a("re-adding job %s", c0954d.m5886a());
        if (c0954d.m5897h().m5828a()) {
            synchronized (this.f3650f) {
                this.f3650f.m5814b(c0954d);
            }
        } else {
            synchronized (this.f3651g) {
                this.f3651g.m5814b(c0954d);
            }
        }
        if (c0954d.m5898i() != null) {
            this.f3652h.m5863b(c0954d.m5898i());
        }
    }

    private void m5920a(ConcurrentHashMap<Long, CountDownLatch> concurrentHashMap, long j) {
        concurrentHashMap.put(Long.valueOf(j), new CountDownLatch(1));
    }

    private int m5921b(boolean z) {
        int a;
        synchronized (this.f3651g) {
            a = 0 + this.f3651g.m5811a(z, this.f3652h.m5861a());
        }
        synchronized (this.f3650f) {
            a += this.f3650f.m5811a(z, this.f3652h.m5861a());
        }
        return a;
    }

    private void m5922b() {
        synchronized (this.f3654j) {
            this.f3654j.notifyAll();
        }
        this.f3653i.m5880a();
    }

    private void m5923b(C0954d c0954d) {
        if (c0954d.m5897h().m5828a()) {
            synchronized (this.f3650f) {
                this.f3650f.m5816c(c0954d);
            }
        } else {
            synchronized (this.f3651g) {
                this.f3651g.m5816c(c0954d);
            }
        }
        if (c0954d.m5898i() != null) {
            this.f3652h.m5863b(c0954d.m5898i());
        }
    }

    private void m5925b(ConcurrentHashMap<Long, CountDownLatch> concurrentHashMap, long j) {
        CountDownLatch countDownLatch = (CountDownLatch) concurrentHashMap.get(Long.valueOf(j));
        if (countDownLatch != null) {
            try {
                countDownLatch.await();
            } catch (Throwable e) {
                C0956b.m5905a(e, "could not wait for onAdded lock", new Object[0]);
            }
        }
    }

    private void m5928c(ConcurrentHashMap<Long, CountDownLatch> concurrentHashMap, long j) {
        CountDownLatch countDownLatch = (CountDownLatch) concurrentHashMap.get(Long.valueOf(j));
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        concurrentHashMap.remove(Long.valueOf(j));
    }

    private boolean m5929c() {
        return this.f3648d == null || this.f3648d.m5939a(this.f3647c);
    }

    private C0954d m5930d() {
        C0954d c0954d;
        boolean c = m5929c();
        synchronized (this.f3658n) {
            Object obj;
            Collection a = this.f3652h.m5861a();
            synchronized (this.f3651g) {
                C0954d b = this.f3651g.m5815b(c, a);
            }
            if (b == null) {
                synchronized (this.f3650f) {
                    b = this.f3650f.m5815b(c, a);
                }
                c0954d = b;
                obj = 1;
            } else {
                c0954d = b;
                obj = null;
            }
            if (c0954d == null) {
                c0954d = null;
            } else {
                if (!(obj == null || this.f3649e == null)) {
                    this.f3649e.m5864a(c0954d.m5897h());
                }
                if (c0954d.m5898i() != null) {
                    this.f3652h.m5862a(c0954d.m5898i());
                }
                if (obj != null) {
                    m5925b(this.f3655k, c0954d.m5886a().longValue());
                } else {
                    m5925b(this.f3656l, c0954d.m5886a().longValue());
                }
            }
        }
        return c0954d;
    }

    @Deprecated
    public long m5934a(int i, long j, C0944a c0944a) {
        long nanoTime;
        long a;
        if (j > 0) {
            nanoTime = (1000000 * j) + System.nanoTime();
        } else {
            nanoTime = Long.MIN_VALUE;
        }
        C0954d c0954d = new C0954d(i, c0944a, nanoTime, Long.MIN_VALUE);
        if (c0944a.m5828a()) {
            synchronized (this.f3650f) {
                a = this.f3650f.m5812a(c0954d);
                m5920a(this.f3655k, a);
            }
        } else {
            synchronized (this.f3651g) {
                a = this.f3651g.m5812a(c0954d);
                m5920a(this.f3656l, a);
            }
        }
        if (C0956b.m5906a()) {
            C0956b.m5904a("added job id: %d class: %s priority: %d delay: %d group : %s persistent: %s requires network: %s", Long.valueOf(a), c0944a.getClass().getSimpleName(), Integer.valueOf(i), Long.valueOf(j), c0944a.m5835f(), Boolean.valueOf(c0944a.m5828a()), Boolean.valueOf(c0944a.m5834e()));
        }
        if (this.f3649e != null) {
            this.f3649e.m5864a(c0944a);
        }
        c0954d.m5897h().m5831b();
        if (c0944a.m5828a()) {
            synchronized (this.f3650f) {
                m5928c(this.f3655k, a);
            }
        } else {
            synchronized (this.f3651g) {
                m5928c(this.f3656l, a);
            }
        }
        m5922b();
        return a;
    }

    public long m5935a(C0950c c0950c) {
        return m5934a(c0950c.m5865h(), c0950c.m5866i(), c0950c);
    }

    public void m5936a() {
        if (!this.f3646b) {
            this.f3646b = true;
            m5922b();
        }
    }

    public void m5937a(boolean z) {
        m5915a(Boolean.valueOf(z));
    }
}
