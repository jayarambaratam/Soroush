package com.p032a.p033a.p037d.p049d.p050a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* renamed from: com.a.a.d.d.a.n */
class C0744n extends ConstantState {
    private static final Paint f2772d;
    final Bitmap f2773a;
    int f2774b;
    Paint f2775c;

    static {
        f2772d = new Paint(6);
    }

    public C0744n(Bitmap bitmap) {
        this.f2775c = f2772d;
        this.f2773a = bitmap;
    }

    C0744n(C0744n c0744n) {
        this(c0744n.f2773a);
        this.f2774b = c0744n.f2774b;
    }

    void m4846a() {
        if (f2772d == this.f2775c) {
            this.f2775c = new Paint(6);
        }
    }

    void m4847a(int i) {
        m4846a();
        this.f2775c.setAlpha(i);
    }

    void m4848a(ColorFilter colorFilter) {
        m4846a();
        this.f2775c.setColorFilter(colorFilter);
    }

    public int getChangingConfigurations() {
        return 0;
    }

    public Drawable newDrawable() {
        return new C0743m(null, this);
    }

    public Drawable newDrawable(Resources resources) {
        return new C0743m(resources, this);
    }
}
