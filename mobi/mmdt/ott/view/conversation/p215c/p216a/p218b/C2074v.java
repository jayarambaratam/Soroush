package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.v */
class C2074v implements OnTouchListener {
    final /* synthetic */ C2072t f6803a;

    C2074v(C2072t c2072t) {
        this.f6803a = c2072t;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.f6803a.f6801d) {
            this.f6803a.f6801d = false;
            return true;
        }
        if (motionEvent.getAction() == 0) {
            this.f6803a.f6801d = false;
        }
        return view.onTouchEvent(motionEvent);
    }
}
