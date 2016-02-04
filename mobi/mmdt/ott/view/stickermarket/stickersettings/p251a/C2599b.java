package mobi.mmdt.ott.view.stickermarket.stickersettings.p251a;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: mobi.mmdt.ott.view.stickermarket.stickersettings.a.b */
class C2599b implements OnTouchListener {
    final /* synthetic */ C2598a f8328a;

    C2599b(C2598a c2598a) {
        this.f8328a = c2598a;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f8328a.f8321d.dispatchTouchEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), (float) ((this.f8328a.f8321d.getWidth() - this.f8328a.f8321d.getPaddingRight()) / 2), (float) (this.f8328a.f8321d.getHeight() / 2), motionEvent.getMetaState()));
        return false;
    }
}
