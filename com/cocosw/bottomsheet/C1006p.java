package com.cocosw.bottomsheet;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

/* renamed from: com.cocosw.bottomsheet.p */
class C1006p extends LinearLayout {
    private View f3811a;

    public C1006p(Context context) {
        super(context);
    }

    public void m6129a(View view) {
        this.f3811a = view;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f3811a != null) {
            i2 = MeasureSpec.makeMeasureSpec(this.f3811a.getMeasuredHeight(), 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
