package com.p063b.p064a;

import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

/* renamed from: com.b.a.cj */
class cj extends ck {
    float f3441a;
    float f3442b;
    RectF f3443c;
    final /* synthetic */ cb f3444d;

    public cj(cb cbVar, float f, float f2) {
        this.f3444d = cbVar;
        super(null);
        this.f3443c = new RectF();
        this.f3441a = f;
        this.f3442b = f2;
    }

    public void m5641a(String str) {
        if (this.f3444d.m5608s()) {
            Rect rect = new Rect();
            this.f3444d.f3397f.f3434d.getTextBounds(str, 0, str.length(), rect);
            RectF rectF = new RectF(rect);
            rectF.offset(this.f3441a, this.f3442b);
            this.f3443c.union(rectF);
        }
        this.f3441a += this.f3444d.f3397f.f3434d.measureText(str);
    }

    public boolean m5642a(bt btVar) {
        if (!(btVar instanceof bu)) {
            return true;
        }
        bi a = btVar.u.m5795a(((bu) btVar).f3363a);
        if (a == null) {
            cb.m5592e("TextPath path reference '%s' not found", r0.f3363a);
            return false;
        }
        ai aiVar = (ai) a;
        Path a2 = new ce(this.f3444d, aiVar.f3243a).m5628a();
        if (aiVar.e != null) {
            a2.transform(aiVar.e);
        }
        RectF rectF = new RectF();
        a2.computeBounds(rectF, true);
        this.f3443c.union(rectF);
        return false;
    }
}
