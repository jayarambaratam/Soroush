package mobi.mmdt.ott.view.main.p238d;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* renamed from: mobi.mmdt.ott.view.main.d.b */
class C2372b extends OnScrollListener {
    final /* synthetic */ C2369a f7834a;

    C2372b(C2369a c2369a) {
        this.f7834a = c2369a;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        if (this.f7834a.f7818f && i2 > this.f7834a.f7819g) {
            this.f7834a.f7818f = false;
            this.f7834a.f7817e.m10328n();
        } else if (!this.f7834a.f7818f && i2 < (-this.f7834a.f7819g)) {
            this.f7834a.f7818f = true;
            this.f7834a.f7817e.m10327m();
        }
    }
}
