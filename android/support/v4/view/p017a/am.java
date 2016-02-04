package android.support.v4.view.p017a;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.view.a.am */
public class am {
    private static final ap f1292a;
    private final Object f1293b;

    static {
        if (VERSION.SDK_INT >= 16) {
            f1292a = new aq();
        } else if (VERSION.SDK_INT >= 15) {
            f1292a = new ao();
        } else if (VERSION.SDK_INT >= 14) {
            f1292a = new an();
        } else {
            f1292a = new ar();
        }
    }

    public am(Object obj) {
        this.f1293b = obj;
    }

    public static am m1888a() {
        return new am(f1292a.m1897a());
    }

    public void m1889a(int i) {
        f1292a.m1900b(this.f1293b, i);
    }

    public void m1890a(boolean z) {
        f1292a.m1899a(this.f1293b, z);
    }

    public void m1891b(int i) {
        f1292a.m1898a(this.f1293b, i);
    }

    public void m1892c(int i) {
        f1292a.m1903e(this.f1293b, i);
    }

    public void m1893d(int i) {
        f1292a.m1901c(this.f1293b, i);
    }

    public void m1894e(int i) {
        f1292a.m1902d(this.f1293b, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        am amVar = (am) obj;
        return this.f1293b == null ? amVar.f1293b == null : this.f1293b.equals(amVar.f1293b);
    }

    public void m1895f(int i) {
        f1292a.m1904f(this.f1293b, i);
    }

    public void m1896g(int i) {
        f1292a.m1905g(this.f1293b, i);
    }

    public int hashCode() {
        return this.f1293b == null ? 0 : this.f1293b.hashCode();
    }
}
