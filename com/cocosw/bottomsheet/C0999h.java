package com.cocosw.bottomsheet;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* renamed from: com.cocosw.bottomsheet.h */
class C0999h implements OnItemClickListener {
    final /* synthetic */ ClosableSlidingLayout f3792a;
    final /* synthetic */ C0993c f3793b;

    C0999h(C0993c c0993c, ClosableSlidingLayout closableSlidingLayout) {
        this.f3793b = c0993c;
        this.f3792a = closableSlidingLayout;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (((MenuItem) this.f3793b.f3771g.getItem(i)).getItemId() == C1009s.bs_more) {
            this.f3793b.m6088e();
            this.f3792a.m6054a(false);
            return;
        }
        if (!((C0992b) this.f3793b.f3771g.getItem(i)).m6072b()) {
            if (this.f3793b.f3772h.f3809m != null) {
                this.f3793b.f3772h.f3809m.onMenuItemClick((MenuItem) this.f3793b.f3771g.getItem(i));
            } else if (this.f3793b.f3772h.f3803g != null) {
                this.f3793b.f3772h.f3803g.onClick(this.f3793b, ((MenuItem) this.f3793b.f3771g.getItem(i)).getItemId());
            }
        }
        this.f3793b.dismiss();
    }
}
