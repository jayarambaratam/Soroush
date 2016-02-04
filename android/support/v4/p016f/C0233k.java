package android.support.v4.p016f;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* renamed from: android.support.v4.f.k */
final class C0233k implements Set<K> {
    final /* synthetic */ C0224h f1153a;

    C0233k(C0224h c0224h) {
        this.f1153a = c0224h;
    }

    public boolean add(K k) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends K> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f1153a.m1686c();
    }

    public boolean contains(Object obj) {
        return this.f1153a.m1677a(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        return C0224h.m1672a(this.f1153a.m1684b(), (Collection) collection);
    }

    public boolean equals(Object obj) {
        return C0224h.m1673a((Set) this, obj);
    }

    public int hashCode() {
        int i = 0;
        for (int a = this.f1153a.m1676a() - 1; a >= 0; a--) {
            Object a2 = this.f1153a.m1678a(a, 0);
            i += a2 == null ? 0 : a2.hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.f1153a.m1676a() == 0;
    }

    public Iterator<K> iterator() {
        return new C0231i(this.f1153a, 0);
    }

    public boolean remove(Object obj) {
        int a = this.f1153a.m1677a(obj);
        if (a < 0) {
            return false;
        }
        this.f1153a.m1680a(a);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        return C0224h.m1674b(this.f1153a.m1684b(), collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return C0224h.m1675c(this.f1153a.m1684b(), collection);
    }

    public int size() {
        return this.f1153a.m1676a();
    }

    public Object[] toArray() {
        return this.f1153a.m1685b(0);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f1153a.m1682a((Object[]) tArr, 0);
    }
}
