package com.p032a.p033a.p037d.p049d.p057e;

import android.graphics.Bitmap;
import com.p032a.p033a.p037d.C0727f;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p049d.p054d.C0770b;
import java.io.OutputStream;

/* renamed from: com.a.a.d.d.e.f */
public class C0798f implements C0727f<C0793a> {
    private final C0727f<Bitmap> f2890a;
    private final C0727f<C0770b> f2891b;
    private String f2892c;

    public C0798f(C0727f<Bitmap> c0727f, C0727f<C0770b> c0727f2) {
        this.f2890a = c0727f;
        this.f2891b = c0727f2;
    }

    public String m5021a() {
        if (this.f2892c == null) {
            this.f2892c = this.f2890a.m4698a() + this.f2891b.m4698a();
        }
        return this.f2892c;
    }

    public boolean m5022a(C0670y<C0793a> c0670y, OutputStream outputStream) {
        C0793a c0793a = (C0793a) c0670y.m4678b();
        C0670y b = c0793a.m5006b();
        return b != null ? this.f2890a.m4699a(b, outputStream) : this.f2891b.m4699a(c0793a.m5007c(), outputStream);
    }
}
