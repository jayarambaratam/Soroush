package com.p032a.p033a.p037d.p039b.p041b;

import java.io.File;

/* renamed from: com.a.a.d.b.b.i */
public class C0626i implements C0619b {
    private final int f2589a;
    private final C0627j f2590b;

    public C0626i(C0627j c0627j, int i) {
        this.f2589a = i;
        this.f2590b = c0627j;
    }

    public C0618a m4588a() {
        File a = this.f2590b.m4589a();
        return a == null ? null : (a.mkdirs() || (a.exists() && a.isDirectory())) ? C0628k.m4591a(a, this.f2589a) : null;
    }
}
