package mobi.mmdt.componentsutils.p079a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.componentsutils.a.a */
public class C1107a {
    public static NetworkInfo m6375a(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    private static boolean m6376a(Context context, String str, int i) {
        if (!C1107a.m6377b(context)) {
            return false;
        }
        switch (Runtime.getRuntime().exec("ping -w " + i + " -c 1 " + str).waitFor()) {
            case VideoSize.CIF /*1*/:
                return false;
            default:
                return true;
        }
    }

    public static boolean m6377b(Context context) {
        NetworkInfo a = C1107a.m6375a(context);
        return a != null && a.isConnected();
    }

    public static boolean m6378c(Context context) {
        NetworkInfo a = C1107a.m6375a(context);
        return a != null && a.isConnected() && a.getType() == 1;
    }

    public static boolean m6379d(Context context) {
        NetworkInfo a = C1107a.m6375a(context);
        return a != null && a.isConnected() && a.getType() == 0;
    }

    public static boolean m6380e(Context context) {
        return C1107a.m6376a(context, "8.8.8.8", 1000) || C1107a.m6376a(context, "4.2.2.4", 1000);
    }
}
