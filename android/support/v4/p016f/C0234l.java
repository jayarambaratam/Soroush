package android.support.v4.p016f;

import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: android.support.v4.f.l */
final class C0234l implements Iterator<Entry<K, V>>, Entry<K, V> {
    int f1154a;
    int f1155b;
    boolean f1156c;
    final /* synthetic */ C0224h f1157d;

    C0234l(C0224h c0224h) {
        this.f1157d = c0224h;
        this.f1156c = false;
        this.f1154a = c0224h.m1676a() - 1;
        this.f1155b = -1;
    }

    public Entry<K, V> m1718a() {
        this.f1155b++;
        this.f1156c = true;
        return this;
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (!this.f1156c) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else if (!(obj instanceof Entry)) {
            return false;
        } else {
            Entry entry = (Entry) obj;
            if (!(C0226c.m1702a(entry.getKey(), this.f1157d.m1678a(this.f1155b, 0)) && C0226c.m1702a(entry.getValue(), this.f1157d.m1678a(this.f1155b, 1)))) {
                z = false;
            }
            return z;
        }
    }

    public K getKey() {
        if (this.f1156c) {
            return this.f1157d.m1678a(this.f1155b, 0);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public V getValue() {
        if (this.f1156c) {
            return this.f1157d.m1678a(this.f1155b, 1);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public boolean hasNext() {
        return this.f1155b < this.f1154a;
    }

    public final int hashCode() {
        int i = 0;
        if (this.f1156c) {
            Object a = this.f1157d.m1678a(this.f1155b, 0);
            Object a2 = this.f1157d.m1678a(this.f1155b, 1);
            int hashCode = a == null ? 0 : a.hashCode();
            if (a2 != null) {
                i = a2.hashCode();
            }
            return i ^ hashCode;
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public /* synthetic */ Object next() {
        return m1718a();
    }

    public void remove() {
        if (this.f1156c) {
            this.f1157d.m1680a(this.f1155b);
            this.f1155b--;
            this.f1154a--;
            this.f1156c = false;
            return;
        }
        throw new IllegalStateException();
    }

    public V setValue(V v) {
        if (this.f1156c) {
            return this.f1157d.m1679a(this.f1155b, (Object) v);
        }
        throw new IllegalStateException("This container does not support retaining Map.Entry objects");
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }
}
