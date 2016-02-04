package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class ap extends EpicenterCallback {
    final /* synthetic */ Rect f821a;

    ap(Rect rect) {
        this.f821a = rect;
    }

    public Rect onGetEpicenter(Transition transition) {
        return this.f821a;
    }
}
