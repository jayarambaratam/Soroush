package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

/* renamed from: android.support.v4.view.u */
class C0326u implements C0323r {
    private final GestureDetector f1418a;

    public C0326u(Context context, OnGestureListener onGestureListener, Handler handler) {
        this.f1418a = new GestureDetector(context, onGestureListener, handler);
    }

    public boolean m2940a(MotionEvent motionEvent) {
        return this.f1418a.onTouchEvent(motionEvent);
    }
}
