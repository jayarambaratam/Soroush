package mobi.mmdt.ott.view.main.basenavigation.viewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.viewpager.h */
public class C2333h extends LayoutParams {
    public boolean f7721a;
    public int f7722b;
    float f7723c;
    boolean f7724d;
    int f7725e;
    int f7726f;

    public C2333h() {
        super(-1, -1);
        this.f7723c = 0.0f;
    }

    public C2333h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7723c = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.f7662a);
        this.f7722b = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
    }
}
