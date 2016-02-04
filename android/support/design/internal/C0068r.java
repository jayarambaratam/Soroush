package android.support.design.internal;

import android.graphics.Rect;
import android.support.v4.view.bs;
import android.support.v4.view.cb;
import android.support.v4.view.ff;
import android.view.View;

/* renamed from: android.support.design.internal.r */
class C0068r implements bs {
    final /* synthetic */ C0067q f263a;

    C0068r(C0067q c0067q) {
        this.f263a = c0067q;
    }

    public ff m197a(View view, ff ffVar) {
        if (this.f263a.f261b == null) {
            this.f263a.f261b = new Rect();
        }
        this.f263a.f261b.set(ffVar.m2897a(), ffVar.m2899b(), ffVar.m2900c(), ffVar.m2901d());
        C0067q c0067q = this.f263a;
        boolean z = this.f263a.f261b.isEmpty() || this.f263a.f260a == null;
        c0067q.setWillNotDraw(z);
        cb.m2417d(this.f263a);
        return ffVar.m2903f();
    }
}
