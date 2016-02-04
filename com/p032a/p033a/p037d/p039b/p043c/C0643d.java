package com.p032a.p033a.p037d.p039b.p043c;

import android.os.Process;

/* renamed from: com.a.a.d.b.c.d */
class C0643d extends Thread {
    final /* synthetic */ C0642c f2612a;

    C0643d(C0642c c0642c, Runnable runnable, String str) {
        this.f2612a = c0642c;
        super(runnable, str);
    }

    public void run() {
        Process.setThreadPriority(10);
        super.run();
    }
}
