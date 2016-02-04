package com.p063b.p064a;

import android.graphics.Path;

/* renamed from: com.b.a.cf */
class cf extends cg {
    final /* synthetic */ cb f3425a;
    private Path f3426f;

    public cf(cb cbVar, Path path, float f, float f2) {
        this.f3425a = cbVar;
        super(cbVar, f, f2);
        this.f3426f = path;
    }

    public void m5638a(String str) {
        if (r1.m5608s()) {
            if (this.f3425a.f3397f.f3432b) {
                this.f3425a.f3392a.drawTextOnPath(str, this.f3426f, this.b, this.c, this.f3425a.f3397f.f3434d);
            }
            if (this.f3425a.f3397f.f3433c) {
                this.f3425a.f3392a.drawTextOnPath(str, this.f3426f, this.b, this.c, this.f3425a.f3397f.f3435e);
            }
        }
        this.b += this.f3425a.f3397f.f3434d.measureText(str);
    }
}
