package com.p032a.p033a.p045h.p060a;

import android.view.View;

/* renamed from: com.a.a.h.a.i */
public class C0846i<R> implements C0841d<R> {
    private final C0839j f2960a;

    C0846i(C0839j c0839j) {
        this.f2960a = c0839j;
    }

    public boolean m5146a(R r, C0843e c0843e) {
        View c_ = c0843e.c_();
        if (c_ != null) {
            c_.clearAnimation();
            c_.startAnimation(this.f2960a.m5134a());
        }
        return false;
    }
}
