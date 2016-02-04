package com.p032a.p033a.p037d.p039b;

import com.p032a.p033a.p037d.p039b.p041b.C0618a;
import com.p032a.p033a.p037d.p039b.p041b.C0619b;
import com.p032a.p033a.p037d.p039b.p041b.C0621d;

/* renamed from: com.a.a.d.b.h */
class C0657h implements C0639b {
    private final C0619b f2644a;
    private volatile C0618a f2645b;

    public C0657h(C0619b c0619b) {
        this.f2644a = c0619b;
    }

    public C0618a m4654a() {
        if (this.f2645b == null) {
            synchronized (this) {
                if (this.f2645b == null) {
                    this.f2645b = this.f2644a.m4579a();
                }
                if (this.f2645b == null) {
                    this.f2645b = new C0621d();
                }
            }
        }
        return this.f2645b;
    }
}
