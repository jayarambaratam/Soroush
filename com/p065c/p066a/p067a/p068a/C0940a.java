package com.p065c.p066a.p067a.p068a;

import com.p065c.p066a.p067a.C0939i;
import com.p065c.p066a.p067a.C0954d;
import java.util.Collection;

/* renamed from: com.c.a.a.a.a */
public class C0940a implements C0939i {
    C0939i f3599a;
    private C0942c f3600b;

    public C0940a(C0939i c0939i) {
        this.f3599a = c0939i;
        this.f3600b = new C0942c();
    }

    public int m5817a() {
        if (this.f3600b.f3601a == null) {
            this.f3600b.f3601a = Integer.valueOf(this.f3599a.m5810a());
        }
        return this.f3600b.f3601a.intValue();
    }

    public int m5818a(boolean z, Collection<String> collection) {
        if (this.f3600b.f3601a != null && this.f3600b.f3601a.intValue() < 1) {
            return 0;
        }
        int a = this.f3599a.m5811a(z, collection);
        if (a != 0) {
            return a;
        }
        m5817a();
        return a;
    }

    public long m5819a(C0954d c0954d) {
        this.f3600b.m5824a();
        return this.f3599a.m5812a(c0954d);
    }

    public Long m5820a(boolean z) {
        if (this.f3600b.f3602b == null) {
            this.f3600b.f3602b = new C0943d(this.f3599a.m5813a(z), null);
        } else if (!this.f3600b.f3602b.m5826a(z)) {
            this.f3600b.f3602b.m5827a(z, this.f3599a.m5813a(z));
        }
        return this.f3600b.f3602b.f3603a;
    }

    public long m5821b(C0954d c0954d) {
        this.f3600b.m5824a();
        return this.f3599a.m5814b(c0954d);
    }

    public C0954d m5822b(boolean z, Collection<String> collection) {
        if (this.f3600b.f3601a != null && this.f3600b.f3601a.intValue() < 1) {
            return null;
        }
        C0954d b = this.f3599a.m5815b(z, collection);
        if (b == null) {
            m5817a();
            return b;
        } else if (this.f3600b.f3601a == null) {
            return b;
        } else {
            C0942c c0942c = this.f3600b;
            Integer num = c0942c.f3601a;
            c0942c.f3601a = Integer.valueOf(c0942c.f3601a.intValue() - 1);
            return b;
        }
    }

    public void m5823c(C0954d c0954d) {
        this.f3600b.m5824a();
        this.f3599a.m5816c(c0954d);
    }
}
