package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

/* renamed from: android.support.v4.view.q */
public class C0322q {
    private final C0323r f1392a;

    public C0322q(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public C0322q(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (VERSION.SDK_INT > 17) {
            this.f1392a = new C0326u(context, onGestureListener, handler);
        } else {
            this.f1392a = new C0324s(context, onGestureListener, handler);
        }
    }

    public boolean m2925a(MotionEvent motionEvent) {
        return this.f1392a.m2926a(motionEvent);
    }
}
