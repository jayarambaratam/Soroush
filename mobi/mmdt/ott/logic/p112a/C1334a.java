package mobi.mmdt.ott.logic.p112a;

import mobi.mmdt.ott.p095c.p096a.C1258f;
import mobi.mmdt.ott.provider.p172f.C1619f;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.a.a */
public class C1334a {
    public static C1258f m7022a(C1619f c1619f) {
        switch (C1363b.f4664b[c1619f.ordinal()]) {
            case VideoSize.CIF /*1*/:
                return C1258f.ADMIN;
            case VideoSize.HVGA /*2*/:
                return C1258f.ADMIN;
            case Version.API03_CUPCAKE_15 /*3*/:
                return C1258f.MEMBER;
            case Version.API04_DONUT_16 /*4*/:
                return C1258f.VISITOR;
            default:
                return C1258f.NONE;
        }
    }

    public static C1619f m7023a(C1258f c1258f) {
        switch (C1363b.f4663a[c1258f.ordinal()]) {
            case VideoSize.CIF /*1*/:
                return C1619f.ADMIN;
            case VideoSize.HVGA /*2*/:
                return C1619f.OWNER;
            case Version.API03_CUPCAKE_15 /*3*/:
                return C1619f.MEMBER;
            case Version.API04_DONUT_16 /*4*/:
                return C1619f.VISITOR;
            case Version.API05_ECLAIR_20 /*5*/:
                return C1619f.NONE;
            default:
                return C1619f.NONE;
        }
    }
}
