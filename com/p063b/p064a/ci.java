package com.p063b.p064a;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;

/* renamed from: com.b.a.ci */
class ci implements Cloneable {
    public ar f3431a;
    public boolean f3432b;
    public boolean f3433c;
    public Paint f3434d;
    public Paint f3435e;
    public C0930o f3436f;
    public C0930o f3437g;
    public boolean f3438h;
    public boolean f3439i;
    final /* synthetic */ cb f3440j;

    public ci(cb cbVar) {
        this.f3440j = cbVar;
        this.f3434d = new Paint();
        this.f3434d.setFlags(385);
        this.f3434d.setStyle(Style.FILL);
        this.f3434d.setTypeface(Typeface.DEFAULT);
        this.f3435e = new Paint();
        this.f3435e.setFlags(385);
        this.f3435e.setStyle(Style.STROKE);
        this.f3435e.setTypeface(Typeface.DEFAULT);
        this.f3431a = ar.m5497a();
    }

    protected Object clone() {
        try {
            ci ciVar = (ci) super.clone();
            ciVar.f3431a = (ar) this.f3431a.clone();
            ciVar.f3434d = new Paint(this.f3434d);
            ciVar.f3435e = new Paint(this.f3435e);
            return ciVar;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }
}
