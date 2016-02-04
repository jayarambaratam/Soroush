package p025b.p026a.p027a.p028a;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* renamed from: b.a.a.a.e */
class C0558e extends SimpleOnGestureListener {
    final /* synthetic */ C0557d f2329a;

    C0558e(C0557d c0557d) {
        this.f2329a = c0557d;
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (this.f2329a.f2322t != null) {
            this.f2329a.f2322t.onLongClick(this.f2329a.m4211c());
        }
    }
}
