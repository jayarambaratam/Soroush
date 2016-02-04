package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public class as {
    static final at f1328a;

    static {
        if (VERSION.SDK_INT >= 17) {
            f1328a = new av();
        } else {
            f1328a = new au();
        }
    }

    public static int m2233a(MarginLayoutParams marginLayoutParams) {
        return f1328a.m2235a(marginLayoutParams);
    }

    public static int m2234b(MarginLayoutParams marginLayoutParams) {
        return f1328a.m2236b(marginLayoutParams);
    }
}
