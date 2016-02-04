package android.support.v4.p012b;

import android.os.Process;

/* renamed from: android.support.v4.b.z */
class C0176z extends af<Params, Result> {
    final /* synthetic */ C0156x f1091a;

    C0176z(C0156x c0156x) {
        this.f1091a = c0156x;
        super();
    }

    public Result call() {
        this.f1091a.f1075i.set(true);
        Process.setThreadPriority(10);
        return this.f1091a.m1499d(this.f1091a.m1502a(this.b));
    }
}
