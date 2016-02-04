package com.p032a.p033a.p037d.p049d.p054d;

import android.graphics.Bitmap;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p049d.p050a.C0729c;

/* renamed from: com.a.a.d.d.d.f */
public class C0774f implements C0730g<C0770b> {
    private final C0730g<Bitmap> f2844a;
    private final C0605e f2845b;

    public C0774f(C0730g<Bitmap> c0730g, C0605e c0605e) {
        this.f2844a = c0730g;
        this.f2845b = c0605e;
    }

    public C0670y<C0770b> m4939a(C0670y<C0770b> c0670y, int i, int i2) {
        C0770b c0770b = (C0770b) c0670y.m4678b();
        Bitmap b = ((C0770b) c0670y.m4678b()).m4927b();
        Bitmap bitmap = (Bitmap) this.f2844a.m4802a(new C0729c(b, this.f2845b), i, i2).m4678b();
        return !bitmap.equals(b) ? new C0773e(new C0770b(c0770b, bitmap, this.f2844a)) : c0670y;
    }

    public String m4940a() {
        return this.f2844a.m4803a();
    }
}
