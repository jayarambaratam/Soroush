package com.p065c.p066a.p067a.p074g;

import com.p065c.p066a.p067a.C0939i;
import com.p065c.p066a.p067a.C0954d;
import java.util.Collection;
import java.util.Comparator;

/* renamed from: com.c.a.a.g.h */
public class C0972h implements C0939i {
    public final Comparator<C0954d> f3677a;
    private long f3678b;
    private C0970f f3679c;
    private final String f3680d;
    private final long f3681e;

    public C0972h(long j, String str) {
        this.f3678b = -2147483648L;
        this.f3677a = new C0973i(this);
        this.f3680d = str;
        this.f3681e = j;
        this.f3679c = new C0970f(5, this.f3677a);
    }

    private static int m5978b(int i, int i2) {
        return i > i2 ? -1 : i2 > i ? 1 : 0;
    }

    private static int m5979b(long j, long j2) {
        return j > j2 ? -1 : j2 > j ? 1 : 0;
    }

    public int m5980a() {
        return this.f3679c.m5952a();
    }

    public int m5981a(boolean z, Collection<String> collection) {
        return this.f3679c.m5965b(z, collection).m5944a();
    }

    public synchronized long m5982a(C0954d c0954d) {
        this.f3678b++;
        c0954d.m5888a(Long.valueOf(this.f3678b));
        this.f3679c.m5957a(c0954d);
        return c0954d.m5886a().longValue();
    }

    public Long m5983a(boolean z) {
        C0954d a = this.f3679c.m5961a(z, null);
        return a == null ? null : Long.valueOf(a.m5896g());
    }

    public long m5984b(C0954d c0954d) {
        m5986c(c0954d);
        c0954d.m5887a(Long.MIN_VALUE);
        this.f3679c.m5957a(c0954d);
        return c0954d.m5886a().longValue();
    }

    public C0954d m5985b(boolean z, Collection<String> collection) {
        C0954d a = this.f3679c.m5961a(z, (Collection) collection);
        if (a == null) {
            return a;
        }
        if (a.m5896g() > System.nanoTime()) {
            return null;
        }
        a.m5887a(this.f3681e);
        a.m5890b(a.m5893d() + 1);
        this.f3679c.m5959b(a);
        return a;
    }

    public void m5986c(C0954d c0954d) {
        this.f3679c.m5959b(c0954d);
    }
}
