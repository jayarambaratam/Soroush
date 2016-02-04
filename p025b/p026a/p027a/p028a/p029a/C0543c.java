package p025b.p026a.p027a.p028a.p029a;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

@TargetApi(8)
/* renamed from: b.a.a.a.a.c */
public class C0543c extends C0542b {
    protected final ScaleGestureDetector f2293f;

    public C0543c(Context context) {
        super(context);
        this.f2293f = new ScaleGestureDetector(context, new C0544d(this));
    }

    public boolean m4148a() {
        return this.f2293f.isInProgress();
    }

    public boolean m4149c(MotionEvent motionEvent) {
        this.f2293f.onTouchEvent(motionEvent);
        return super.m4147c(motionEvent);
    }
}
