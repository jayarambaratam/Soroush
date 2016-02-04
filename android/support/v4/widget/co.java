package android.support.v4.widget;

import android.util.Log;
import android.widget.TextView;
import java.lang.reflect.Field;

class co {
    private static Field f1662a;
    private static boolean f1663b;
    private static Field f1664c;
    private static boolean f1665d;

    static int m3364a(TextView textView) {
        if (!f1665d) {
            f1664c = m3366a("mMaxMode");
            f1665d = true;
        }
        if (f1664c != null && m3365a(f1664c, textView) == 1) {
            if (!f1663b) {
                f1662a = m3366a("mMaximum");
                f1663b = true;
            }
            if (f1662a != null) {
                return m3365a(f1662a, textView);
            }
        }
        return -1;
    }

    private static int m3365a(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException e) {
            Log.d("TextViewCompatDonut", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    private static Field m3366a(String str) {
        Field field = null;
        try {
            field = TextView.class.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            Log.e("TextViewCompatDonut", "Could not retrieve " + str + " field.");
            return field;
        }
    }
}
