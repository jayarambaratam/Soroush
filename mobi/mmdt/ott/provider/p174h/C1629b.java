package mobi.mmdt.ott.provider.p174h;

import android.content.Context;
import android.content.CursorLoader;
import android.net.Uri;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.provider.h.b */
public class C1629b {
    public static int m8288a(Context context, int i, int i2) {
        C1633f c1633f = new C1633f();
        ((C1633f) c1633f.m8328c(i).m7912b()).m8327b(i2);
        return c1633f.m7905a(context);
    }

    public static int m8289a(Context context, String str, int i, int i2) {
        C1631d c1631d = new C1631d();
        c1631d.m8311f(i);
        c1631d.m8312g(i2);
        C1633f c1633f = new C1633f();
        c1633f.m8325a(str);
        return c1631d.m8300a(context, c1633f);
    }

    public static int m8290a(Context context, String str, C1634g c1634g) {
        C1631d c1631d = new C1631d();
        c1631d.m8304a(c1634g);
        C1633f c1633f = new C1633f();
        c1633f.m8325a(str);
        return c1631d.m8300a(context, c1633f);
    }

    public static CursorLoader m8291a(Context context, int i) {
        return new CursorLoader(context, C1630c.f5439a, null, "stickers_package_id =?", new String[]{i + BuildConfig.FLAVOR}, "stickers_sticker_id ASC");
    }

    public static Uri m8292a(Context context, int i, int i2, int i3, String str, String str2, String str3, int i4, int i5, int i6, int i7, C1634g c1634g) {
        if (str2 == null || str2.isEmpty() || str3 == null || str3.isEmpty()) {
            throw new NullPointerException();
        }
        C1631d c1631d = new C1631d();
        c1631d.m8305b(i).m8302a(i2).m8307c(i3).m8306b(str2).m8308c(str3).m8311f(i4).m8312g(i5).m8309d(i6).m8310e(i7).m8303a(str).m8304a(c1634g);
        return c1631d.m7897a(context);
    }

    public static String m8293a(int i, int i2, int i3) {
        return i + "_" + i2 + "_" + i3;
    }

    public static String m8294a(String str) {
        return str.split("_")[0];
    }

    public static String m8295a(String str, String str2, String str3) {
        return str + "_" + str2 + "_" + str3;
    }

    public static C1628a m8296a(Context context, String str) {
        C1633f c1633f = new C1633f();
        c1633f.m8325a(str);
        C1632e b = c1633f.m8326b(context);
        C1628a c1628a = null;
        if (b.moveToFirst()) {
            c1628a = new C1628a(b.m8317e(), b.m8319g());
        }
        b.close();
        return c1628a;
    }

    public static String m8297b(String str) {
        return str.split("_")[1];
    }

    public static C1632e m8298b(Context context, String str) {
        C1633f c1633f = new C1633f();
        c1633f.m8325a(str);
        return c1633f.m8326b(context);
    }

    public static String m8299c(String str) {
        return str.split("_")[2];
    }
}
