package android.support.v4.p015e;

import org.linphone.core.VideoSize;

/* renamed from: android.support.v4.e.k */
class C0212k implements C0211m {
    public static final C0212k f1114a;
    public static final C0212k f1115b;
    private final boolean f1116c;

    static {
        f1114a = new C0212k(true);
        f1115b = new C0212k(false);
    }

    private C0212k(boolean z) {
        this.f1116c = z;
    }

    public int m1645a(CharSequence charSequence, int i, int i2) {
        int i3 = i + i2;
        int i4 = 0;
        while (i < i3) {
            switch (C0209i.m1642c(Character.getDirectionality(charSequence.charAt(i)))) {
                case VideoSize.QCIF /*0*/:
                    if (!this.f1116c) {
                        i4 = 1;
                        break;
                    }
                    return 0;
                case VideoSize.CIF /*1*/:
                    if (this.f1116c) {
                        i4 = 1;
                        break;
                    }
                    return 1;
                default:
                    break;
            }
            i++;
        }
        return i4 != 0 ? !this.f1116c ? 0 : 1 : 2;
    }
}
