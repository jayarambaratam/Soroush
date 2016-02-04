package mobi.mmdt.ott.view.components.imageslider;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.b */
class C1846b implements OnTouchListener {
    final /* synthetic */ SliderLayout f5977a;

    C1846b(SliderLayout sliderLayout) {
        this.f5977a = sliderLayout;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case VideoSize.CIF /*1*/:
                this.f5977a.m8850d();
                break;
        }
        return false;
    }
}
