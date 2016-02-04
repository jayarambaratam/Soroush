package com.cocosw.bottomsheet;

import java.util.Comparator;

/* renamed from: com.cocosw.bottomsheet.y */
class C1015y implements Comparator<C1016z> {
    final /* synthetic */ C1013w f3832a;

    C1015y(C1013w c1013w) {
        this.f3832a = c1013w;
    }

    public int m6139a(C1016z c1016z, C1016z c1016z2) {
        return c1016z.f3833a == c1016z2.f3833a ? 0 : c1016z.f3833a < c1016z2.f3833a ? -1 : 1;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m6139a((C1016z) obj, (C1016z) obj2);
    }
}
