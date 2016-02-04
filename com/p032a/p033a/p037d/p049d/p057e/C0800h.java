package com.p032a.p033a.p037d.p049d.p057e;

import android.graphics.Bitmap;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p049d.p054d.C0770b;
import com.p032a.p033a.p037d.p049d.p054d.C0774f;

/* renamed from: com.a.a.d.d.e.h */
public class C0800h implements C0730g<C0793a> {
    private final C0730g<Bitmap> f2894a;
    private final C0730g<C0770b> f2895b;

    public C0800h(C0605e c0605e, C0730g<Bitmap> c0730g) {
        this((C0730g) c0730g, new C0774f(c0730g, c0605e));
    }

    C0800h(C0730g<Bitmap> c0730g, C0730g<C0770b> c0730g2) {
        this.f2894a = c0730g;
        this.f2895b = c0730g2;
    }

    public C0670y<C0793a> m5027a(C0670y<C0793a> c0670y, int i, int i2) {
        C0670y b = ((C0793a) c0670y.m4678b()).m5006b();
        C0670y c = ((C0793a) c0670y.m4678b()).m5007c();
        if (b != null && this.f2894a != null) {
            C0670y a = this.f2894a.m4802a(b, i, i2);
            return !b.equals(a) ? new C0794b(new C0793a(a, ((C0793a) c0670y.m4678b()).m5007c())) : c0670y;
        } else if (c == null || this.f2895b == null) {
            return c0670y;
        } else {
            b = this.f2895b.m4802a(c, i, i2);
            return !c.equals(b) ? new C0794b(new C0793a(((C0793a) c0670y.m4678b()).m5006b(), b)) : c0670y;
        }
    }

    public String m5028a() {
        return this.f2894a.m4803a();
    }
}
