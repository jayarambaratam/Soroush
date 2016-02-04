package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

final class ar extends EpicenterCallback {
    final /* synthetic */ at f829a;
    private Rect f830b;

    ar(at atVar) {
        this.f829a = atVar;
    }

    public Rect onGetEpicenter(Transition transition) {
        if (this.f830b == null && this.f829a.f842a != null) {
            this.f830b = ao.m1085c(this.f829a.f842a);
        }
        return this.f830b;
    }
}
