package org.p253a.p254a.p255a;

/* renamed from: org.a.a.a.d */
class C2637d<V> {
    public final V f8357a;
    public final long f8358b;

    public C2637d(V v, long j) {
        this.f8357a = v;
        this.f8358b = System.currentTimeMillis() + j;
    }

    public boolean m11062a() {
        return System.currentTimeMillis() > this.f8358b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2637d)) {
            return false;
        }
        return this.f8357a.equals(((C2637d) obj).f8357a);
    }

    public int hashCode() {
        return this.f8357a.hashCode();
    }
}
