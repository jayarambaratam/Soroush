package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public class ah {
    static final ai f1324a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1324a = new al();
        } else if (i >= 11) {
            f1324a = new ak();
        } else {
            f1324a = new aj();
        }
    }

    public static void m2224a(LayoutInflater layoutInflater, ar arVar) {
        f1324a.m2225a(layoutInflater, arVar);
    }
}
