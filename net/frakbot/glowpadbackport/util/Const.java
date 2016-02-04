package net.frakbot.glowpadbackport.util;

import android.os.Build.VERSION;

public class Const {
    public static final boolean IS_ECLAIR;
    public static final boolean IS_FROYO;
    public static final boolean IS_ICS;
    public static final boolean IS_JB;
    public static final boolean IS_JB_MR1;

    static {
        boolean z = true;
        IS_ECLAIR = VERSION.SDK_INT >= 5;
        IS_FROYO = VERSION.SDK_INT >= 8;
        IS_ICS = VERSION.SDK_INT >= 14;
        IS_JB = VERSION.SDK_INT >= 16;
        if (VERSION.SDK_INT < 17) {
            z = false;
        }
        IS_JB_MR1 = z;
    }
}
