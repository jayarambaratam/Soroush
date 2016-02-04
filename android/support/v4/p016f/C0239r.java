package android.support.v4.p016f;

/* renamed from: android.support.v4.f.r */
public class C0239r<E> implements Cloneable {
    private static final Object f1161a;
    private boolean f1162b;
    private int[] f1163c;
    private Object[] f1164d;
    private int f1165e;

    static {
        f1161a = new Object();
    }

    public C0239r() {
        this(10);
    }

    public C0239r(int i) {
        this.f1162b = false;
        if (i == 0) {
            this.f1163c = C0226c.f1137a;
            this.f1164d = C0226c.f1139c;
        } else {
            int a = C0226c.m1699a(i);
            this.f1163c = new int[a];
            this.f1164d = new Object[a];
        }
        this.f1165e = 0;
    }

    private void m1724d() {
        int i = this.f1165e;
        int[] iArr = this.f1163c;
        Object[] objArr = this.f1164d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1161a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1162b = false;
        this.f1165e = i2;
    }

    public C0239r<E> m1725a() {
        try {
            C0239r<E> c0239r = (C0239r) super.clone();
            try {
                c0239r.f1163c = (int[]) this.f1163c.clone();
                c0239r.f1164d = (Object[]) this.f1164d.clone();
                return c0239r;
            } catch (CloneNotSupportedException e) {
                return c0239r;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1726a(int i) {
        return m1727a(i, null);
    }

    public E m1727a(int i, E e) {
        int a = C0226c.m1700a(this.f1163c, this.f1165e, i);
        return (a < 0 || this.f1164d[a] == f1161a) ? e : this.f1164d[a];
    }

    public int m1728b() {
        if (this.f1162b) {
            m1724d();
        }
        return this.f1165e;
    }

    public void m1729b(int i) {
        int a = C0226c.m1700a(this.f1163c, this.f1165e, i);
        if (a >= 0 && this.f1164d[a] != f1161a) {
            this.f1164d[a] = f1161a;
            this.f1162b = true;
        }
    }

    public void m1730b(int i, E e) {
        int a = C0226c.m1700a(this.f1163c, this.f1165e, i);
        if (a >= 0) {
            this.f1164d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f1165e || this.f1164d[a] != f1161a) {
            if (this.f1162b && this.f1165e >= this.f1163c.length) {
                m1724d();
                a = C0226c.m1700a(this.f1163c, this.f1165e, i) ^ -1;
            }
            if (this.f1165e >= this.f1163c.length) {
                int a2 = C0226c.m1699a(this.f1165e + 1);
                Object obj = new int[a2];
                Object obj2 = new Object[a2];
                System.arraycopy(this.f1163c, 0, obj, 0, this.f1163c.length);
                System.arraycopy(this.f1164d, 0, obj2, 0, this.f1164d.length);
                this.f1163c = obj;
                this.f1164d = obj2;
            }
            if (this.f1165e - a != 0) {
                System.arraycopy(this.f1163c, a, this.f1163c, a + 1, this.f1165e - a);
                System.arraycopy(this.f1164d, a, this.f1164d, a + 1, this.f1165e - a);
            }
            this.f1163c[a] = i;
            this.f1164d[a] = e;
            this.f1165e++;
            return;
        }
        this.f1163c[a] = i;
        this.f1164d[a] = e;
    }

    public void m1731c() {
        int i = this.f1165e;
        Object[] objArr = this.f1164d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1165e = 0;
        this.f1162b = false;
    }

    public void m1732c(int i) {
        m1729b(i);
    }

    public /* synthetic */ Object clone() {
        return m1725a();
    }

    public int m1733d(int i) {
        if (this.f1162b) {
            m1724d();
        }
        return this.f1163c[i];
    }

    public E m1734e(int i) {
        if (this.f1162b) {
            m1724d();
        }
        return this.f1164d[i];
    }

    public String toString() {
        if (m1728b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1165e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1165e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1733d(i));
            stringBuilder.append('=');
            C0239r e = m1734e(i);
            if (e != this) {
                stringBuilder.append(e);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
