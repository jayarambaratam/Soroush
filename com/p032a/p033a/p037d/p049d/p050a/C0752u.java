package com.p032a.p033a.p037d.p049d.p050a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p037d.C0727f;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p046c.C0716j;
import com.p032a.p033a.p037d.p046c.C0717k;
import com.p032a.p033a.p051g.C0737b;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.a.a.d.d.a.u */
public class C0752u implements C0737b<C0716j, Bitmap> {
    private final C0751t f2792a;
    private final C0739e<File, Bitmap> f2793b;
    private final C0727f<Bitmap> f2794c;
    private final C0717k f2795d;

    public C0752u(C0737b<InputStream, Bitmap> c0737b, C0737b<ParcelFileDescriptor, Bitmap> c0737b2) {
        this.f2794c = c0737b.m4829d();
        this.f2795d = new C0717k(c0737b.m4828c(), c0737b2.m4828c());
        this.f2793b = c0737b.m4826a();
        this.f2792a = new C0751t(c0737b.m4827b(), c0737b2.m4827b());
    }

    public C0739e<File, Bitmap> m4873a() {
        return this.f2793b;
    }

    public C0739e<C0716j, Bitmap> m4874b() {
        return this.f2792a;
    }

    public C0676b<C0716j> m4875c() {
        return this.f2795d;
    }

    public C0727f<Bitmap> m4876d() {
        return this.f2794c;
    }
}
