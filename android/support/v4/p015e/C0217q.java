package android.support.v4.p015e;

import android.os.Build.VERSION;
import java.util.Locale;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: android.support.v4.e.q */
public class C0217q {
    public static final Locale f1121a;
    private static final C0219s f1122b;
    private static String f1123c;
    private static String f1124d;

    static {
        if (VERSION.SDK_INT >= 17) {
            f1122b = new C0220t();
        } else {
            f1122b = new C0219s();
        }
        f1121a = new Locale(BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        f1123c = "Arab";
        f1124d = "Hebr";
    }

    public static int m1652a(Locale locale) {
        return f1122b.m1656a(locale);
    }
}
