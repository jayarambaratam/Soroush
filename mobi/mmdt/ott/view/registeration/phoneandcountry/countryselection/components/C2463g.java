package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.SmoothScroller;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.g */
class C2463g implements Runnable {
    final /* synthetic */ RecyclerView f8021a;
    final /* synthetic */ int f8022b;
    final /* synthetic */ LayoutManager f8023c;

    C2463g(LayoutManager layoutManager, RecyclerView recyclerView, int i) {
        this.f8023c = layoutManager;
        this.f8021a = recyclerView;
        this.f8022b = i;
    }

    public void run() {
        SmoothScroller c2464h = new C2464h(this, this.f8021a.getContext());
        c2464h.setTargetPosition(this.f8022b);
        this.f8023c.startSmoothScroll(c2464h);
    }
}
