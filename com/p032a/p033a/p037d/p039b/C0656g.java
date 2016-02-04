package com.p032a.p033a.p037d.p039b;

import com.p032a.p033a.p037d.C0667c;
import java.util.concurrent.ExecutorService;

/* renamed from: com.a.a.d.b.g */
class C0656g {
    private final ExecutorService f2641a;
    private final ExecutorService f2642b;
    private final C0653p f2643c;

    public C0656g(ExecutorService executorService, ExecutorService executorService2, C0653p c0653p) {
        this.f2641a = executorService;
        this.f2642b = executorService2;
        this.f2643c = c0653p;
    }

    public C0663l m4653a(C0667c c0667c, boolean z) {
        return new C0663l(c0667c, this.f2641a, this.f2642b, z, this.f2643c);
    }
}
