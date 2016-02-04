package com.astuetz;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* renamed from: com.astuetz.a */
class C0908a implements OnGlobalLayoutListener {
    final /* synthetic */ PagerSlidingTabStrip f3188a;

    C0908a(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.f3188a = pagerSlidingTabStrip;
    }

    @SuppressLint({"NewApi"})
    public void onGlobalLayout() {
        if (VERSION.SDK_INT < 16) {
            this.f3188a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.f3188a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        this.f3188a.f3170i = this.f3188a.f3168g.getCurrentItem();
        this.f3188a.m5407b(this.f3188a.f3170i, 0);
    }
}
