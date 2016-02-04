package android.support.v7.app;

import android.graphics.Rect;
import android.support.v7.widget.FitWindowsViewGroup.OnFitSystemWindowsListener;

class au implements OnFitSystemWindowsListener {
    final /* synthetic */ AppCompatDelegateImplV7 f1785a;

    au(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        this.f1785a = appCompatDelegateImplV7;
    }

    public void onFitSystemWindows(Rect rect) {
        rect.top = this.f1785a.m3531f(rect.top);
    }
}
