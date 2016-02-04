package com.p065c.p066a.p067a;

import android.content.Context;
import com.p065c.p066a.p067a.p068a.C0940a;
import com.p065c.p066a.p067a.p074g.C0972h;
import com.p065c.p066a.p067a.p075h.p076a.C0983g;
import com.p065c.p066a.p067a.p075h.p076a.C0986k;
import com.p065c.p066a.p067a.p075h.p076a.C0987j;

/* renamed from: com.c.a.a.h */
public class C0989h implements C0988k {
    C0986k f3724a;

    public C0989h() {
        this.f3724a = new C0987j();
    }

    public C0939i m6034a(Context context, Long l, String str) {
        return new C0940a(new C0983g(context, l.longValue(), str, this.f3724a));
    }

    public C0939i m6035b(Context context, Long l, String str) {
        return new C0940a(new C0972h(l.longValue(), str));
    }
}
