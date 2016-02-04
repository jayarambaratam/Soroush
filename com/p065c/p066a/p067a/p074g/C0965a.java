package com.p065c.p066a.p067a.p074g;

import com.p065c.p066a.p067a.C0954d;
import java.util.Comparator;

/* renamed from: com.c.a.a.g.a */
public class C0965a implements Comparator<C0954d> {
    final Comparator<C0954d> f3664a;

    public C0965a(Comparator<C0954d> comparator) {
        this.f3664a = comparator;
    }

    public int m5943a(C0954d c0954d, C0954d c0954d2) {
        return c0954d.m5896g() < c0954d2.m5896g() ? -1 : c0954d.m5896g() > c0954d2.m5896g() ? 1 : this.f3664a.compare(c0954d, c0954d2);
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5943a((C0954d) obj, (C0954d) obj2);
    }
}
