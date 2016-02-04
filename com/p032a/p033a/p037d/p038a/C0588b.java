package com.p032a.p033a.p037d.p038a;

import com.p032a.p033a.C0883l;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: com.a.a.d.a.b */
public class C0588b implements C0586c<InputStream> {
    private final byte[] f2520a;
    private final String f2521b;

    public C0588b(byte[] bArr, String str) {
        this.f2520a = bArr;
        this.f2521b = str;
    }

    public /* synthetic */ Object m4448a(C0883l c0883l) {
        return m4450b(c0883l);
    }

    public void m4449a() {
    }

    public InputStream m4450b(C0883l c0883l) {
        return new ByteArrayInputStream(this.f2520a);
    }

    public String m4451b() {
        return this.f2521b;
    }

    public void m4452c() {
    }
}
