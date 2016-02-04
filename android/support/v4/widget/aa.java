package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class aa extends MarginLayoutParams {
    public int f1569a;
    float f1570b;
    boolean f1571c;
    boolean f1572d;

    public aa(int i, int i2) {
        super(i, i2);
        this.f1569a = 0;
    }

    public aa(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1569a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f1424b);
        this.f1569a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    public aa(aa aaVar) {
        super(aaVar);
        this.f1569a = 0;
        this.f1569a = aaVar.f1569a;
    }

    public aa(LayoutParams layoutParams) {
        super(layoutParams);
        this.f1569a = 0;
    }

    public aa(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f1569a = 0;
    }
}
