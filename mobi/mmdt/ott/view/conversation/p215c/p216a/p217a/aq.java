package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.aq */
class aq implements OnTouchListener {
    final /* synthetic */ ao f6653a;

    aq(ao aoVar) {
        this.f6653a = aoVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && this.f6653a.f6651e) {
            this.f6653a.f6651e = false;
            return true;
        }
        if (motionEvent.getAction() == 0) {
            this.f6653a.f6651e = false;
        }
        return view.onTouchEvent(motionEvent);
    }
}
