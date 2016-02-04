package org.p253a.p254a.p255a;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: org.a.a.a.e */
public class C2638e<K, V> extends LinkedHashMap<K, V> implements C2634a<K, V> {
    private int f8359a;
    private final AtomicLong f8360b;
    private final AtomicLong f8361c;

    public C2638e(int i) {
        int i2 = 50;
        if (i < 50) {
            i2 = i;
        }
        super(i2, 0.75f, true);
        this.f8360b = new AtomicLong();
        this.f8361c = new AtomicLong();
        if (i == 0) {
            throw new IllegalArgumentException("Max cache size cannot be 0.");
        }
        this.f8359a = i;
    }

    public final void m11063a(int i) {
        this.f8359a = i;
    }

    public final void clear() {
        synchronized (this) {
            super.clear();
        }
        this.f8360b.set(0);
        this.f8361c.set(0);
    }

    public final synchronized boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    public final synchronized boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    public final synchronized Set<Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    public final V get(Object obj) {
        synchronized (this) {
            V v = super.get(obj);
        }
        if (v == null) {
            this.f8361c.incrementAndGet();
            return null;
        }
        this.f8360b.incrementAndGet();
        return v;
    }

    public final synchronized boolean isEmpty() {
        return super.isEmpty();
    }

    public final synchronized Set<K> keySet() {
        return super.keySet();
    }

    public final synchronized V put(K k, V v) {
        return super.put(k, v);
    }

    public final synchronized void putAll(Map<? extends K, ? extends V> map) {
        super.putAll(map);
    }

    public final synchronized V remove(Object obj) {
        return super.remove(obj);
    }

    protected final boolean removeEldestEntry(Entry<K, V> entry) {
        return size() > this.f8359a;
    }

    public final synchronized int size() {
        return super.size();
    }

    public final synchronized Collection<V> values() {
        return super.values();
    }
}
