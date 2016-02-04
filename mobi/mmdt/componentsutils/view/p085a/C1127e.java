package mobi.mmdt.componentsutils.view.p085a;

import mobi.mmdt.componentsutils.p079a.p080a.C1104b;

/* renamed from: mobi.mmdt.componentsutils.view.a.e */
class C1127e implements Runnable {
    final /* synthetic */ C1123a f4160a;

    C1127e(C1123a c1123a) {
        this.f4160a = c1123a;
    }

    public void run() {
        try {
            this.f4160a.f4151b.dismiss();
            C1123a.f4149e = null;
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }
}
