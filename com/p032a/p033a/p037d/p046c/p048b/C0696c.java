package com.p032a.p033a.p037d.p046c.p048b;

import com.p032a.p033a.p037d.p038a.C0586c;
import com.p032a.p033a.p037d.p038a.C0588b;
import java.io.InputStream;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: com.a.a.d.c.b.c */
public class C0696c implements C0695g<byte[]> {
    private final String f2709a;

    public C0696c() {
        this(BuildConfig.FLAVOR);
    }

    @Deprecated
    public C0696c(String str) {
        this.f2709a = str;
    }

    public C0586c<InputStream> m4732a(byte[] bArr, int i, int i2) {
        return new C0588b(bArr, this.f2709a);
    }
}
