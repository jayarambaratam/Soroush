package com.p032a.p033a.p034a;

import java.util.concurrent.Callable;

/* renamed from: com.a.a.a.b */
class C0567b implements Callable<Void> {
    final /* synthetic */ C0566a f2355a;

    C0567b(C0566a c0566a) {
        this.f2355a = c0566a;
    }

    public Void m4251a() {
        synchronized (this.f2355a) {
            if (this.f2355a.f2350j == null) {
            } else {
                this.f2355a.m4246g();
                if (this.f2355a.m4243e()) {
                    this.f2355a.m4239d();
                    this.f2355a.f2352l = 0;
                }
            }
        }
        return null;
    }

    public /* synthetic */ Object call() {
        return m4251a();
    }
}
