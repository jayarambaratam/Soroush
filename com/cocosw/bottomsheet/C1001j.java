package com.cocosw.bottomsheet;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;

/* renamed from: com.cocosw.bottomsheet.j */
class C1001j implements OnGlobalLayoutListener {
    final /* synthetic */ C0993c f3795a;

    C1001j(C0993c c0993c) {
        this.f3795a = c0993c;
    }

    public void onGlobalLayout() {
        if (VERSION.SDK_INT < 16) {
            this.f3795a.f3770f.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.f3795a.f3770f.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        View childAt = this.f3795a.f3770f.getChildAt(this.f3795a.f3770f.getChildCount() - 1);
        if (childAt != null) {
            this.f3795a.f3770f.setLayoutParams(new LayoutParams(-1, (childAt.getPaddingBottom() + childAt.getBottom()) + this.f3795a.f3770f.getPaddingBottom()));
        }
    }
}
