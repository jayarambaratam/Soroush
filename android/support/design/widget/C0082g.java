package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.C0070k;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout.LayoutParams;

/* renamed from: android.support.design.widget.g */
public class C0082g extends LayoutParams {
    int f599a;
    Interpolator f600b;

    public C0082g(int i, int i2) {
        super(i, i2);
        this.f599a = 1;
    }

    public C0082g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f599a = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0070k.AppBarLayout_LayoutParams);
        this.f599a = obtainStyledAttributes.getInt(C0070k.AppBarLayout_LayoutParams_layout_scrollFlags, 0);
        if (obtainStyledAttributes.hasValue(C0070k.AppBarLayout_LayoutParams_layout_scrollInterpolator)) {
            this.f600b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(C0070k.AppBarLayout_LayoutParams_layout_scrollInterpolator, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public C0082g(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f599a = 1;
    }

    public C0082g(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f599a = 1;
    }

    public C0082g(LayoutParams layoutParams) {
        super(layoutParams);
        this.f599a = 1;
    }

    public int m767a() {
        return this.f599a;
    }

    public Interpolator m768b() {
        return this.f600b;
    }
}
