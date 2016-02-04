package mobi.mmdt.ott.view.settings.p247a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: mobi.mmdt.ott.view.settings.a.e */
class C2513e implements OnTouchListener {
    final /* synthetic */ C2512d f8117a;

    C2513e(C2512d c2512d) {
        this.f8117a = c2512d;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f8117a.f8114c.dispatchTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), (float) ((this.f8117a.f8114c.getWidth() - this.f8117a.f8114c.getPaddingRight()) / 2), (float) (this.f8117a.f8114c.getHeight() / 2), motionEvent.getMetaState()));
        return false;
    }
}
