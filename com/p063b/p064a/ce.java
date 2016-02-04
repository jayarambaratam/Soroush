package com.p063b.p064a;

import android.graphics.Path;

/* renamed from: com.b.a.ce */
class ce implements ak {
    Path f3417a;
    float f3418b;
    float f3419c;
    final /* synthetic */ cb f3420d;

    public ce(cb cbVar, aj ajVar) {
        this.f3420d = cbVar;
        this.f3417a = new Path();
        ajVar.m5489a(this);
    }

    public Path m5628a() {
        return this.f3417a;
    }

    public void m5629a(float f, float f2) {
        this.f3417a.moveTo(f, f2);
        this.f3418b = f;
        this.f3419c = f2;
    }

    public void m5630a(float f, float f2, float f3, float f4) {
        this.f3417a.quadTo(f, f2, f3, f4);
        this.f3418b = f3;
        this.f3419c = f4;
    }

    public void m5631a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f3417a.cubicTo(f, f2, f3, f4, f5, f6);
        this.f3418b = f5;
        this.f3419c = f6;
    }

    public void m5632a(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        cb.m5579b(this.f3418b, this.f3419c, f, f2, f3, z, z2, f4, f5, this);
        this.f3418b = f4;
        this.f3419c = f5;
    }

    public void m5633b() {
        this.f3417a.close();
    }

    public void m5634b(float f, float f2) {
        this.f3417a.lineTo(f, f2);
        this.f3418b = f;
        this.f3419c = f2;
    }
}
