package com.p032a.p033a.p045h.p056b;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* renamed from: com.a.a.h.b.j */
class C0857j extends ConstantState {
    private final ConstantState f2972a;
    private final int f2973b;

    C0857j(ConstantState constantState, int i) {
        this.f2972a = constantState;
        this.f2973b = i;
    }

    C0857j(C0857j c0857j) {
        this(c0857j.f2972a, c0857j.f2973b);
    }

    public int getChangingConfigurations() {
        return 0;
    }

    public Drawable newDrawable() {
        return newDrawable(null);
    }

    public Drawable newDrawable(Resources resources) {
        return new C0856i(this, null, resources);
    }
}
