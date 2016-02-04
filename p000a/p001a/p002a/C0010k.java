package p000a.p001a.p002a;

import java.util.ArrayList;
import java.util.List;

/* renamed from: a.a.a.k */
final class C0010k {
    private static final List<C0010k> f47d;
    Object f48a;
    C0015p f49b;
    C0010k f50c;

    static {
        f47d = new ArrayList();
    }

    private C0010k(Object obj, C0015p c0015p) {
        this.f48a = obj;
        this.f49b = c0015p;
    }

    static C0010k m20a(C0015p c0015p, Object obj) {
        synchronized (f47d) {
            int size = f47d.size();
            if (size > 0) {
                C0010k c0010k = (C0010k) f47d.remove(size - 1);
                c0010k.f48a = obj;
                c0010k.f49b = c0015p;
                c0010k.f50c = null;
                return c0010k;
            }
            return new C0010k(obj, c0015p);
        }
    }

    static void m21a(C0010k c0010k) {
        c0010k.f48a = null;
        c0010k.f49b = null;
        c0010k.f50c = null;
        synchronized (f47d) {
            if (f47d.size() < 10000) {
                f47d.add(c0010k);
            }
        }
    }
}
