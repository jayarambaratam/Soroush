package com.p077d.p078a;

/* renamed from: com.d.a.d */
class C1020d extends Thread {
    C1018b f3853a;
    long f3854b;
    boolean f3855c;
    boolean f3856d;
    final /* synthetic */ C1018b f3857e;

    C1020d(C1018b c1018b, C1018b c1018b2) {
        this.f3857e = c1018b;
        this.f3854b = 0;
        this.f3855c = false;
        this.f3856d = false;
        this.f3853a = c1018b2;
    }

    public void run() {
        while (true) {
            try {
                if (this.f3855c && !this.f3856d && this.f3854b <= System.currentTimeMillis()) {
                    this.f3855c = false;
                    this.f3853a.f3842e.runOnUiThread(new C1021e(this));
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
