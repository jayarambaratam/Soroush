package android.support.v7.p009c.p010a;

import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import org.linphone.mediastream.Version;

/* renamed from: android.support.v7.c.a.a */
public class C0406a {
    public static Mode m3888a(int i, Mode mode) {
        switch (i) {
            case Version.API03_CUPCAKE_15 /*3*/:
                return Mode.SRC_OVER;
            case Version.API05_ECLAIR_20 /*5*/:
                return Mode.SRC_IN;
            case Version.API09_GINGERBREAD_23 /*9*/:
                return Mode.SRC_ATOP;
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
                return Mode.MULTIPLY;
            case Version.API15_ICE_CREAM_SANDWICH_403 /*15*/:
                return Mode.SCREEN;
            case Version.API16_JELLY_BEAN_41 /*16*/:
                return VERSION.SDK_INT >= 11 ? Mode.valueOf("ADD") : mode;
            default:
                return mode;
        }
    }
}
