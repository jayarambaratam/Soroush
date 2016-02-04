package mobi.mmdt.componentsutils.view.p085a;

import mobi.mmdt.componentsutils.p079a.p080a.C1104b;

/* renamed from: mobi.mmdt.componentsutils.view.a.c */
class C1125c implements Runnable {
    final /* synthetic */ boolean f4155a;
    final /* synthetic */ C1123a f4156b;

    C1125c(C1123a c1123a, boolean z) {
        this.f4156b = c1123a;
        this.f4155a = z;
    }

    public void run() {
        try {
            this.f4156b.f4153d.m6354c();
            this.f4156b.f4151b.setCancelable(this.f4155a);
            this.f4156b.f4151b.show();
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }
}
