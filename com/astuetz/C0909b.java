package com.astuetz;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.astuetz.b */
class C0909b implements OnClickListener {
    final /* synthetic */ int f3189a;
    final /* synthetic */ PagerSlidingTabStrip f3190b;

    C0909b(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
        this.f3190b = pagerSlidingTabStrip;
        this.f3189a = i;
    }

    public void onClick(View view) {
        this.f3190b.f3168g.setCurrentItem(this.f3189a);
    }
}
