package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public class bf {
    static final bk f1333a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f1333a = new bj();
        } else if (VERSION.SDK_INT >= 9) {
            f1333a = new bi();
        } else if (VERSION.SDK_INT >= 5) {
            f1333a = new bh();
        } else {
            f1333a = new bg();
        }
    }

    public static int m2309a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m2310a(MotionEvent motionEvent, int i) {
        return f1333a.m2319a(motionEvent, i);
    }

    public static int m2311b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m2312b(MotionEvent motionEvent, int i) {
        return f1333a.m2321b(motionEvent, i);
    }

    public static float m2313c(MotionEvent motionEvent, int i) {
        return f1333a.m2322c(motionEvent, i);
    }

    public static int m2314c(MotionEvent motionEvent) {
        return f1333a.m2318a(motionEvent);
    }

    public static float m2315d(MotionEvent motionEvent, int i) {
        return f1333a.m2323d(motionEvent, i);
    }

    public static int m2316d(MotionEvent motionEvent) {
        return f1333a.m2320b(motionEvent);
    }

    public static float m2317e(MotionEvent motionEvent, int i) {
        return f1333a.m2324e(motionEvent, i);
    }
}
