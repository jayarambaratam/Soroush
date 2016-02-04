package com.cocosw.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

class HeaderLayout extends FrameLayout {
    private int f3742a;

    public HeaderLayout(Context context) {
        super(context);
        this.f3742a = 1;
    }

    public HeaderLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3742a = 1;
    }

    public HeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3742a = 1;
    }

    public void m6055a(int i) {
        this.f3742a = i;
    }

    protected void onMeasure(int i, int i2) {
        if (this.f3742a != 1) {
            i = MeasureSpec.makeMeasureSpec(this.f3742a, MeasureSpec.getMode(i));
        }
        super.onMeasure(i, i2);
    }
}
