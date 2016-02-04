package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class bs extends MarginLayoutParams {
    private static final int[] f1633e;
    public float f1634a;
    boolean f1635b;
    boolean f1636c;
    Paint f1637d;

    static {
        f1633e = new int[]{16843137};
    }

    public bs() {
        super(-1, -1);
        this.f1634a = 0.0f;
    }

    public bs(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1634a = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1633e);
        this.f1634a = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public bs(LayoutParams layoutParams) {
        super(layoutParams);
        this.f1634a = 0.0f;
    }

    public bs(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f1634a = 0.0f;
    }
}
