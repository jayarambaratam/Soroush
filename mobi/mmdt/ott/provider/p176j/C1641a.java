package mobi.mmdt.ott.provider.p176j;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* renamed from: mobi.mmdt.ott.provider.j.a */
public class C1641a {
    public static Uri m8369a(Context context, String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        C1643c c1643c = new C1643c();
        c1643c.m8374a(str);
        return c1643c.m7897a(context);
    }

    public static String[] m8370a(Context context) {
        C1644d b = new C1645e().m8378b(context);
        String[] strArr = new String[b.getCount()];
        int i = 0;
        if (b.moveToFirst()) {
            while (!b.isAfterLast()) {
                int i2 = i + 1;
                strArr[i] = b.m8375a();
                b.moveToNext();
                i = i2;
            }
        }
        b.close();
        return strArr;
    }

    public static boolean m8371b(Context context, String str) {
        C1645e c1645e = new C1645e();
        c1645e.m8377a(str);
        Cursor b = c1645e.m8378b(context);
        if (b.getCount() > 0) {
            b.close();
            return true;
        }
        b.close();
        return false;
    }

    public static long m8372c(Context context, String str) {
        return (long) new C1645e().m8377a(str).m7905a(context);
    }
}
