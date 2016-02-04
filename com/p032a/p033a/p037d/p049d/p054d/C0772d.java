package com.p032a.p033a.p037d.p049d.p054d;

import android.content.Context;
import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p037d.C0727f;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p046c.C0725v;
import com.p032a.p033a.p037d.p049d.p053c.C0763c;
import com.p032a.p033a.p051g.C0737b;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.a.a.d.d.d.d */
public class C0772d implements C0737b<InputStream, C0770b> {
    private final C0787p f2840a;
    private final C0790s f2841b;
    private final C0725v f2842c;
    private final C0763c<C0770b> f2843d;

    public C0772d(Context context, C0605e c0605e) {
        this.f2840a = new C0787p(context, c0605e);
        this.f2843d = new C0763c(this.f2840a);
        this.f2841b = new C0790s(c0605e);
        this.f2842c = new C0725v();
    }

    public C0739e<File, C0770b> m4933a() {
        return this.f2843d;
    }

    public C0739e<InputStream, C0770b> m4934b() {
        return this.f2840a;
    }

    public C0676b<InputStream> m4935c() {
        return this.f2842c;
    }

    public C0727f<C0770b> m4936d() {
        return this.f2841b;
    }
}
