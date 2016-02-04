package mobi.mmdt.componentsutils.view.p085a;

import mobi.mmdt.componentsutils.p079a.p080a.C1104b;

/* renamed from: mobi.mmdt.componentsutils.view.a.d */
class C1126d implements Runnable {
    final /* synthetic */ int f4157a;
    final /* synthetic */ boolean f4158b;
    final /* synthetic */ C1123a f4159c;

    C1126d(C1123a c1123a, int i, boolean z) {
        this.f4159c = c1123a;
        this.f4157a = i;
        this.f4158b = z;
    }

    public void run() {
        try {
            this.f4159c.f4153d.m6354c();
            this.f4159c.f4152c.setText(this.f4157a);
            this.f4159c.f4151b.setCancelable(this.f4158b);
            this.f4159c.f4151b.show();
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }
}
