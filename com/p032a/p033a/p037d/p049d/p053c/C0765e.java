package com.p032a.p033a.p037d.p049d.p053c;

import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p037d.C0727f;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p046c.C0725v;
import com.p032a.p033a.p037d.p049d.C0759b;
import com.p032a.p033a.p051g.C0737b;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.a.a.d.d.c.e */
public class C0765e implements C0737b<InputStream, File> {
    private static final C0767g f2815a;
    private final C0739e<File, File> f2816b;
    private final C0676b<InputStream> f2817c;

    static {
        f2815a = new C0767g();
    }

    public C0765e() {
        this.f2816b = new C0760a();
        this.f2817c = new C0725v();
    }

    public C0739e<File, File> m4911a() {
        return this.f2816b;
    }

    public C0739e<InputStream, File> m4912b() {
        return f2815a;
    }

    public C0676b<InputStream> m4913c() {
        return this.f2817c;
    }

    public C0727f<File> m4914d() {
        return C0759b.m4897b();
    }
}
