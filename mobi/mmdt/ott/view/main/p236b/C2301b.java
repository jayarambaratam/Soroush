package mobi.mmdt.ott.view.main.p236b;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* renamed from: mobi.mmdt.ott.view.main.b.b */
class C2301b extends OnScrollListener {
    final /* synthetic */ C2298a f7609a;

    C2301b(C2298a c2298a) {
        this.f7609a = c2298a;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        if (this.f7609a.f7597f && i2 > this.f7609a.f7598g) {
            this.f7609a.f7597f = false;
            this.f7609a.f7596e.m10324n();
        } else if (!this.f7609a.f7597f && i2 < (-this.f7609a.f7598g)) {
            this.f7609a.f7597f = true;
            this.f7609a.f7596e.m10323m();
        }
    }
}
