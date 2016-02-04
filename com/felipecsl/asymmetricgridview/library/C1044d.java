package com.felipecsl.asymmetricgridview.library;

import android.os.Process;

/* renamed from: com.felipecsl.asymmetricgridview.library.d */
class C1044d extends C1043l<Params, Result> {
    final /* synthetic */ C1041b f3934a;

    C1044d(C1041b c1041b) {
        this.f3934a = c1041b;
        super();
    }

    public Result call() {
        this.f3934a.f3931n.set(true);
        Process.setThreadPriority(10);
        return this.f3934a.m6229d(this.f3934a.m6232a(this.b));
    }
}
