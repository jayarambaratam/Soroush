package android.support.v4.p015e;

/* renamed from: android.support.v4.e.l */
class C0213l implements C0211m {
    public static final C0213l f1117a;

    static {
        f1117a = new C0213l();
    }

    private C0213l() {
    }

    public int m1646a(CharSequence charSequence, int i, int i2) {
        int i3 = i + i2;
        int i4 = 2;
        while (i < i3 && i4 == 2) {
            i4 = C0209i.m1643d(Character.getDirectionality(charSequence.charAt(i)));
            i++;
        }
        return i4;
    }
}
