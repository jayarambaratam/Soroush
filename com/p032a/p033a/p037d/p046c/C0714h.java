package com.p032a.p033a.p037d.p046c;

import android.os.ParcelFileDescriptor;
import com.p032a.p033a.p037d.p038a.C0586c;
import java.io.InputStream;

/* renamed from: com.a.a.d.c.h */
public class C0714h<A> implements C0677s<A, C0716j> {
    private final C0677s<A, InputStream> f2722a;
    private final C0677s<A, ParcelFileDescriptor> f2723b;

    public C0714h(C0677s<A, InputStream> c0677s, C0677s<A, ParcelFileDescriptor> c0677s2) {
        if (c0677s == null && c0677s2 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.f2722a = c0677s;
        this.f2723b = c0677s2;
    }

    public C0586c<C0716j> m4763a(A a, int i, int i2) {
        C0586c a2 = this.f2722a != null ? this.f2722a.m4700a(a, i, i2) : null;
        C0586c a3 = this.f2723b != null ? this.f2723b.m4700a(a, i, i2) : null;
        return (a2 == null && a3 == null) ? null : new C0715i(a2, a3);
    }
}
