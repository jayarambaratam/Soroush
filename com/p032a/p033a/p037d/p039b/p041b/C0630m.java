package com.p032a.p033a.p037d.p039b.p041b;

import android.content.Context;
import java.io.File;

/* renamed from: com.a.a.d.b.b.m */
class C0630m implements C0627j {
    final /* synthetic */ Context f2597a;
    final /* synthetic */ String f2598b;

    C0630m(Context context, String str) {
        this.f2597a = context;
        this.f2598b = str;
    }

    public File m4595a() {
        File cacheDir = this.f2597a.getCacheDir();
        return cacheDir == null ? null : this.f2598b != null ? new File(cacheDir, this.f2598b) : cacheDir;
    }
}
