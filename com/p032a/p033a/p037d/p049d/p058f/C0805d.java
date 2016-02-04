package com.p032a.p033a.p037d.p049d.p058f;

import com.p032a.p033a.p042j.C0878g;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.a.a.d.d.f.d */
public class C0805d {
    private static final C0878g f2903a;
    private final Map<C0878g, C0802c<?, ?>> f2904b;

    static {
        f2903a = new C0878g();
    }

    public C0805d() {
        this.f2904b = new HashMap();
    }

    public <Z, R> C0802c<Z, R> m5039a(Class<Z> cls, Class<R> cls2) {
        if (cls.equals(cls2)) {
            return C0806e.m5041b();
        }
        synchronized (f2903a) {
            f2903a.m5299a(cls, cls2);
            C0802c<Z, R> c0802c = (C0802c) this.f2904b.get(f2903a);
        }
        if (c0802c != null) {
            return c0802c;
        }
        throw new IllegalArgumentException("No transcoder registered for " + cls + " and " + cls2);
    }

    public <Z, R> void m5040a(Class<Z> cls, Class<R> cls2, C0802c<Z, R> c0802c) {
        this.f2904b.put(new C0878g(cls, cls2), c0802c);
    }
}
