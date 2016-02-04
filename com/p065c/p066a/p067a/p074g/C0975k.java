package com.p065c.p066a.p067a.p074g;

import com.p065c.p066a.p067a.C0954d;
import java.util.Collection;
import java.util.Comparator;

/* renamed from: com.c.a.a.g.k */
public class C0975k extends C0968d {
    public C0975k(int i, Comparator<C0954d> comparator) {
        super(i, comparator, new C0974j(comparator));
    }

    public C0966b m5989a(long j, Collection<String> collection) {
        return super.m5958b(C0969e.S0, collection).m5945a(super.m5955a(C0969e.S1, j, (Collection) collection));
    }

    protected C0967c m5990a(C0969e c0969e, int i, Comparator<C0954d> comparator) {
        return c0969e == C0969e.S0 ? new C0971g(comparator) : new C0971g(new C0965a(comparator));
    }

    public C0966b m5991b(Collection<String> collection) {
        throw new UnsupportedOperationException("cannot call time aware priority queue's count ready jobs w/o providing a time");
    }

    protected C0969e m5992c(C0954d c0954d) {
        return c0954d.m5896g() <= System.nanoTime() ? C0969e.S0 : C0969e.S1;
    }
}
