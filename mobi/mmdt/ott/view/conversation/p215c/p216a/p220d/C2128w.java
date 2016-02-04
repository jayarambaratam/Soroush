package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.w */
class C2128w implements OnTouchListener {
    final /* synthetic */ C2126u f6963a;

    C2128w(C2126u c2126u) {
        this.f6963a = c2126u;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.f6963a.f6961d) {
            this.f6963a.f6961d = false;
            return true;
        }
        if (motionEvent.getAction() == 0) {
            this.f6963a.f6961d = false;
        }
        return view.onTouchEvent(motionEvent);
    }
}
