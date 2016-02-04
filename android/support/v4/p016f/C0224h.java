package android.support.v4.p016f;

import android.support.v4.f.h$android.support.v4.f.j;
import android.support.v4.f.h$android.support.v4.f.k;
import android.support.v4.f.h$android.support.v4.f.m;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.f.h */
abstract class C0224h<K, V> {
    j f1133b;
    k f1134c;
    m f1135d;

    C0224h() {
    }

    public static <K, V> boolean m1672a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean m1673a(Set<T> set, Object obj) {
        boolean z = true;
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (!(set.size() == set2.size() && set.containsAll(set2))) {
                z = false;
            }
            return z;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }

    public static <K, V> boolean m1674b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    public static <K, V> boolean m1675c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int m1676a();

    protected abstract int m1677a(Object obj);

    protected abstract Object m1678a(int i, int i2);

    protected abstract V m1679a(int i, V v);

    protected abstract void m1680a(int i);

    protected abstract void m1681a(K k, V v);

    public <T> T[] m1682a(T[] tArr, int i) {
        int a = m1676a();
        T[] tArr2 = tArr.length < a ? (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a) : tArr;
        for (int i2 = 0; i2 < a; i2++) {
            tArr2[i2] = m1678a(i2, i);
        }
        if (tArr2.length > a) {
            tArr2[a] = null;
        }
        return tArr2;
    }

    protected abstract int m1683b(Object obj);

    protected abstract Map<K, V> m1684b();

    public Object[] m1685b(int i) {
        int a = m1676a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = m1678a(i2, i);
        }
        return objArr;
    }

    protected abstract void m1686c();

    public Set<Entry<K, V>> m1687d() {
        if (this.f1133b == null) {
            this.f1133b = new C0232j(this);
        }
        return this.f1133b;
    }

    public Set<K> m1688e() {
        if (this.f1134c == null) {
            this.f1134c = new C0233k(this);
        }
        return this.f1134c;
    }

    public Collection<V> m1689f() {
        if (this.f1135d == null) {
            this.f1135d = new C0235m(this);
        }
        return this.f1135d;
    }
}
