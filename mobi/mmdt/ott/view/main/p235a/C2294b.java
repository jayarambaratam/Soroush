package mobi.mmdt.ott.view.main.p235a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

/* renamed from: mobi.mmdt.ott.view.main.a.b */
class C2294b extends OnScrollListener {
    final /* synthetic */ C2291a f7583a;

    C2294b(C2291a c2291a) {
        this.f7583a = c2291a;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        if (this.f7583a.f7577e && i2 > this.f7583a.f7578f) {
            this.f7583a.f7577e = false;
            this.f7583a.f7576d.m10322n();
        } else if (!this.f7583a.f7577e && i2 < (-this.f7583a.f7578f)) {
            this.f7583a.f7577e = true;
            this.f7583a.f7576d.m10321m();
        }
    }
}
