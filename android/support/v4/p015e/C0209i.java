package android.support.v4.p015e;

import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: android.support.v4.e.i */
public class C0209i {
    public static final C0208h f1108a;
    public static final C0208h f1109b;
    public static final C0208h f1110c;
    public static final C0208h f1111d;
    public static final C0208h f1112e;
    public static final C0208h f1113f;

    static {
        f1108a = new C0215o(null, false, null);
        f1109b = new C0215o(null, true, null);
        f1110c = new C0215o(C0213l.f1117a, false, null);
        f1111d = new C0215o(C0213l.f1117a, true, null);
        f1112e = new C0215o(C0212k.f1114a, false, null);
        f1113f = C0216p.f1120a;
    }

    private static int m1642c(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
                return 1;
            case VideoSize.CIF /*1*/:
            case VideoSize.HVGA /*2*/:
                return 0;
            default:
                return 2;
        }
    }

    private static int m1643d(int i) {
        switch (i) {
            case VideoSize.QCIF /*0*/:
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
            case Version.API15_ICE_CREAM_SANDWICH_403 /*15*/:
                return 1;
            case VideoSize.CIF /*1*/:
            case VideoSize.HVGA /*2*/:
            case Version.API16_JELLY_BEAN_41 /*16*/:
            case Version.API17_JELLY_BEAN_42 /*17*/:
                return 0;
            default:
                return 2;
        }
    }
}
