package com.p065c.p066a.p067a.p071d;

import com.p065c.p066a.p067a.C0954d;
import com.p065c.p066a.p067a.p069b.C0945a;
import com.p065c.p066a.p067a.p072e.C0956b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.c.a.a.d.a */
public class C0951a {
    private int f3624a;
    private int f3625b;
    private int f3626c;
    private final ThreadGroup f3627d;
    private final C0952b f3628e;
    private final int f3629f;
    private final AtomicInteger f3630g;
    private final ConcurrentHashMap<String, C0954d> f3631h;

    public C0951a(C0945a c0945a, C0952b c0952b) {
        this.f3630g = new AtomicInteger(0);
        this.f3626c = c0945a.m5854i();
        this.f3624a = c0945a.m5851f();
        this.f3625b = c0945a.m5852g();
        this.f3629f = c0945a.m5849d();
        this.f3628e = c0952b;
        this.f3627d = new ThreadGroup("JobConsumers");
        this.f3631h = new ConcurrentHashMap();
    }

    private String m5868a(long j, boolean z) {
        return j + "_" + (z ? "t" : "f");
    }

    private void m5870a(C0954d c0954d) {
        this.f3631h.put(m5877c(c0954d), c0954d);
    }

    private boolean m5871a(boolean z) {
        boolean z2 = false;
        synchronized (this.f3627d) {
            int intValue = this.f3630g.intValue() - (z ? 1 : 0);
            if (intValue < this.f3625b || this.f3626c * intValue < this.f3628e.m5884b() + this.f3631h.size()) {
                z2 = true;
            }
            if (C0956b.m5906a()) {
                C0956b.m5904a("%s: load factor check. %s = (%d < %d)|| (%d * %d < %d + %d). consumer thread: %s", Thread.currentThread().getName(), Boolean.valueOf(z2), Integer.valueOf(intValue), Integer.valueOf(this.f3625b), Integer.valueOf(intValue), Integer.valueOf(this.f3626c), Integer.valueOf(this.f3628e.m5884b()), Integer.valueOf(this.f3631h.size()), Boolean.valueOf(z));
            }
        }
        return z2;
    }

    private boolean m5872a(boolean z, boolean z2) {
        boolean z3 = false;
        if (this.f3628e.m5883a()) {
            synchronized (this.f3627d) {
                if (m5871a(z) && m5879d()) {
                    if (z2) {
                        m5878c();
                    }
                    z3 = true;
                } else {
                    if (z) {
                        this.f3630g.decrementAndGet();
                    }
                }
            }
        } else if (z) {
            this.f3630g.decrementAndGet();
        }
        return z3;
    }

    private void m5874b(C0954d c0954d) {
        this.f3631h.remove(m5877c(c0954d));
    }

    private boolean m5875b() {
        return !m5872a(true, false);
    }

    private String m5877c(C0954d c0954d) {
        return m5868a(c0954d.m5886a().longValue(), c0954d.m5897h().m5828a());
    }

    private void m5878c() {
        C0956b.m5904a("adding another consumer", new Object[0]);
        synchronized (this.f3627d) {
            Thread thread = new Thread(this.f3627d, new C0953c(this.f3628e, this));
            this.f3630g.incrementAndGet();
            thread.start();
        }
    }

    private boolean m5879d() {
        boolean z;
        synchronized (this.f3627d) {
            z = this.f3630g.intValue() < this.f3624a;
        }
        return z;
    }

    public void m5880a() {
        m5872a(false, true);
    }
}
