package com.astuetz;

import android.support.v4.view.dz;

/* renamed from: com.astuetz.d */
class C0911d implements dz {
    final /* synthetic */ PagerSlidingTabStrip f3191a;

    private C0911d(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.f3191a = pagerSlidingTabStrip;
    }

    public void m5411a(int i) {
        if (i == 0) {
            this.f3191a.m5407b(this.f3191a.f3168g.getCurrentItem(), 0);
        }
        if (this.f3191a.f3163a != null) {
            this.f3191a.f3163a.m663a(i);
        }
    }

    public void m5412a(int i, float f, int i2) {
        this.f3191a.f3170i = i;
        this.f3191a.f3171j = f;
        this.f3191a.m5407b(i, (int) (((float) this.f3191a.f3167f.getChildAt(i).getWidth()) * f));
        this.f3191a.invalidate();
        if (this.f3191a.f3163a != null) {
            this.f3191a.f3163a.m664a(i, f, i2);
        }
    }

    public void m5413b(int i) {
        if (this.f3191a.f3163a != null) {
            this.f3191a.f3163a.m665b(i);
        }
    }
}
