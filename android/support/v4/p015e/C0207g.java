package android.support.v4.p015e;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: android.support.v4.e.g */
class C0207g {
    private static Method f1106a;
    private static Method f1107b;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f1106a = cls.getMethod("getScript", new Class[]{String.class});
                f1107b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            f1106a = null;
            f1107b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    private static String m1636a(String str) {
        try {
            if (f1106a != null) {
                return (String) f1106a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    public static String m1637a(Locale locale) {
        String b = C0207g.m1638b(locale);
        return b != null ? C0207g.m1636a(b) : null;
    }

    private static String m1638b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f1107b != null) {
                return (String) f1107b.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
