package mobi.mmdt.ott.p095c.p108d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p082c.C1110a;
import org.jivesoftware.smack.packet.StreamOpen;

/* renamed from: mobi.mmdt.ott.c.d.b */
public class C1301b {
    public static String m6869a(int i) {
        return C1110a.m6387a(i);
    }

    public static String m6870a(Context context) {
        switch (context.getResources().getDisplayMetrics().densityDpi) {
            case 120:
                return "ldpi";
            case 160:
                return "mdpi";
            case 240:
                return "hdpi";
            case 320:
                return "xhdpi";
            case 480:
                return "xxhdpi";
            case 640:
                return "xxxhdpi";
            default:
                return "hdpi";
        }
    }

    public static String m6871b(Context context) {
        return "android_" + C1301b.m6872c(context) + "_" + Build.BRAND + "_" + Build.MODEL;
    }

    public static String m6872c(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Throwable e) {
            C1104b.m6363a(C1301b.class, e.getMessage(), e);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : StreamOpen.VERSION;
    }

    public static String m6873d(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getTypeName() : null;
    }
}
