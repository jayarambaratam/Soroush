package mobi.mmdt.ott.provider.p175i;

import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.provider.i.a */
public class C1635a {
    public static int m8330a(Context context, int i) {
        C1639e c1639e = new C1639e();
        c1639e.m8367b(i);
        C1638d b = c1639e.m8366b(context);
        b.moveToFirst();
        int a = b.m8357a();
        if (!(b == null || b.isClosed())) {
            b.close();
        }
        return a;
    }

    public static int m8331a(Context context, int i, int i2) {
        C1637c c1637c = new C1637c();
        c1637c.m8348b(i2);
        C1639e c1639e = new C1639e();
        c1639e.m8367b(i);
        return c1637c.m8342a(context, c1639e);
    }

    public static int m8332a(Context context, int i, int i2, String str, String str2, String str3, int i3, String str4, String str5, String str6, boolean z, int i4, C1640f c1640f) {
        C1637c c1637c = new C1637c();
        c1637c.m8344a(i2).m8353d(str).m8345a(str2).m8355e(str3).m8354e(i3).m8351c(str4).m8349b(str5).m8356f(str6).m8347a(z).m8348b(i4).m8346a(c1640f);
        C1639e c1639e = new C1639e();
        c1639e.m8367b(i);
        return c1637c.m8342a(context, c1639e);
    }

    public static int m8333a(Context context, int i, C1640f c1640f) {
        C1637c c1637c = new C1637c();
        c1637c.m8346a(c1640f);
        C1639e c1639e = new C1639e();
        c1639e.m8367b(i);
        return c1637c.m8342a(context, c1639e);
    }

    public static int m8334a(Context context, int i, boolean z) {
        C1637c c1637c = new C1637c();
        c1637c.m8347a(z);
        C1639e c1639e = new C1639e();
        c1639e.m8367b(i);
        return c1637c.m8342a(context, c1639e);
    }

    public static CursorLoader m8335a(Context context) {
        return new CursorLoader(context, C1636b.f5447a, null, "stickerspackage_download_state =? ", new String[]{C1640f.READY.ordinal() + BuildConfig.FLAVOR}, "_id ASC");
    }

    public static Uri m8336a(Context context, int i, int i2, String str, String str2, String str3, int i3, String str4, String str5, String str6, boolean z, int i4, C1640f c1640f, int i5) {
        if (c1640f == null) {
            throw new NullPointerException();
        }
        C1637c c1637c = new C1637c();
        c1637c.m8352d(i).m8344a(i2).m8353d(str).m8345a(str2).m8355e(str3).m8354e(i3).m8351c(str4).m8349b(str5).m8356f(str6).m8347a(z).m8348b(i4).m8346a(c1640f).m8350c(i5);
        return c1637c.m7897a(context);
    }

    public static boolean m8337a(Context context, String str) {
        Cursor query = context.getContentResolver().query(C1636b.f5447a, null, "stickerspackage_package_id =?  AND stickerspackage_download_state =? ", new String[]{str, C1640f.READY.ordinal() + BuildConfig.FLAVOR}, null);
        boolean z = query != null && query.getCount() > 0;
        if (!(query == null || query.isClosed())) {
            query.close();
        }
        return z;
    }

    public static int m8338b(Context context) {
        C1637c c1637c = new C1637c();
        c1637c.m8346a(C1640f.ERROR);
        C1639e c1639e = new C1639e();
        c1639e.m8365a(C1640f.READY);
        return c1637c.m8342a(context, c1639e);
    }

    public static int m8339b(Context context, int i, int i2) {
        C1637c c1637c = new C1637c();
        c1637c.m8350c(i2);
        C1639e c1639e = new C1639e();
        c1639e.m8367b(i);
        return c1637c.m8342a(context, c1639e);
    }

    public static CursorLoader m8340b(Context context, int i) {
        return new CursorLoader(context, C1636b.f5447a, null, "stickerspackage_package_id =? ", new String[]{i + BuildConfig.FLAVOR}, "stickerspackage_package_id ASC");
    }

    public static C1638d m8341c(Context context, int i) {
        C1639e c1639e = new C1639e();
        c1639e.m8367b(i);
        return c1639e.m8366b(context);
    }
}
