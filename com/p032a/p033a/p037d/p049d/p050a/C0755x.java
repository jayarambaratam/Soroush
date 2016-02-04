package com.p032a.p033a.p037d.p049d.p050a;

import android.graphics.Bitmap;
import com.p032a.p033a.p037d.C0598a;
import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p037d.C0727f;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p046c.C0725v;
import com.p032a.p033a.p037d.p049d.p053c.C0763c;
import com.p032a.p033a.p051g.C0737b;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.a.a.d.d.a.x */
public class C0755x implements C0737b<InputStream, Bitmap> {
    private final C0756y f2801a;
    private final C0728b f2802b;
    private final C0725v f2803c;
    private final C0763c<Bitmap> f2804d;

    public C0755x(C0605e c0605e, C0598a c0598a) {
        this.f2803c = new C0725v();
        this.f2801a = new C0756y(c0605e, c0598a);
        this.f2802b = new C0728b();
        this.f2804d = new C0763c(this.f2801a);
    }

    public C0739e<File, Bitmap> m4880a() {
        return this.f2804d;
    }

    public C0739e<InputStream, Bitmap> m4881b() {
        return this.f2801a;
    }

    public C0676b<InputStream> m4882c() {
        return this.f2803c;
    }

    public C0727f<Bitmap> m4883d() {
        return this.f2802b;
    }
}
