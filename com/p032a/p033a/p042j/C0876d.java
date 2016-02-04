package com.p032a.p033a.p042j;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;

/* renamed from: com.a.a.j.d */
public final class C0876d {
    private static final double f3062a;

    static {
        double d = 1.0d;
        if (17 <= VERSION.SDK_INT) {
            d = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f3062a = d;
    }

    public static double m5295a(long j) {
        return ((double) (C0876d.m5296a() - j)) * f3062a;
    }

    @TargetApi(17)
    public static long m5296a() {
        return 17 <= VERSION.SDK_INT ? SystemClock.elapsedRealtimeNanos() : System.currentTimeMillis();
    }
}
