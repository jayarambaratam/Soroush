package com.p032a.p033a.p037d.p049d.p052b;

import android.graphics.drawable.Drawable;
import com.p032a.p033a.p037d.p039b.C0670y;

/* renamed from: com.a.a.d.d.b.a */
public abstract class C0745a<T extends Drawable> implements C0670y<T> {
    protected final T f2776a;

    public C0745a(T t) {
        if (t == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.f2776a = t;
    }

    public final T m4849a() {
        return this.f2776a.getConstantState().newDrawable();
    }

    public /* synthetic */ Object m4850b() {
        return m4849a();
    }
}
