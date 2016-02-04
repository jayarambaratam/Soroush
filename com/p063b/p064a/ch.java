package com.p063b.p064a;

import android.graphics.Path;

/* renamed from: com.b.a.ch */
class ch extends ck {
    public float f3427a;
    public float f3428b;
    public Path f3429c;
    final /* synthetic */ cb f3430d;

    public ch(cb cbVar, float f, float f2, Path path) {
        this.f3430d = cbVar;
        super(null);
        this.f3427a = f;
        this.f3428b = f2;
        this.f3429c = path;
    }

    public void m5639a(String str) {
        if (this.f3430d.m5608s()) {
            Path path = new Path();
            this.f3430d.f3397f.f3434d.getTextPath(str, 0, str.length(), this.f3427a, this.f3428b, path);
            this.f3429c.addPath(path);
        }
        this.f3427a += this.f3430d.f3397f.f3434d.measureText(str);
    }

    public boolean m5640a(bt btVar) {
        if (!(btVar instanceof bu)) {
            return true;
        }
        cb.m5591d("Using <textPath> elements in a clip path is not supported.", new Object[0]);
        return false;
    }
}
