package android.support.v4.p016f;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.f.a */
public class C0223a<K, V> extends C0222q<K, V> implements Map<K, V> {
    C0224h<K, V> f1132a;

    private C0224h<K, V> m1670b() {
        if (this.f1132a == null) {
            this.f1132a = new C0225b(this);
        }
        return this.f1132a;
    }

    public boolean m1671a(Collection<?> collection) {
        return C0224h.m1675c(this, collection);
    }

    public Set<Entry<K, V>> entrySet() {
        return m1670b().m1687d();
    }

    public Set<K> keySet() {
        return m1670b().m1688e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        m1665a(this.h + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return m1670b().m1689f();
    }
}
