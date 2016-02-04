package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.v */
class C2101v implements OnTouchListener {
    final /* synthetic */ C2099t f6884a;

    C2101v(C2099t c2099t) {
        this.f6884a = c2099t;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.f6884a.f6882e) {
            this.f6884a.f6882e = false;
            return true;
        }
        if (motionEvent.getAction() == 0) {
            this.f6884a.f6882e = false;
        }
        return view.onTouchEvent(motionEvent);
    }
}
