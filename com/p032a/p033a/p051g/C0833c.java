package com.p032a.p033a.p051g;

import com.p032a.p033a.p042j.C0878g;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.a.a.g.c */
public class C0833c {
    private static final C0878g f2944a;
    private final Map<C0878g, C0737b<?, ?>> f2945b;

    static {
        f2944a = new C0878g();
    }

    public C0833c() {
        this.f2945b = new HashMap();
    }

    public <T, Z> C0737b<T, Z> m5117a(Class<T> cls, Class<Z> cls2) {
        C0737b<T, Z> c0737b;
        synchronized (f2944a) {
            f2944a.m5299a(cls, cls2);
            c0737b = (C0737b) this.f2945b.get(f2944a);
        }
        return c0737b == null ? C0834d.m5119e() : c0737b;
    }

    public <T, Z> void m5118a(Class<T> cls, Class<Z> cls2, C0737b<T, Z> c0737b) {
        this.f2945b.put(new C0878g(cls, cls2), c0737b);
    }
}
