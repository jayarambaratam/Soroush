package android.support.v4.p016f;

/* renamed from: android.support.v4.f.p */
public class C0238p<T> implements C0237o<T> {
    private final Object[] f1159a;
    private int f1160b;

    public C0238p(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f1159a = new Object[i];
    }

    private boolean m1721b(T t) {
        for (int i = 0; i < this.f1160b; i++) {
            if (this.f1159a[i] == t) {
                return true;
            }
        }
        return false;
    }

    public T m1722a() {
        if (this.f1160b <= 0) {
            return null;
        }
        int i = this.f1160b - 1;
        T t = this.f1159a[i];
        this.f1159a[i] = null;
        this.f1160b--;
        return t;
    }

    public boolean m1723a(T t) {
        if (m1721b(t)) {
            throw new IllegalStateException("Already in the pool!");
        } else if (this.f1160b >= this.f1159a.length) {
            return false;
        } else {
            this.f1159a[this.f1160b] = t;
            this.f1160b++;
            return true;
        }
    }
}
