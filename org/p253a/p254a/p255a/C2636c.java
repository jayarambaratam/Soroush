package org.p253a.p254a.p255a;

import java.util.Map.Entry;

/* renamed from: org.a.a.a.c */
class C2636c<K, V> implements Entry<K, V> {
    private final K f8355a;
    private V f8356b;

    public C2636c(K k, V v) {
        this.f8355a = k;
        this.f8356b = v;
    }

    public K getKey() {
        return this.f8355a;
    }

    public V getValue() {
        return this.f8356b;
    }

    public V setValue(V v) {
        V v2 = this.f8356b;
        this.f8356b = v;
        return v2;
    }
}
