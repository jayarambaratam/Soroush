package mobi.mmdt.ott.view.main.p237c;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* renamed from: mobi.mmdt.ott.view.main.c.b */
class C2351b extends OnScrollListener {
    final /* synthetic */ C2347a f7784a;

    C2351b(C2347a c2347a) {
        this.f7784a = c2347a;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        if (this.f7784a.f7758f && i2 > this.f7784a.f7759g) {
            this.f7784a.f7758f = false;
            this.f7784a.f7757e.m10326n();
        } else if (!this.f7784a.f7758f && i2 < (-this.f7784a.f7759g)) {
            this.f7784a.f7758f = true;
            this.f7784a.f7757e.m10325m();
        }
    }
}
