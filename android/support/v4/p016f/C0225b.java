package android.support.v4.p016f;

import java.util.Map;

/* renamed from: android.support.v4.f.b */
class C0225b extends C0224h<K, V> {
    final /* synthetic */ C0223a f1136a;

    C0225b(C0223a c0223a) {
        this.f1136a = c0223a;
    }

    protected int m1690a() {
        return this.f1136a.h;
    }

    protected int m1691a(Object obj) {
        return this.f1136a.m1662a(obj);
    }

    protected Object m1692a(int i, int i2) {
        return this.f1136a.g[(i << 1) + i2];
    }

    protected V m1693a(int i, V v) {
        return this.f1136a.m1664a(i, (Object) v);
    }

    protected void m1694a(int i) {
        this.f1136a.m1669d(i);
    }

    protected void m1695a(K k, V v) {
        this.f1136a.put(k, v);
    }

    protected int m1696b(Object obj) {
        return this.f1136a.m1666b(obj);
    }

    protected Map<K, V> m1697b() {
        return this.f1136a;
    }

    protected void m1698c() {
        this.f1136a.clear();
    }
}
