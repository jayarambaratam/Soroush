package android.support.v4.view;

import android.view.MotionEvent;

class bl {
    public static int m2339a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static int m2340a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m2341b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m2342c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m2343d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
