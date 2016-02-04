package com.p063b.p064a;

/* renamed from: com.b.a.cg */
class cg extends ck {
    public float f3422b;
    public float f3423c;
    final /* synthetic */ cb f3424d;

    public cg(cb cbVar, float f, float f2) {
        this.f3424d = cbVar;
        super(null);
        this.f3422b = f;
        this.f3423c = f2;
    }

    public void m5637a(String str) {
        cb.m5594f("TextSequence render", new Object[0]);
        if (this.f3424d.m5608s()) {
            if (this.f3424d.f3397f.f3432b) {
                this.f3424d.f3392a.drawText(str, this.f3422b, this.f3423c, this.f3424d.f3397f.f3434d);
            }
            if (this.f3424d.f3397f.f3433c) {
                this.f3424d.f3392a.drawText(str, this.f3422b, this.f3423c, this.f3424d.f3397f.f3435e);
            }
        }
        this.f3422b += this.f3424d.f3397f.f3434d.measureText(str);
    }
}
