package com.p032a.p033a.p055e;

import com.p032a.p033a.p042j.C0879h;
import com.p032a.p033a.p045h.C0860d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.a.a.e.q */
public class C0824q {
    private final Set<C0860d> f2931a;
    private final List<C0860d> f2932b;
    private boolean f2933c;

    public C0824q() {
        this.f2931a = Collections.newSetFromMap(new WeakHashMap());
        this.f2932b = new ArrayList();
    }

    public void m5085a() {
        this.f2933c = true;
        for (C0860d c0860d : C0879h.m5305a(this.f2931a)) {
            if (c0860d.m5189f()) {
                c0860d.m5188e();
                this.f2932b.add(c0860d);
            }
        }
    }

    public void m5086a(C0860d c0860d) {
        this.f2931a.add(c0860d);
        if (this.f2933c) {
            this.f2932b.add(c0860d);
        } else {
            c0860d.m5186b();
        }
    }

    public void m5087b() {
        this.f2933c = false;
        for (C0860d c0860d : C0879h.m5305a(this.f2931a)) {
            if (!(c0860d.m5190g() || c0860d.m5192i() || c0860d.m5189f())) {
                c0860d.m5186b();
            }
        }
        this.f2932b.clear();
    }

    public void m5088b(C0860d c0860d) {
        this.f2931a.remove(c0860d);
        this.f2932b.remove(c0860d);
    }

    public void m5089c() {
        for (C0860d d : C0879h.m5305a(this.f2931a)) {
            d.m5187d();
        }
        this.f2932b.clear();
    }

    public void m5090d() {
        for (C0860d c0860d : C0879h.m5305a(this.f2931a)) {
            if (!(c0860d.m5190g() || c0860d.m5192i())) {
                c0860d.m5188e();
                if (this.f2933c) {
                    this.f2932b.add(c0860d);
                } else {
                    c0860d.m5186b();
                }
            }
        }
    }
}
