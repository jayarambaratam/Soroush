package com.p032a.p033a.p037d.p049d.p057e;

import android.graphics.Bitmap;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p049d.p054d.C0770b;

/* renamed from: com.a.a.d.d.e.a */
public class C0793a {
    private final C0670y<C0770b> f2879a;
    private final C0670y<Bitmap> f2880b;

    public C0793a(C0670y<Bitmap> c0670y, C0670y<C0770b> c0670y2) {
        if (c0670y != null && c0670y2 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        } else if (c0670y == null && c0670y2 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        } else {
            this.f2880b = c0670y;
            this.f2879a = c0670y2;
        }
    }

    public int m5005a() {
        return this.f2880b != null ? this.f2880b.m4679c() : this.f2879a.m4679c();
    }

    public C0670y<Bitmap> m5006b() {
        return this.f2880b;
    }

    public C0670y<C0770b> m5007c() {
        return this.f2879a;
    }
}
