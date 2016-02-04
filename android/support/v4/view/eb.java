package android.support.v4.view;

import android.database.DataSetObserver;

class eb extends DataSetObserver {
    final /* synthetic */ ViewPager f1368a;

    private eb(ViewPager viewPager) {
        this.f1368a = viewPager;
    }

    public void onChanged() {
        this.f1368a.m1860c();
    }

    public void onInvalidated() {
        this.f1368a.m1860c();
    }
}
