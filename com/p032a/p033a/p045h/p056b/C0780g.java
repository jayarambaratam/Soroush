package com.p032a.p033a.p045h.p056b;

import com.p032a.p033a.p042j.C0879h;

/* renamed from: com.a.a.h.b.g */
public abstract class C0780g<Z> extends C0779a<Z> {
    private final int f2855a;
    private final int f2856b;

    public C0780g() {
        this(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
    }

    public C0780g(int i, int i2) {
        this.f2855a = i;
        this.f2856b = i2;
    }

    public final void m4967a(C0855h c0855h) {
        if (C0879h.m5308a(this.f2855a, this.f2856b)) {
            c0855h.m5171a(this.f2855a, this.f2856b);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.f2855a + " and height: " + this.f2856b + ", either provide dimensions in the constructor" + " or call override()");
    }
}
