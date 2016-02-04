package android.support.v4.p016f;

import java.util.Map;

/* renamed from: android.support.v4.f.q */
public class C0222q<K, V> {
    static Object[] f1125b;
    static int f1126c;
    static Object[] f1127d;
    static int f1128e;
    int[] f1129f;
    Object[] f1130g;
    int f1131h;

    public C0222q() {
        this.f1129f = C0226c.f1137a;
        this.f1130g = C0226c.f1139c;
        this.f1131h = 0;
    }

    private static void m1659a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0223a.class) {
                if (f1128e < 10) {
                    objArr[0] = f1127d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1127d = objArr;
                    f1128e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0223a.class) {
                if (f1126c < 10) {
                    objArr[0] = f1125b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1125b = objArr;
                    f1126c++;
                }
            }
        }
    }

    private void m1660e(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0223a.class) {
                if (f1127d != null) {
                    objArr = f1127d;
                    this.f1130g = objArr;
                    f1127d = (Object[]) objArr[0];
                    this.f1129f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1128e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0223a.class) {
                if (f1125b != null) {
                    objArr = f1125b;
                    this.f1130g = objArr;
                    f1125b = (Object[]) objArr[0];
                    this.f1129f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1126c--;
                    return;
                }
            }
        }
        this.f1129f = new int[i];
        this.f1130g = new Object[(i << 1)];
    }

    int m1661a() {
        int i = this.f1131h;
        if (i == 0) {
            return -1;
        }
        int a = C0226c.m1700a(this.f1129f, i, 0);
        if (a < 0 || this.f1130g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f1129f[i2] == 0) {
            if (this.f1130g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f1129f[a] == 0) {
            if (this.f1130g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    public int m1662a(Object obj) {
        return obj == null ? m1661a() : m1663a(obj, obj.hashCode());
    }

    int m1663a(Object obj, int i) {
        int i2 = this.f1131h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0226c.m1700a(this.f1129f, i2, i);
        if (a < 0 || obj.equals(this.f1130g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f1129f[i3] == i) {
            if (obj.equals(this.f1130g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f1129f[a] == i) {
            if (obj.equals(this.f1130g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    public V m1664a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = this.f1130g[i2];
        this.f1130g[i2] = v;
        return v2;
    }

    public void m1665a(int i) {
        if (this.f1129f.length < i) {
            Object obj = this.f1129f;
            Object obj2 = this.f1130g;
            m1660e(i);
            if (this.f1131h > 0) {
                System.arraycopy(obj, 0, this.f1129f, 0, this.f1131h);
                System.arraycopy(obj2, 0, this.f1130g, 0, this.f1131h << 1);
            }
            C0222q.m1659a(obj, obj2, this.f1131h);
        }
    }

    int m1666b(Object obj) {
        int i = 1;
        int i2 = this.f1131h * 2;
        Object[] objArr = this.f1130g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public K m1667b(int i) {
        return this.f1130g[i << 1];
    }

    public V m1668c(int i) {
        return this.f1130g[(i << 1) + 1];
    }

    public void clear() {
        if (this.f1131h != 0) {
            C0222q.m1659a(this.f1129f, this.f1130g, this.f1131h);
            this.f1129f = C0226c.f1137a;
            this.f1130g = C0226c.f1139c;
            this.f1131h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return m1662a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m1666b(obj) >= 0;
    }

    public V m1669d(int i) {
        int i2 = 8;
        V v = this.f1130g[(i << 1) + 1];
        if (this.f1131h <= 1) {
            C0222q.m1659a(this.f1129f, this.f1130g, this.f1131h);
            this.f1129f = C0226c.f1137a;
            this.f1130g = C0226c.f1139c;
            this.f1131h = 0;
        } else if (this.f1129f.length <= 8 || this.f1131h >= this.f1129f.length / 3) {
            this.f1131h--;
            if (i < this.f1131h) {
                System.arraycopy(this.f1129f, i + 1, this.f1129f, i, this.f1131h - i);
                System.arraycopy(this.f1130g, (i + 1) << 1, this.f1130g, i << 1, (this.f1131h - i) << 1);
            }
            this.f1130g[this.f1131h << 1] = null;
            this.f1130g[(this.f1131h << 1) + 1] = null;
        } else {
            if (this.f1131h > 8) {
                i2 = this.f1131h + (this.f1131h >> 1);
            }
            Object obj = this.f1129f;
            Object obj2 = this.f1130g;
            m1660e(i2);
            this.f1131h--;
            if (i > 0) {
                System.arraycopy(obj, 0, this.f1129f, 0, i);
                System.arraycopy(obj2, 0, this.f1130g, 0, i << 1);
            }
            if (i < this.f1131h) {
                System.arraycopy(obj, i + 1, this.f1129f, i, this.f1131h - i);
                System.arraycopy(obj2, (i + 1) << 1, this.f1130g, i << 1, (this.f1131h - i) << 1);
            }
        }
        return v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f1131h) {
            try {
                Object b = m1667b(i);
                Object c = m1668c(i);
                Object obj2 = map.get(b);
                if (c == null) {
                    if (obj2 != null || !map.containsKey(b)) {
                        return false;
                    }
                } else if (!c.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public V get(Object obj) {
        int a = m1662a(obj);
        return a >= 0 ? this.f1130g[(a << 1) + 1] : null;
    }

    public int hashCode() {
        int[] iArr = this.f1129f;
        Object[] objArr = this.f1130g;
        int i = this.f1131h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.f1131h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        int i2 = 8;
        if (k == null) {
            a = m1661a();
            i = 0;
        } else {
            i = k.hashCode();
            a = m1663a((Object) k, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            V v2 = this.f1130g[i3];
            this.f1130g[i3] = v;
            return v2;
        }
        a ^= -1;
        if (this.f1131h >= this.f1129f.length) {
            if (this.f1131h >= 8) {
                i2 = this.f1131h + (this.f1131h >> 1);
            } else if (this.f1131h < 4) {
                i2 = 4;
            }
            Object obj = this.f1129f;
            Object obj2 = this.f1130g;
            m1660e(i2);
            if (this.f1129f.length > 0) {
                System.arraycopy(obj, 0, this.f1129f, 0, obj.length);
                System.arraycopy(obj2, 0, this.f1130g, 0, obj2.length);
            }
            C0222q.m1659a(obj, obj2, this.f1131h);
        }
        if (a < this.f1131h) {
            System.arraycopy(this.f1129f, a, this.f1129f, a + 1, this.f1131h - a);
            System.arraycopy(this.f1130g, a << 1, this.f1130g, (a + 1) << 1, (this.f1131h - a) << 1);
        }
        this.f1129f[a] = i;
        this.f1130g[a << 1] = k;
        this.f1130g[(a << 1) + 1] = v;
        this.f1131h++;
        return null;
    }

    public V remove(Object obj) {
        int a = m1662a(obj);
        return a >= 0 ? m1669d(a) : null;
    }

    public int size() {
        return this.f1131h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f1131h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f1131h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0222q b = m1667b(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            b = m1668c(i);
            if (b != this) {
                stringBuilder.append(b);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
