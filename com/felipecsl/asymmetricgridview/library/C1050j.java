package com.felipecsl.asymmetricgridview.library;

/* renamed from: com.felipecsl.asymmetricgridview.library.j */
class C1050j implements Runnable {
    final /* synthetic */ Runnable f3941a;
    final /* synthetic */ C1049i f3942b;

    C1050j(C1049i c1049i, Runnable runnable) {
        this.f3942b = c1049i;
        this.f3941a = runnable;
    }

    public void run() {
        try {
            this.f3941a.run();
        } finally {
            this.f3942b.m6241a();
        }
    }
}
