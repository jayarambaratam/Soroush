package mobi.mmdt.ott.view.contact.p209a.p211b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import mobi.mmdt.ott.view.contact.p209a.p212c.C1953b;

/* renamed from: mobi.mmdt.ott.view.contact.a.b.b */
class C1946b implements OnTouchListener {
    final /* synthetic */ C1945a f6253a;

    C1946b(C1945a c1945a) {
        this.f6253a = c1945a;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((C1953b) this.f6253a.m8619a()).m9267k()) {
            this.f6253a.f6248e.dispatchTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), (float) ((this.f6253a.f6248e.getWidth() - this.f6253a.f6248e.getPaddingRight()) / 2), (float) (this.f6253a.f6248e.getHeight() / 2), motionEvent.getMetaState()));
        }
        return false;
    }
}
