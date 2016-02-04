package com.p032a.p033a.p037d.p049d.p057e;

import android.graphics.Bitmap;
import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p037d.C0727f;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p046c.C0716j;
import com.p032a.p033a.p037d.p049d.p053c.C0763c;
import com.p032a.p033a.p037d.p049d.p054d.C0770b;
import com.p032a.p033a.p051g.C0737b;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.a.a.d.d.e.i */
public class C0801i implements C0737b<C0716j, C0793a> {
    private final C0739e<File, C0793a> f2896a;
    private final C0739e<C0716j, C0793a> f2897b;
    private final C0727f<C0793a> f2898c;
    private final C0676b<C0716j> f2899d;

    public C0801i(C0737b<C0716j, Bitmap> c0737b, C0737b<InputStream, C0770b> c0737b2, C0605e c0605e) {
        C0739e c0795c = new C0795c(c0737b.m4827b(), c0737b2.m4827b(), c0605e);
        this.f2896a = new C0763c(new C0799g(c0795c));
        this.f2897b = c0795c;
        this.f2898c = new C0798f(c0737b.m4829d(), c0737b2.m4829d());
        this.f2899d = c0737b.m4828c();
    }

    public C0739e<File, C0793a> m5029a() {
        return this.f2896a;
    }

    public C0739e<C0716j, C0793a> m5030b() {
        return this.f2897b;
    }

    public C0676b<C0716j> m5031c() {
        return this.f2899d;
    }

    public C0727f<C0793a> m5032d() {
        return this.f2898c;
    }
}
