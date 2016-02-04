package com.p032a.p033a.p055e;

import com.p032a.p033a.p042j.C0879h;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.a.a.e.a */
class C0810a implements C0809i {
    private final Set<C0777j> f2911a;
    private boolean f2912b;
    private boolean f2913c;

    C0810a() {
        this.f2911a = Collections.newSetFromMap(new WeakHashMap());
    }

    void m5049a() {
        this.f2912b = true;
        for (C0777j d : C0879h.m5305a(this.f2911a)) {
            d.m4949d();
        }
    }

    public void m5050a(C0777j c0777j) {
        this.f2911a.add(c0777j);
        if (this.f2913c) {
            c0777j.m4951f();
        } else if (this.f2912b) {
            c0777j.m4949d();
        } else {
            c0777j.m4950e();
        }
    }

    void m5051b() {
        this.f2912b = false;
        for (C0777j e : C0879h.m5305a(this.f2911a)) {
            e.m4950e();
        }
    }

    void m5052c() {
        this.f2913c = true;
        for (C0777j f : C0879h.m5305a(this.f2911a)) {
            f.m4951f();
        }
    }
}
