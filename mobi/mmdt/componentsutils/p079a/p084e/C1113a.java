package mobi.mmdt.componentsutils.p079a.p084e;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import java.util.Calendar;
import java.util.TimeZone;

/* renamed from: mobi.mmdt.componentsutils.a.e.a */
public class C1113a {
    public static long m6421a() {
        return Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();
    }

    public static boolean m6422a(Context context) {
        return VERSION.SDK_INT >= 17 ? Global.getInt(context.getContentResolver(), "auto_time", 0) != 0 : System.getInt(context.getContentResolver(), "auto_time", 0) != 0;
    }
}
