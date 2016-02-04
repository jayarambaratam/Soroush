package com.dd.morphingbutton;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

public class MorphingButton extends Button {
    protected boolean f3864a;
    private C1034i f3865b;
    private int f3866c;
    private int f3867d;
    private int f3868e;
    private int f3869f;
    private int f3870g;
    private int f3871h;
    private C1039n f3872i;
    private C1039n f3873j;

    public MorphingButton(Context context) {
        super(context);
        m6160a();
    }

    public MorphingButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6160a();
    }

    public MorphingButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6160a();
    }

    private C1039n m6159a(int i, int i2, int i3) {
        C1039n c1039n = new C1039n(new GradientDrawable());
        c1039n.m6219c().setShape(0);
        c1039n.m6220c(i);
        c1039n.m6215a((float) i2);
        c1039n.m6218b(i);
        c1039n.m6216a(i3);
        return c1039n;
    }

    private void m6160a() {
        this.f3865b = new C1034i();
        this.f3865b.f3897a = getPaddingLeft();
        this.f3865b.f3898b = getPaddingRight();
        this.f3865b.f3899c = getPaddingTop();
        this.f3865b.f3900d = getPaddingBottom();
        Resources resources = getResources();
        int dimension = (int) resources.getDimension(C1038m.mb_corner_radius_2);
        int color = resources.getColor(C1037l.mb_blue);
        int color2 = resources.getColor(C1037l.mb_blue_dark);
        Drawable stateListDrawable = new StateListDrawable();
        this.f3872i = m6159a(color, dimension, 0);
        this.f3873j = m6159a(color2, dimension, 0);
        this.f3868e = color;
        this.f3871h = color;
        this.f3869f = dimension;
        stateListDrawable.addState(new int[]{16842919}, this.f3873j.m6219c());
        stateListDrawable.addState(StateSet.WILD_CARD, this.f3872i.m6219c());
        setBackgroundCompat(stateListDrawable);
    }

    private void m6162b(C1035j c1035j) {
        this.f3864a = true;
        setText(null);
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        setPadding(this.f3865b.f3897a, this.f3865b.f3899c, this.f3865b.f3898b, this.f3865b.f3900d);
        new C1026a(C1031f.m6170a(this).m6186a(this.f3868e, c1035j.f3905d).m6188b(this.f3869f, c1035j.f3902a).m6191e(this.f3870g, c1035j.f3909h).m6192f(this.f3871h, c1035j.f3910i).m6189c(getHeight(), c1035j.f3904c).m6190d(getWidth(), c1035j.f3903b).m6185a(c1035j.f3907f).m6187a(new C1032g(this, c1035j))).m6167a();
    }

    private void m6163c(C1035j c1035j) {
        this.f3872i.m6220c(c1035j.f3905d);
        this.f3872i.m6215a((float) c1035j.f3902a);
        this.f3872i.m6218b(c1035j.f3910i);
        this.f3872i.m6216a(c1035j.f3909h);
        if (!(c1035j.f3903b == 0 || c1035j.f3904c == 0)) {
            LayoutParams layoutParams = getLayoutParams();
            layoutParams.width = c1035j.f3903b;
            layoutParams.height = c1035j.f3904c;
            setLayoutParams(layoutParams);
        }
        m6164d(c1035j);
    }

    private void m6164d(C1035j c1035j) {
        this.f3864a = false;
        if (c1035j.f3908g != 0 && c1035j.f3911j != null) {
            setIconLeft(c1035j.f3908g);
            setText(c1035j.f3911j);
        } else if (c1035j.f3908g != 0) {
            setIcon(c1035j.f3908g);
        } else if (c1035j.f3911j != null) {
            setText(c1035j.f3911j);
        }
        if (c1035j.f3912k != null) {
            c1035j.f3912k.m6168a();
        }
    }

    private void setBackgroundCompat(Drawable drawable) {
        if (VERSION.SDK_INT <= 16) {
            setBackgroundDrawable(drawable);
        } else {
            setBackground(drawable);
        }
    }

    public void m6165a(C1035j c1035j) {
        if (!this.f3864a) {
            this.f3873j.m6220c(c1035j.f3906e);
            this.f3873j.m6215a((float) c1035j.f3902a);
            this.f3873j.m6218b(c1035j.f3910i);
            this.f3873j.m6216a(c1035j.f3909h);
            if (c1035j.f3907f == 0) {
                m6163c(c1035j);
            } else {
                m6162b(c1035j);
            }
            this.f3868e = c1035j.f3905d;
            this.f3869f = c1035j.f3902a;
            this.f3870g = c1035j.f3909h;
            this.f3871h = c1035j.f3910i;
        }
    }

    public C1039n getDrawableNormal() {
        return this.f3872i;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f3866c == 0 && this.f3867d == 0 && i != 0 && i2 != 0) {
            this.f3866c = getHeight();
            this.f3867d = getWidth();
        }
    }

    public void setIcon(int i) {
        post(new C1033h(this, i));
    }

    public void setIconLeft(int i) {
        setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
    }
}
