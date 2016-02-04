package android.support.design.widget;

import android.support.v4.view.cb;

class aq implements Runnable {
    final /* synthetic */ ap f465a;
    private final CoordinatorLayout f466b;
    private final V f467c;

    aq(ap apVar, CoordinatorLayout coordinatorLayout, V v) {
        this.f465a = apVar;
        this.f466b = coordinatorLayout;
        this.f467c = v;
    }

    public void run() {
        if (this.f467c != null && this.f465a.f272b != null && this.f465a.f272b.m3276g()) {
            this.f465a.m228b(this.f466b, this.f467c, this.f465a.f272b.m3272c());
            cb.m2402a(this.f467c, (Runnable) this);
        }
    }
}
