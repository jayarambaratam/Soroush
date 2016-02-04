package com.p032a.p033a.p042j;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: com.a.a.j.h */
public final class C0879h {
    private static final char[] f3066a;
    private static final char[] f3067b;
    private static final char[] f3068c;

    static {
        f3066a = "0123456789abcdef".toCharArray();
        f3067b = new char[64];
        f3068c = new char[40];
    }

    public static int m5300a(int i, int i2, Config config) {
        return (i * i2) * C0879h.m5301a(config);
    }

    private static int m5301a(Config config) {
        if (config == null) {
            config = Config.ARGB_8888;
        }
        switch (C0880i.f3069a[config.ordinal()]) {
            case VideoSize.CIF /*1*/:
                return 1;
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                return 2;
            default:
                return 4;
        }
    }

    @TargetApi(19)
    public static int m5302a(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException e) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static String m5303a(byte[] bArr) {
        String a;
        synchronized (f3067b) {
            a = C0879h.m5304a(bArr, f3067b);
        }
        return a;
    }

    private static String m5304a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f3066a[i2 >>> 4];
            cArr[(i * 2) + 1] = f3066a[i2 & 15];
        }
        return new String(cArr);
    }

    public static <T> List<T> m5305a(Collection<T> collection) {
        List<T> arrayList = new ArrayList(collection.size());
        for (T add : collection) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static <T> Queue<T> m5306a(int i) {
        return new ArrayDeque(i);
    }

    public static void m5307a() {
        if (!C0879h.m5311c()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean m5308a(int i, int i2) {
        return C0879h.m5310b(i) && C0879h.m5310b(i2);
    }

    public static void m5309b() {
        if (!C0879h.m5312d()) {
            throw new IllegalArgumentException("YOu must call this method on a background thread");
        }
    }

    private static boolean m5310b(int i) {
        return i > 0 || i == RtlSpacingHelper.UNDEFINED;
    }

    public static boolean m5311c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean m5312d() {
        return !C0879h.m5311c();
    }
}
