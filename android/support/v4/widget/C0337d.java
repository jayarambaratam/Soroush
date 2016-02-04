package android.support.v4.widget;

import android.support.v4.view.cb;

/* renamed from: android.support.v4.widget.d */
class C0337d implements Runnable {
    final /* synthetic */ C0332a f1690a;

    private C0337d(C0332a c0332a) {
        this.f1690a = c0332a;
    }

    public void run() {
        if (this.f1690a.f1566o) {
            if (this.f1690a.f1564m) {
                this.f1690a.f1564m = false;
                this.f1690a.f1552a.m3343a();
            }
            C0336c c = this.f1690a.f1552a;
            if (c.m3348c() || !this.f1690a.m3081a()) {
                this.f1690a.f1566o = false;
                return;
            }
            if (this.f1690a.f1565n) {
                this.f1690a.f1565n = false;
                this.f1690a.m3092d();
            }
            c.m3349d();
            this.f1690a.m3101a(c.m3352g(), c.m3353h());
            cb.m2402a(this.f1690a.f1554c, (Runnable) this);
        }
    }
}
