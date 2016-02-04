package mobi.mmdt.ott.view.components.imageslider.Tricks;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.Tricks.h */
public class C1830h extends LayoutParams {
    public boolean f5949a;
    public int f5950b;
    float f5951c;
    boolean f5952d;
    int f5953e;
    int f5954f;

    public C1830h() {
        super(-1, -1);
        this.f5951c = 0.0f;
    }

    public C1830h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5951c = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPagerEx.f5889a);
        this.f5950b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
