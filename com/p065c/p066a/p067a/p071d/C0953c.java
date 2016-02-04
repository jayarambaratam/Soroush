package com.p065c.p066a.p067a.p071d;

import com.p065c.p066a.p067a.C0954d;
import com.p065c.p066a.p067a.p072e.C0956b;
import java.util.concurrent.TimeUnit;

/* renamed from: com.c.a.a.d.c */
class C0953c implements Runnable {
    private final C0952b f3632a;
    private final C0951a f3633b;
    private boolean f3634c;

    public C0953c(C0952b c0952b, C0951a c0951a) {
        this.f3634c = false;
        this.f3633b = c0951a;
        this.f3632a = c0952b;
    }

    public void run() {
        boolean b;
        do {
            try {
                if (C0956b.m5906a()) {
                    if (this.f3634c) {
                        C0956b.m5904a("re-running consumer %s", Thread.currentThread().getName());
                    } else {
                        C0956b.m5904a("starting consumer %s", Thread.currentThread().getName());
                        this.f3634c = true;
                    }
                }
                C0954d a;
                do {
                    a = this.f3632a.m5883a() ? this.f3632a.m5881a(this.f3633b.f3629f, TimeUnit.SECONDS) : null;
                    if (a != null) {
                        this.f3633b.m5870a(a);
                        if (a.m5889a(a.m5893d())) {
                            this.f3632a.m5885b(a);
                        } else {
                            this.f3632a.m5882a(a);
                        }
                        this.f3633b.m5874b(a);
                        continue;
                    }
                } while (a != null);
                b = this.f3633b.m5875b();
                if (C0956b.m5906a()) {
                    if (b) {
                        C0956b.m5904a("finishing consumer %s", Thread.currentThread().getName());
                        continue;
                    } else {
                        C0956b.m5904a("didn't allow me to die, re-running %s", Thread.currentThread().getName());
                        continue;
                    }
                }
            } catch (Throwable th) {
                boolean b2 = this.f3633b.m5875b();
                if (C0956b.m5906a()) {
                    if (b2) {
                        C0956b.m5904a("finishing consumer %s", Thread.currentThread().getName());
                    } else {
                        C0956b.m5904a("didn't allow me to die, re-running %s", Thread.currentThread().getName());
                    }
                }
            }
        } while (!b);
    }
}
