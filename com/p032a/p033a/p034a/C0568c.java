package com.p032a.p033a.p034a;

import java.io.File;
import java.io.IOException;

/* renamed from: com.a.a.a.c */
public final class C0568c {
    final /* synthetic */ C0566a f2356a;
    private final C0569d f2357b;
    private final boolean[] f2358c;
    private boolean f2359d;

    private C0568c(C0566a c0566a, C0569d c0569d) {
        this.f2356a = c0566a;
        this.f2357b = c0569d;
        this.f2358c = c0569d.f2365f ? null : new boolean[c0566a.f2348h];
    }

    public File m4254a(int i) {
        File b;
        synchronized (this.f2356a) {
            if (this.f2357b.f2366g != this) {
                throw new IllegalStateException();
            }
            if (!this.f2357b.f2365f) {
                this.f2358c[i] = true;
            }
            b = this.f2357b.m4271b(i);
            if (!this.f2356a.f2342b.exists()) {
                this.f2356a.f2342b.mkdirs();
            }
        }
        return b;
    }

    public void m4255a() {
        this.f2356a.m4232a(this, true);
        this.f2359d = true;
    }

    public void m4256b() {
        this.f2356a.m4232a(this, false);
    }

    public void m4257c() {
        if (!this.f2359d) {
            try {
                m4256b();
            } catch (IOException e) {
            }
        }
    }
}
