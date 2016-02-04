package com.p032a.p033a.p037d.p039b.p040a;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.a.a.d.b.a.h */
class C0608h<K, V> {
    C0608h<K, V> f2545a;
    C0608h<K, V> f2546b;
    private final K f2547c;
    private List<V> f2548d;

    public C0608h() {
        this(null);
    }

    public C0608h(K k) {
        this.f2546b = this;
        this.f2545a = this;
        this.f2547c = k;
    }

    public V m4526a() {
        int b = m4528b();
        return b > 0 ? this.f2548d.remove(b - 1) : null;
    }

    public void m4527a(V v) {
        if (this.f2548d == null) {
            this.f2548d = new ArrayList();
        }
        this.f2548d.add(v);
    }

    public int m4528b() {
        return this.f2548d != null ? this.f2548d.size() : 0;
    }
}
