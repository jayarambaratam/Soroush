package mobi.mmdt.ott.view.components.imageslider.Tricks;

import android.database.DataSetObserver;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.Tricks.m */
class C1834m extends DataSetObserver {
    final /* synthetic */ ViewPagerEx f5956a;

    private C1834m(ViewPagerEx viewPagerEx) {
        this.f5956a = viewPagerEx;
    }

    public void onChanged() {
        this.f5956a.m8897b();
    }

    public void onInvalidated() {
        this.f5956a.m8897b();
    }
}
