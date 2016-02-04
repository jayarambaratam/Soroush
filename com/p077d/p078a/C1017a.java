package com.p077d.p078a;

import android.support.v7.widget.RecyclerView.Adapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: com.d.a.a */
public abstract class C1017a extends RelativeLayout {
    protected TextView f3837a;

    abstract String m6140a(Integer num, Adapter adapter);

    abstract int getIndicatorHeight();

    abstract int getIndicatorWidth();

    abstract int getTextSize();

    void setScroll(float f) {
        float a = ((float) C1025i.m6158a(24 - getIndicatorHeight(), this)) + f;
        if (a < 0.0f) {
            a += (float) C1025i.m6158a(getIndicatorHeight(), this);
            ViewHelper.setScaleY(this, -1.0f);
            ViewHelper.setScaleY(this.f3837a, -1.0f);
            ViewHelper.setY(this, a);
            return;
        }
        ViewHelper.setScaleY(this, 1.0f);
        ViewHelper.setScaleY(this.f3837a, 1.0f);
        ViewHelper.setY(this, a);
    }

    void setTextColour(int i) {
        this.f3837a.setTextColor(i);
    }
}
