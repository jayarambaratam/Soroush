package com.p065c.p066a.p067a.p074g;

import com.p065c.p066a.p067a.C0954d;
import java.util.Collection;
import java.util.Comparator;

/* renamed from: com.c.a.a.g.d */
public abstract class C0968d implements C0967c {
    C0967c f3667a;
    C0967c f3668b;
    final Comparator<C0954d> f3669c;
    final Comparator<C0954d> f3670d;

    public C0968d(int i, Comparator<C0954d> comparator, Comparator<C0954d> comparator2) {
        this.f3669c = comparator;
        this.f3670d = comparator2;
        this.f3667a = m5956a(C0969e.S0, i, (Comparator) comparator);
        this.f3668b = m5956a(C0969e.S1, i, (Comparator) comparator);
    }

    public int m5952a() {
        return this.f3667a.m5946a() + this.f3668b.m5946a();
    }

    protected C0954d m5953a(C0969e c0969e, Collection<String> collection) {
        return c0969e == C0969e.S0 ? this.f3667a.m5947a((Collection) collection) : this.f3668b.m5947a((Collection) collection);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.p065c.p066a.p067a.C0954d m5954a(java.util.Collection<java.lang.String> r5) {
        /*
        r4 = this;
    L_0x0000:
        r0 = r4.f3667a;
        r1 = r0.m5947a(r5);
        if (r1 == 0) goto L_0x001b;
    L_0x0008:
        r0 = r4.m5960c(r1);
        r2 = com.p065c.p066a.p067a.p074g.C0969e.S0;
        if (r0 == r2) goto L_0x001b;
    L_0x0010:
        r0 = r4.f3668b;
        r0.m5949a(r1);
        r0 = r4.f3667a;
        r0.m5951b(r1);
        goto L_0x0000;
    L_0x001b:
        r0 = r4.f3668b;
        r0 = r0.m5947a(r5);
        if (r0 == 0) goto L_0x0036;
    L_0x0023:
        r2 = r4.m5960c(r0);
        r3 = com.p065c.p066a.p067a.p074g.C0969e.S1;
        if (r2 == r3) goto L_0x0036;
    L_0x002b:
        r1 = r4.f3667a;
        r1.m5949a(r0);
        r1 = r4.f3668b;
        r1.m5951b(r0);
        goto L_0x0000;
    L_0x0036:
        if (r1 != 0) goto L_0x0039;
    L_0x0038:
        return r0;
    L_0x0039:
        if (r0 != 0) goto L_0x003d;
    L_0x003b:
        r0 = r1;
        goto L_0x0038;
    L_0x003d:
        r2 = r4.f3670d;
        r2 = r2.compare(r1, r0);
        r3 = -1;
        if (r2 != r3) goto L_0x0038;
    L_0x0046:
        r0 = r1;
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.a.g.d.a(java.util.Collection):com.c.a.a.d");
    }

    public C0966b m5955a(C0969e c0969e, long j, Collection<String> collection) {
        return c0969e == C0969e.S0 ? this.f3667a.m5948a(j, collection) : this.f3668b.m5948a(j, collection);
    }

    protected abstract C0967c m5956a(C0969e c0969e, int i, Comparator<C0954d> comparator);

    public boolean m5957a(C0954d c0954d) {
        return m5960c(c0954d) == C0969e.S0 ? this.f3667a.m5949a(c0954d) : this.f3668b.m5949a(c0954d);
    }

    public C0966b m5958b(C0969e c0969e, Collection<String> collection) {
        return c0969e == C0969e.S0 ? this.f3667a.m5950b((Collection) collection) : this.f3668b.m5950b((Collection) collection);
    }

    public boolean m5959b(C0954d c0954d) {
        return this.f3668b.m5951b(c0954d) || this.f3667a.m5951b(c0954d);
    }

    protected abstract C0969e m5960c(C0954d c0954d);
}
