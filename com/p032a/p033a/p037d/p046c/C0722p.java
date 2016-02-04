package com.p032a.p033a.p037d.p046c;

import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.p032a.p033a.p042j.C0631e;

/* renamed from: com.a.a.d.c.p */
public class C0722p<A, B> {
    private final C0631e<C0724r<A>, B> f2740a;

    public C0722p() {
        this(Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    }

    public C0722p(int i) {
        this.f2740a = new C0723q(this, i);
    }

    public B m4779a(A a, int i, int i2) {
        Object a2 = C0724r.m4783a(a, i, i2);
        B b = this.f2740a.m4601b(a2);
        a2.m4785a();
        return b;
    }

    public void m4780a(A a, int i, int i2, B b) {
        this.f2740a.m4602b(C0724r.m4783a(a, i, i2), b);
    }
}
