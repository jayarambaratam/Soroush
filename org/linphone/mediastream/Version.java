package org.linphone.mediastream;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import org.linphone.mediastream.video.capture.hwconf.Hacks;

public class Version {
    public static final int API03_CUPCAKE_15 = 3;
    public static final int API04_DONUT_16 = 4;
    public static final int API05_ECLAIR_20 = 5;
    public static final int API06_ECLAIR_201 = 6;
    public static final int API07_ECLAIR_21 = 7;
    public static final int API08_FROYO_22 = 8;
    public static final int API09_GINGERBREAD_23 = 9;
    public static final int API10_GINGERBREAD_MR1_233 = 10;
    public static final int API11_HONEYCOMB_30 = 11;
    public static final int API12_HONEYCOMB_MR1_31X = 12;
    public static final int API13_HONEYCOMB_MR2_32 = 13;
    public static final int API14_ICE_CREAM_SANDWICH_40 = 14;
    public static final int API15_ICE_CREAM_SANDWICH_403 = 15;
    public static final int API16_JELLY_BEAN_41 = 16;
    public static final int API17_JELLY_BEAN_42 = 17;
    public static final int API18_JELLY_BEAN_43 = 18;
    public static final int API19_KITKAT_44 = 19;
    private static final int buildVersion;
    private static Boolean hasNeon;
    private static Boolean sCacheHasZrtp;

    static {
        buildVersion = VERSION.SDK_INT;
    }

    public static void dumpCapabilities() {
        StringBuilder stringBuilder = new StringBuilder(" ==== Capabilities dump ====\n");
        stringBuilder.append("Has neon: ").append(Boolean.toString(hasNeon())).append("\n");
        stringBuilder.append("Has ZRTP: ").append(Boolean.toString(hasZrtp())).append("\n");
        Log.m11095i(stringBuilder.toString());
    }

    public static boolean hasFastCpu() {
        return isArmv7() || isX86();
    }

    public static boolean hasFastCpuWithAsmOptim() {
        return (isArmv7() && hasNeon()) || isX86();
    }

    public static boolean hasNeon() {
        if (hasNeon == null) {
            hasNeon = Boolean.valueOf(nativeHasNeon());
        }
        return hasNeon.booleanValue();
    }

    public static boolean hasZrtp() {
        if (sCacheHasZrtp == null) {
            sCacheHasZrtp = Boolean.valueOf(nativeHasZrtp());
        }
        return sCacheHasZrtp.booleanValue();
    }

    public static boolean isArmv7() {
        try {
            return sdkAboveOrEqual(API04_DONUT_16) && Build.class.getField("CPU_ABI").get(null).toString().startsWith("armeabi-v7");
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean isHDVideoCapable() {
        return isVideoCapable() && hasFastCpuWithAsmOptim() && Runtime.getRuntime().availableProcessors() > 1;
    }

    public static boolean isVideoCapable() {
        return !sdkStrictlyBelow(API05_ECLAIR_20) && hasFastCpu() && Hacks.hasCamera();
    }

    public static boolean isX86() {
        try {
            return sdkAboveOrEqual(API04_DONUT_16) && Build.class.getField("CPU_ABI").get(null).toString().startsWith("x86");
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean isXLargeScreen(Context context) {
        return (context.getResources().getConfiguration().screenLayout & API15_ICE_CREAM_SANDWICH_403) >= API04_DONUT_16;
    }

    private static native boolean nativeHasNeon();

    private static native boolean nativeHasZrtp();

    public static int sdk() {
        return buildVersion;
    }

    public static final boolean sdkAboveOrEqual(int i) {
        return buildVersion >= i;
    }

    public static final boolean sdkStrictlyBelow(int i) {
        return buildVersion < i;
    }
}
