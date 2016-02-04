package mobi.mmdt.ott.view.conversation.p214b;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.view.conversation.p222d.C2151a;

/* renamed from: mobi.mmdt.ott.view.conversation.b.b */
class C2020b extends OnScrollListener {
    final /* synthetic */ C2019a f6589a;

    C2020b(C2019a c2019a) {
        this.f6589a = c2019a;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            this.f6589a.f6580r = this.f6589a.f6571i.findFirstVisibleItemPosition() == 0;
            if (this.f6589a.f6580r) {
                this.f6589a.f6570h.setVisibility(8);
                this.f6589a.f6581s = false;
                this.f6589a.f6574l.m9352s();
            }
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        if (this.f6589a.f6581s && i2 < (-this.f6589a.f6576n)) {
            this.f6589a.f6581s = false;
            this.f6589a.f6570h.setVisibility(8);
        } else if (!(this.f6589a.f6580r || this.f6589a.f6581s || i2 <= this.f6589a.f6576n)) {
            this.f6589a.f6581s = true;
            this.f6589a.f6570h.setVisibility(0);
        }
        int findFirstVisibleItemPosition = this.f6589a.f6571i.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.f6589a.f6571i.findLastVisibleItemPosition();
        this.f6589a.f6571i.findLastCompletelyVisibleItemPosition();
        if (this.f6589a.f6587y != findLastVisibleItemPosition) {
            if (findLastVisibleItemPosition < 0 || this.f6589a.f6573k == null || this.f6589a.f6573k.getItemCount() <= 0) {
                this.f6589a.f6569g.setText(C1111c.m6395a(this.f6589a.getActivity(), System.currentTimeMillis()));
            } else {
                C2151a c2151a = (C2151a) this.f6589a.f6573k.m8752a(findLastVisibleItemPosition);
                this.f6589a.f6569g.setText(c2151a.m9840b());
                if (c2151a.m9843e()) {
                    this.f6589a.f6569g.setVisibility(4);
                } else {
                    this.f6589a.f6569g.setVisibility(0);
                }
            }
        }
        this.f6589a.f6586x = findFirstVisibleItemPosition;
        this.f6589a.f6587y = findLastVisibleItemPosition;
    }
}
