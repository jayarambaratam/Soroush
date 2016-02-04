package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import mobi.mmdt.ott.C1317h;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.f */
public class C2462f extends C2461j {
    private int f8019i;
    private int f8020j;

    public C2462f(int i, int i2) {
        super(i, i2);
    }

    public C2462f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1317h.superslim_GridSLM);
        this.f8019i = obtainStyledAttributes.getInt(1, -1);
        this.f8020j = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        obtainStyledAttributes.recycle();
    }

    @Deprecated
    public C2462f(LayoutParams layoutParams) {
        super(layoutParams);
        m10777c(layoutParams);
    }

    @Deprecated
    public C2462f(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        m10777c(marginLayoutParams);
    }

    public static C2462f m10776a(LayoutParams layoutParams) {
        if (layoutParams != null) {
            return layoutParams instanceof MarginLayoutParams ? new C2462f((MarginLayoutParams) layoutParams) : new C2462f(layoutParams);
        } else {
            Log.w("SuperSLiM", "Null value passed in call to GridSLM.LayoutParams.from().");
            return new C2462f(-2, -2);
        }
    }

    private void m10777c(LayoutParams layoutParams) {
        if (layoutParams instanceof C2462f) {
            C2462f c2462f = (C2462f) layoutParams;
            this.f8019i = c2462f.f8019i;
            this.f8020j = c2462f.f8020j;
            return;
        }
        this.f8019i = -1;
        this.f8020j = -1;
    }

    public int m10778a() {
        return this.f8020j;
    }

    public int m10779b() {
        return this.f8019i;
    }
}
