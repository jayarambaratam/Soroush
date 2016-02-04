package android.support.v4.p016f;

/* renamed from: android.support.v4.f.c */
class C0226c {
    static final int[] f1137a;
    static final long[] f1138b;
    static final Object[] f1139c;

    static {
        f1137a = new int[0];
        f1138b = new long[0];
        f1139c = new Object[0];
    }

    public static int m1699a(int i) {
        return C0226c.m1704c(i * 4) / 4;
    }

    static int m1700a(int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = i - 1;
        while (i3 <= i4) {
            int i5 = (i3 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i3 = i5 + 1;
            } else if (i6 <= i2) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return i3 ^ -1;
    }

    static int m1701a(long[] jArr, int i, long j) {
        int i2 = 0;
        int i3 = i - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i2 = i4 + 1;
            } else if (j2 <= j) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public static boolean m1702a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int m1703b(int i) {
        return C0226c.m1704c(i * 8) / 8;
    }

    public static int m1704c(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }
}
