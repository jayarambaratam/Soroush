package mobi.mmdt.ott.view.main.basenavigation.viewpager;

import android.database.DataSetObserver;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.viewpager.k */
class C2336k extends DataSetObserver {
    final /* synthetic */ VerticalViewPager f7728a;

    private C2336k(VerticalViewPager verticalViewPager) {
        this.f7728a = verticalViewPager;
    }

    public void onChanged() {
        this.f7728a.m10490b();
    }

    public void onInvalidated() {
        this.f7728a.m10490b();
    }
}
