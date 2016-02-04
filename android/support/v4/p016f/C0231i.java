package android.support.v4.p016f;

import java.util.Iterator;

/* renamed from: android.support.v4.f.i */
final class C0231i<T> implements Iterator<T> {
    final int f1147a;
    int f1148b;
    int f1149c;
    boolean f1150d;
    final /* synthetic */ C0224h f1151e;

    C0231i(C0224h c0224h, int i) {
        this.f1151e = c0224h;
        this.f1150d = false;
        this.f1147a = i;
        this.f1148b = c0224h.m1676a();
    }

    public boolean hasNext() {
        return this.f1149c < this.f1148b;
    }

    public T next() {
        T a = this.f1151e.m1678a(this.f1149c, this.f1147a);
        this.f1149c++;
        this.f1150d = true;
        return a;
    }

    public void remove() {
        if (this.f1150d) {
            this.f1149c--;
            this.f1148b--;
            this.f1150d = false;
            this.f1151e.m1680a(this.f1149c);
            return;
        }
        throw new IllegalStateException();
    }
}
