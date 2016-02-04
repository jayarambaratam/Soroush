package com.p032a.p033a.p037d.p039b;

import android.os.Handler;
import android.os.Looper;
import com.p032a.p033a.p042j.C0879h;

/* renamed from: com.a.a.d.b.z */
class C0675z {
    private boolean f2698a;
    private final Handler f2699b;

    C0675z() {
        this.f2699b = new Handler(Looper.getMainLooper(), new ab());
    }

    public void m4697a(C0670y<?> c0670y) {
        C0879h.m5307a();
        if (this.f2698a) {
            this.f2699b.obtainMessage(1, c0670y).sendToTarget();
            return;
        }
        this.f2698a = true;
        c0670y.m4680d();
        this.f2698a = false;
    }
}
