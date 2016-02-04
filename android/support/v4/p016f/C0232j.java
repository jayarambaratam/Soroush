package android.support.v4.p016f;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: android.support.v4.f.j */
final class C0232j implements Set<Entry<K, V>> {
    final /* synthetic */ C0224h f1152a;

    C0232j(C0224h c0224h) {
        this.f1152a = c0224h;
    }

    public boolean m1717a(Entry<K, V> entry) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ boolean add(Object obj) {
        return m1717a((Entry) obj);
    }

    public boolean addAll(Collection<? extends Entry<K, V>> collection) {
        int a = this.f1152a.m1676a();
        for (Entry entry : collection) {
            this.f1152a.m1681a(entry.getKey(), entry.getValue());
        }
        return a != this.f1152a.m1676a();
    }

    public void clear() {
        this.f1152a.m1686c();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        int a = this.f1152a.m1677a(entry.getKey());
        return a >= 0 ? C0226c.m1702a(this.f1152a.m1678a(a, 1), entry.getValue()) : false;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        return C0224h.m1673a((Set) this, obj);
    }

    public int hashCode() {
        int a = this.f1152a.m1676a() - 1;
        int i = 0;
        while (a >= 0) {
            Object a2 = this.f1152a.m1678a(a, 0);
            Object a3 = this.f1152a.m1678a(a, 1);
            a--;
            i += (a3 == null ? 0 : a3.hashCode()) ^ (a2 == null ? 0 : a2.hashCode());
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f1152a.m1676a() == 0;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new C0234l(this.f1152a);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.f1152a.m1676a();
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <T> T[] toArray(T[] tArr) {
        throw new UnsupportedOperationException();
    }
}
