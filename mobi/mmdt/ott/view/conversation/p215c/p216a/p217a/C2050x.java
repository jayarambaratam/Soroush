package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.x */
class C2050x implements OnTouchListener {
    final /* synthetic */ C2043q f6736a;

    C2050x(C2043q c2043q) {
        this.f6736a = c2043q;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.f6736a.f6719h) {
            this.f6736a.f6719h = false;
            return true;
        }
        if (motionEvent.getAction() == 0) {
            this.f6736a.f6719h = false;
        }
        return view.onTouchEvent(motionEvent);
    }
}
