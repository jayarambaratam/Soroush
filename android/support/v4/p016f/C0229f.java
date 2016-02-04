package android.support.v4.p016f;

/* renamed from: android.support.v4.f.f */
public class C0229f<E> implements Cloneable {
    private static final Object f1142a;
    private boolean f1143b;
    private long[] f1144c;
    private Object[] f1145d;
    private int f1146e;

    static {
        f1142a = new Object();
    }

    public C0229f() {
        this(10);
    }

    public C0229f(int i) {
        this.f1143b = false;
        if (i == 0) {
            this.f1144c = C0226c.f1138b;
            this.f1145d = C0226c.f1139c;
        } else {
            int b = C0226c.m1703b(i);
            this.f1144c = new long[b];
            this.f1145d = new Object[b];
        }
        this.f1146e = 0;
    }

    private void m1707d() {
        int i = this.f1146e;
        long[] jArr = this.f1144c;
        Object[] objArr = this.f1145d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1142a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1143b = false;
        this.f1146e = i2;
    }

    public C0229f<E> m1708a() {
        try {
            C0229f<E> c0229f = (C0229f) super.clone();
            try {
                c0229f.f1144c = (long[]) this.f1144c.clone();
                c0229f.f1145d = (Object[]) this.f1145d.clone();
                return c0229f;
            } catch (CloneNotSupportedException e) {
                return c0229f;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public E m1709a(long j) {
        return m1710a(j, null);
    }

    public E m1710a(long j, E e) {
        int a = C0226c.m1701a(this.f1144c, this.f1146e, j);
        return (a < 0 || this.f1145d[a] == f1142a) ? e : this.f1145d[a];
    }

    public void m1711a(int i) {
        if (this.f1145d[i] != f1142a) {
            this.f1145d[i] = f1142a;
            this.f1143b = true;
        }
    }

    public int m1712b() {
        if (this.f1143b) {
            m1707d();
        }
        return this.f1146e;
    }

    public long m1713b(int i) {
        if (this.f1143b) {
            m1707d();
        }
        return this.f1144c[i];
    }

    public void m1714b(long j, E e) {
        int a = C0226c.m1701a(this.f1144c, this.f1146e, j);
        if (a >= 0) {
            this.f1145d[a] = e;
            return;
        }
        a ^= -1;
        if (a >= this.f1146e || this.f1145d[a] != f1142a) {
            if (this.f1143b && this.f1146e >= this.f1144c.length) {
                m1707d();
                a = C0226c.m1701a(this.f1144c, this.f1146e, j) ^ -1;
            }
            if (this.f1146e >= this.f1144c.length) {
                int b = C0226c.m1703b(this.f1146e + 1);
                Object obj = new long[b];
                Object obj2 = new Object[b];
                System.arraycopy(this.f1144c, 0, obj, 0, this.f1144c.length);
                System.arraycopy(this.f1145d, 0, obj2, 0, this.f1145d.length);
                this.f1144c = obj;
                this.f1145d = obj2;
            }
            if (this.f1146e - a != 0) {
                System.arraycopy(this.f1144c, a, this.f1144c, a + 1, this.f1146e - a);
                System.arraycopy(this.f1145d, a, this.f1145d, a + 1, this.f1146e - a);
            }
            this.f1144c[a] = j;
            this.f1145d[a] = e;
            this.f1146e++;
            return;
        }
        this.f1144c[a] = j;
        this.f1145d[a] = e;
    }

    public E m1715c(int i) {
        if (this.f1143b) {
            m1707d();
        }
        return this.f1145d[i];
    }

    public void m1716c() {
        int i = this.f1146e;
        Object[] objArr = this.f1145d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1146e = 0;
        this.f1143b = false;
    }

    public /* synthetic */ Object clone() {
        return m1708a();
    }

    public String toString() {
        if (m1712b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1146e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1146e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m1713b(i));
            stringBuilder.append('=');
            C0229f c = m1715c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
