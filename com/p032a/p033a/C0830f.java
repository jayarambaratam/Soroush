package com.p032a.p033a;

import com.p032a.p033a.p045h.C0864f;

/* renamed from: com.a.a.f */
class C0830f implements Runnable {
    final /* synthetic */ C0864f f2936a;
    final /* synthetic */ C0574e f2937b;

    C0830f(C0574e c0574e, C0864f c0864f) {
        this.f2937b = c0574e;
        this.f2936a = c0864f;
    }

    public void run() {
        if (!this.f2936a.isCancelled()) {
            this.f2937b.m4285a(this.f2936a);
        }
    }
}
