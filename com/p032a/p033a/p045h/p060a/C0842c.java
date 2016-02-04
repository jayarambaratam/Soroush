package com.p032a.p033a.p045h.p060a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

/* renamed from: com.a.a.h.a.c */
public class C0842c<T extends Drawable> implements C0841d<T> {
    private final C0841d<T> f2956a;
    private final int f2957b;

    public C0842c(C0841d<T> c0841d, int i) {
        this.f2956a = c0841d;
        this.f2957b = i;
    }

    public boolean m5137a(T t, C0843e c0843e) {
        if (c0843e.m5139b() != null) {
            Drawable transitionDrawable = new TransitionDrawable(new Drawable[]{c0843e.m5139b(), t});
            transitionDrawable.setCrossFadeEnabled(true);
            transitionDrawable.startTransition(this.f2957b);
            c0843e.m5140c(transitionDrawable);
            return true;
        }
        this.f2956a.m5136a(t, c0843e);
        return false;
    }
}
