package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

public class dw extends LayoutParams {
    public boolean f1361a;
    public int f1362b;
    float f1363c;
    boolean f1364d;
    int f1365e;
    int f1366f;

    public dw() {
        super(-1, -1);
        this.f1363c = 0.0f;
    }

    public dw(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1363c = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f1236a);
        this.f1362b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
