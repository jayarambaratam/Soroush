package android.support.v4.view;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

final class cz implements OnApplyWindowInsetsListener {
    final /* synthetic */ bs f1352a;

    cz(bs bsVar) {
        this.f1352a = bsVar;
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return ((fg) this.f1352a.m196a(view, new fg(windowInsets))).m2911g();
    }
}
