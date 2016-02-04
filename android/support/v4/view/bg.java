package android.support.v4.view;

import android.view.MotionEvent;

class bg implements bk {
    bg() {
    }

    public int m2325a(MotionEvent motionEvent) {
        return 1;
    }

    public int m2326a(MotionEvent motionEvent, int i) {
        return i == 0 ? 0 : -1;
    }

    public int m2327b(MotionEvent motionEvent) {
        return 0;
    }

    public int m2328b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float m2329c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float m2330d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float m2331e(MotionEvent motionEvent, int i) {
        return 0.0f;
    }
}
