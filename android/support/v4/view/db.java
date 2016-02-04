package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public class db {
    static final dg f1353a;

    static {
        if (VERSION.SDK_INT >= 14) {
            f1353a = new df();
        } else if (VERSION.SDK_INT >= 11) {
            f1353a = new de();
        } else if (VERSION.SDK_INT >= 8) {
            f1353a = new dd();
        } else {
            f1353a = new dc();
        }
    }

    public static int m2730a(ViewConfiguration viewConfiguration) {
        return f1353a.m2732a(viewConfiguration);
    }

    public static boolean m2731b(ViewConfiguration viewConfiguration) {
        return f1353a.m2733b(viewConfiguration);
    }
}
