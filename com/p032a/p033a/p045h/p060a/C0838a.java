package com.p032a.p033a.p045h.p060a;

import android.graphics.drawable.Drawable;
import org.apache.http.myHttp.HttpStatus;

/* renamed from: com.a.a.h.a.a */
public class C0838a<T extends Drawable> implements C0837f<T> {
    private final C0847k<T> f2951a;
    private final int f2952b;
    private C0842c<T> f2953c;
    private C0842c<T> f2954d;

    public C0838a() {
        this(HttpStatus.SC_MULTIPLE_CHOICES);
    }

    public C0838a(int i) {
        this(new C0847k(new C0840b(i)), i);
    }

    C0838a(C0847k<T> c0847k, int i) {
        this.f2951a = c0847k;
        this.f2952b = i;
    }

    private C0841d<T> m5131a() {
        if (this.f2953c == null) {
            this.f2953c = new C0842c(this.f2951a.m5147a(false, true), this.f2952b);
        }
        return this.f2953c;
    }

    private C0841d<T> m5132b() {
        if (this.f2954d == null) {
            this.f2954d = new C0842c(this.f2951a.m5147a(false, false), this.f2952b);
        }
        return this.f2954d;
    }

    public C0841d<T> m5133a(boolean z, boolean z2) {
        return z ? C0844g.m5142b() : z2 ? m5131a() : m5132b();
    }
}
