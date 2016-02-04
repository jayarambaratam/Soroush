package com.p032a.p033a.p037d.p049d.p050a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.p032a.p033a.p037d.C0598a;
import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p037d.C0727f;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p049d.C0758a;
import com.p032a.p033a.p037d.p049d.p053c.C0763c;
import com.p032a.p033a.p051g.C0737b;
import java.io.File;

/* renamed from: com.a.a.d.d.a.j */
public class C0738j implements C0737b<ParcelFileDescriptor, Bitmap> {
    private final C0739e<File, Bitmap> f2759a;
    private final C0740k f2760b;
    private final C0728b f2761c;
    private final C0676b<ParcelFileDescriptor> f2762d;

    public C0738j(C0605e c0605e, C0598a c0598a) {
        this.f2759a = new C0763c(new C0756y(c0605e, c0598a));
        this.f2760b = new C0740k(c0605e, c0598a);
        this.f2761c = new C0728b();
        this.f2762d = C0758a.m4894b();
    }

    public C0739e<File, Bitmap> m4830a() {
        return this.f2759a;
    }

    public C0739e<ParcelFileDescriptor, Bitmap> m4831b() {
        return this.f2760b;
    }

    public C0676b<ParcelFileDescriptor> m4832c() {
        return this.f2762d;
    }

    public C0727f<Bitmap> m4833d() {
        return this.f2761c;
    }
}
