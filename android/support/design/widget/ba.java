package android.support.design.widget;

import android.view.View;
import android.view.View.OnClickListener;

class ba implements OnClickListener {
    final /* synthetic */ OnClickListener f488a;
    final /* synthetic */ Snackbar f489b;

    ba(Snackbar snackbar, OnClickListener onClickListener) {
        this.f489b = snackbar;
        this.f488a = onClickListener;
    }

    public void onClick(View view) {
        this.f488a.onClick(view);
        this.f489b.m384c(1);
    }
}
