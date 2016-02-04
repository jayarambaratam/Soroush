package com.p065c.p066a.p067a.p074g;

import com.p065c.p066a.p067a.C0954d;
import java.util.Comparator;

/* renamed from: com.c.a.a.g.j */
public class C0974j implements Comparator<C0954d> {
    final Comparator<C0954d> f3683a;

    public C0974j(Comparator<C0954d> comparator) {
        this.f3683a = comparator;
    }

    public int m5988a(C0954d c0954d, C0954d c0954d2) {
        int i = 0;
        long nanoTime = System.nanoTime();
        int i2 = c0954d.m5896g() <= nanoTime ? 1 : 0;
        if (c0954d2.m5896g() <= nanoTime) {
            i = 1;
        }
        if (i2 == 0) {
            return i != 0 ? i2 != 0 ? this.f3683a.compare(c0954d, c0954d2) : 1 : c0954d.m5896g() < c0954d2.m5896g() ? -1 : c0954d.m5896g() <= c0954d2.m5896g() ? this.f3683a.compare(c0954d, c0954d2) : 1;
        } else {
            return i != 0 ? this.f3683a.compare(c0954d, c0954d2) : -1;
        }
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5988a((C0954d) obj, (C0954d) obj2);
    }
}
