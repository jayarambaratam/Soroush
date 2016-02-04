package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.p019a.C0369l;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.v7.app.b */
public class C0375b extends MarginLayoutParams {
    public int gravity;

    public C0375b(int i) {
        this(-2, -1, i);
    }

    public C0375b(int i, int i2) {
        super(i, i2);
        this.gravity = 0;
        this.gravity = 8388627;
    }

    public C0375b(int i, int i2, int i3) {
        super(i, i2);
        this.gravity = 0;
        this.gravity = i3;
    }

    public C0375b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gravity = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0369l.ActionBarLayout);
        this.gravity = obtainStyledAttributes.getInt(C0369l.ActionBarLayout_android_layout_gravity, 0);
        obtainStyledAttributes.recycle();
    }

    public C0375b(C0375b c0375b) {
        super(c0375b);
        this.gravity = 0;
        this.gravity = c0375b.gravity;
    }

    public C0375b(LayoutParams layoutParams) {
        super(layoutParams);
        this.gravity = 0;
    }
}
