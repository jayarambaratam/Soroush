package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.C0070k;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;

/* renamed from: android.support.design.widget.n */
public class C0089n extends LayoutParams {
    int f660a;
    float f661b;

    public C0089n(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f660a = 0;
        this.f661b = 0.5f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.CollapsingAppBarLayout_LayoutParams);
        this.f660a = obtainStyledAttributes.getInt(C0070k.CollapsingAppBarLayout_LayoutParams_layout_collapseMode, 0);
        m818a(obtainStyledAttributes.getFloat(C0070k.f264xad49a364, 0.5f));
        obtainStyledAttributes.recycle();
    }

    public C0089n(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f660a = 0;
        this.f661b = 0.5f;
    }

    public C0089n(LayoutParams layoutParams) {
        super(layoutParams);
        this.f660a = 0;
        this.f661b = 0.5f;
    }

    public void m818a(float f) {
        this.f661b = f;
    }
}
