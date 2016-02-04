package com.dd.morphingbutton;

import android.graphics.drawable.GradientDrawable;

/* renamed from: com.dd.morphingbutton.n */
public class C1039n {
    private int f3913a;
    private int f3914b;
    private GradientDrawable f3915c;
    private float f3916d;
    private int f3917e;

    public C1039n(GradientDrawable gradientDrawable) {
        this.f3915c = gradientDrawable;
    }

    public int m6214a() {
        return this.f3913a;
    }

    public void m6215a(float f) {
        this.f3916d = f;
        this.f3915c.setCornerRadius(f);
    }

    public void m6216a(int i) {
        this.f3913a = i;
        this.f3915c.setStroke(i, m6217b());
    }

    public int m6217b() {
        return this.f3914b;
    }

    public void m6218b(int i) {
        this.f3914b = i;
        this.f3915c.setStroke(m6214a(), i);
    }

    public GradientDrawable m6219c() {
        return this.f3915c;
    }

    public void m6220c(int i) {
        this.f3917e = i;
        this.f3915c.setColor(i);
    }
}
