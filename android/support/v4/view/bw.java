package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

public class bw {
    static final bz f1340a;

    static {
        if (VERSION.SDK_INT >= 11) {
            f1340a = new by();
        } else {
            f1340a = new bx();
        }
    }

    public static float m2358a(VelocityTracker velocityTracker, int i) {
        return f1340a.m2360a(velocityTracker, i);
    }

    public static float m2359b(VelocityTracker velocityTracker, int i) {
        return f1340a.m2361b(velocityTracker, i);
    }
}
