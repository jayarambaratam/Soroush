package com.p065c.p066a.p067a.p074g;

import com.p065c.p066a.p067a.C0954d;
import java.util.Collection;
import java.util.Comparator;

/* renamed from: com.c.a.a.g.f */
public class C0970f extends C0968d {
    public C0970f(int i, Comparator<C0954d> comparator) {
        super(i, comparator, new C0974j(comparator));
    }

    public C0954d m5961a(boolean z, Collection<String> collection) {
        return z ? super.m5954a((Collection) collection) : super.m5953a(C0969e.S1, collection);
    }

    public C0966b m5962a(long j, Collection<String> collection) {
        throw new UnsupportedOperationException("cannot call network aware priority queue count w/o providing network status");
    }

    protected C0967c m5963a(C0969e c0969e, int i, Comparator<C0954d> comparator) {
        return new C0975k(i, comparator);
    }

    public C0966b m5964b(Collection<String> collection) {
        throw new UnsupportedOperationException("cannot call network aware priority queue count w/o providing network status");
    }

    public C0966b m5965b(boolean z, Collection<String> collection) {
        long nanoTime = System.nanoTime();
        return z ? super.m5955a(C0969e.S0, nanoTime, (Collection) collection).m5945a(super.m5955a(C0969e.S1, nanoTime, (Collection) collection)) : super.m5955a(C0969e.S1, nanoTime, (Collection) collection);
    }

    protected C0969e m5966c(C0954d c0954d) {
        return c0954d.m5891b() ? C0969e.S0 : C0969e.S1;
    }
}
