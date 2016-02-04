package android.support.v4.view;

import android.view.View;
import java.lang.ref.WeakReference;

class eo implements Runnable {
    WeakReference<View> f1376a;
    el f1377b;
    final /* synthetic */ en f1378c;

    private eo(en enVar, el elVar, View view) {
        this.f1378c = enVar;
        this.f1376a = new WeakReference(view);
        this.f1377b = elVar;
    }

    public void run() {
        View view = (View) this.f1376a.get();
        if (view != null) {
            this.f1378c.m2829d(this.f1377b, view);
        }
    }
}
