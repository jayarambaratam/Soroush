package mobi.mmdt.ott.view.components.p181b;

import android.database.DataSetObserver;

/* renamed from: mobi.mmdt.ott.view.components.b.p */
class C1795p extends DataSetObserver {
    final /* synthetic */ C1785m f5785a;

    private C1795p(C1785m c1785m) {
        this.f5785a = c1785m;
    }

    public void onChanged() {
        this.f5785a.f5767a = true;
        this.f5785a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f5785a.f5767a = false;
        this.f5785a.notifyDataSetChanged();
    }
}
