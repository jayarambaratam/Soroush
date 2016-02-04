package com.p032a.p033a.p037d.p039b.p040a;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.a.a.d.b.a.g */
class C0607g<K extends C0601n, V> {
    private final C0608h<K, V> f2543a;
    private final Map<K, C0608h<K, V>> f2544b;

    C0607g() {
        this.f2543a = new C0608h();
        this.f2544b = new HashMap();
    }

    private void m4518a(C0608h<K, V> c0608h) {
        C0607g.m4521d(c0608h);
        c0608h.f2546b = this.f2543a;
        c0608h.f2545a = this.f2543a.f2545a;
        C0607g.m4520c(c0608h);
    }

    private void m4519b(C0608h<K, V> c0608h) {
        C0607g.m4521d(c0608h);
        c0608h.f2546b = this.f2543a.f2546b;
        c0608h.f2545a = this.f2543a;
        C0607g.m4520c(c0608h);
    }

    private static <K, V> void m4520c(C0608h<K, V> c0608h) {
        c0608h.f2545a.f2546b = c0608h;
        c0608h.f2546b.f2545a = c0608h;
    }

    private static <K, V> void m4521d(C0608h<K, V> c0608h) {
        c0608h.f2546b.f2545a = c0608h.f2545a;
        c0608h.f2545a.f2546b = c0608h.f2546b;
    }

    public V m4522a() {
        for (C0608h c0608h = this.f2543a.f2546b; !c0608h.equals(this.f2543a); c0608h = c0608h.f2546b) {
            V a = c0608h.m4526a();
            if (a != null) {
                return a;
            }
            C0607g.m4521d(c0608h);
            this.f2544b.remove(c0608h.f2547c);
            ((C0601n) c0608h.f2547c).m4499a();
        }
        return null;
    }

    public V m4523a(K k) {
        C0608h c0608h = (C0608h) this.f2544b.get(k);
        if (c0608h == null) {
            c0608h = new C0608h(k);
            this.f2544b.put(k, c0608h);
        } else {
            k.m4499a();
        }
        m4518a(c0608h);
        return c0608h.m4526a();
    }

    public void m4524a(K k, V v) {
        C0608h c0608h = (C0608h) this.f2544b.get(k);
        if (c0608h == null) {
            c0608h = new C0608h(k);
            m4519b(c0608h);
            this.f2544b.put(k, c0608h);
        } else {
            k.m4499a();
        }
        c0608h.m4527a((Object) v);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        Object obj = null;
        for (C0608h c0608h = this.f2543a.f2545a; !c0608h.equals(this.f2543a); c0608h = c0608h.f2545a) {
            obj = 1;
            stringBuilder.append('{').append(c0608h.f2547c).append(':').append(c0608h.m4528b()).append("}, ");
        }
        if (obj != null) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        return stringBuilder.append(" )").toString();
    }
}
