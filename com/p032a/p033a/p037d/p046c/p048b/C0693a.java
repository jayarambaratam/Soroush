package com.p032a.p033a.p037d.p046c.p048b;

import com.p032a.p033a.p037d.p038a.C0586c;
import com.p032a.p033a.p037d.p038a.C0592f;
import com.p032a.p033a.p037d.p046c.C0677s;
import com.p032a.p033a.p037d.p046c.C0711e;
import com.p032a.p033a.p037d.p046c.C0722p;
import java.io.InputStream;

/* renamed from: com.a.a.d.c.b.a */
public class C0693a implements C0677s<C0711e, InputStream> {
    private final C0722p<C0711e, C0711e> f2707a;

    public C0693a() {
        this(null);
    }

    public C0693a(C0722p<C0711e, C0711e> c0722p) {
        this.f2707a = c0722p;
    }

    public C0586c<InputStream> m4727a(C0711e c0711e, int i, int i2) {
        if (this.f2707a != null) {
            C0711e c0711e2 = (C0711e) this.f2707a.m4779a(c0711e, 0, 0);
            if (c0711e2 == null) {
                this.f2707a.m4780a(c0711e, 0, 0, c0711e);
            } else {
                c0711e = c0711e2;
            }
        }
        return new C0592f(c0711e);
    }
}
