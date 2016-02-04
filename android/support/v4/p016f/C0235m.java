package android.support.v4.p016f;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: android.support.v4.f.m */
final class C0235m implements Collection<V> {
    final /* synthetic */ C0224h f1158a;

    C0235m(C0224h c0224h) {
        this.f1158a = c0224h;
    }

    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        this.f1158a.m1686c();
    }

    public boolean contains(Object obj) {
        return this.f1158a.m1683b(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return this.f1158a.m1676a() == 0;
    }

    public Iterator<V> iterator() {
        return new C0231i(this.f1158a, 1);
    }

    public boolean remove(Object obj) {
        int b = this.f1158a.m1683b(obj);
        if (b < 0) {
            return false;
        }
        this.f1158a.m1680a(b);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        int i = 0;
        int a = this.f1158a.m1676a();
        boolean z = false;
        while (i < a) {
            if (collection.contains(this.f1158a.m1678a(i, 1))) {
                this.f1158a.m1680a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        int i = 0;
        int a = this.f1158a.m1676a();
        boolean z = false;
        while (i < a) {
            if (!collection.contains(this.f1158a.m1678a(i, 1))) {
                this.f1158a.m1680a(i);
                i--;
                a--;
                z = true;
            }
            i++;
        }
        return z;
    }

    public int size() {
        return this.f1158a.m1676a();
    }

    public Object[] toArray() {
        return this.f1158a.m1685b(1);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f1158a.m1682a((Object[]) tArr, 1);
    }
}
