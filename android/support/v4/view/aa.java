package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.KeyEvent;

public class aa {
    static final ae f1323a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f1323a = new ad();
        } else {
            f1323a = new ab();
        }
    }

    public static boolean m2205a(KeyEvent keyEvent) {
        return f1323a.m2210b(keyEvent.getMetaState());
    }

    public static boolean m2206a(KeyEvent keyEvent, int i) {
        return f1323a.m2209a(keyEvent.getMetaState(), i);
    }

    public static void m2207b(KeyEvent keyEvent) {
        f1323a.m2208a(keyEvent);
    }
}
