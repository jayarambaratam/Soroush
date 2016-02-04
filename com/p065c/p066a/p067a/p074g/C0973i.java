package com.p065c.p066a.p067a.p074g;

import com.p065c.p066a.p067a.C0954d;
import java.util.Comparator;

/* renamed from: com.c.a.a.g.i */
class C0973i implements Comparator<C0954d> {
    final /* synthetic */ C0972h f3682a;

    C0973i(C0972h c0972h) {
        this.f3682a = c0972h;
    }

    public int m5987a(C0954d c0954d, C0954d c0954d2) {
        int a = C0972h.m5978b(c0954d.m5892c(), c0954d2.m5892c());
        if (a != 0) {
            return a;
        }
        a = -C0972h.m5979b(c0954d.m5894e(), c0954d2.m5894e());
        return a == 0 ? -C0972h.m5979b(c0954d.m5886a().longValue(), c0954d2.m5886a().longValue()) : a;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5987a((C0954d) obj, (C0954d) obj2);
    }
}
