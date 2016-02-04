package com.felipecsl.asymmetricgridview.library.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* renamed from: com.felipecsl.asymmetricgridview.library.widget.b */
class C1056b implements OnGlobalLayoutListener {
    final /* synthetic */ AsymmetricGridView f3983a;

    C1056b(AsymmetricGridView asymmetricGridView) {
        this.f3983a = asymmetricGridView;
    }

    public void onGlobalLayout() {
        this.f3983a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.f3983a.m6247a();
        if (this.f3983a.f3963g != null) {
            this.f3983a.f3963g.m6221a();
        }
    }
}
