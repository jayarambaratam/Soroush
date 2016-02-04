package org.p253a.p254a.p255a;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: org.a.a.a.b */
public class C2635b<K, V> implements Map<K, V>, C2634a<K, V> {
    private final C2638e<K, C2637d<V>> f8353a;
    private long f8354b;

    public C2635b(int i, long j) {
        this.f8353a = new C2638e(i);
        m11061a(j);
    }

    public V m11060a(K k, V v, long j) {
        C2637d c2637d = (C2637d) this.f8353a.put(k, new C2637d(v, j));
        return c2637d == null ? null : c2637d.f8357a;
    }

    public void m11061a(long j) {
        if (j <= 0) {
            throw new IllegalArgumentException();
        }
        this.f8354b = j;
    }

    public void clear() {
        this.f8353a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f8353a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f8353a.containsValue(obj);
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> hashSet = new HashSet();
        for (Entry entry : this.f8353a.entrySet()) {
            hashSet.add(new C2636c(entry.getKey(), ((C2637d) entry.getValue()).f8357a));
        }
        return hashSet;
    }

    public V get(Object obj) {
        C2637d c2637d = (C2637d) this.f8353a.get(obj);
        if (c2637d == null) {
            return null;
        }
        if (!c2637d.m11062a()) {
            return c2637d.f8357a;
        }
        remove(obj);
        return null;
    }

    public boolean isEmpty() {
        return this.f8353a.isEmpty();
    }

    public Set<K> keySet() {
        return this.f8353a.keySet();
    }

    public V put(K k, V v) {
        return m11060a(k, v, this.f8354b);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(Object obj) {
        C2637d c2637d = (C2637d) this.f8353a.remove(obj);
        return c2637d == null ? null : c2637d.f8357a;
    }

    public int size() {
        return this.f8353a.size();
    }

    public Collection<V> values() {
        Collection hashSet = new HashSet();
        for (C2637d c2637d : this.f8353a.values()) {
            hashSet.add(c2637d.f8357a);
        }
        return hashSet;
    }
}
