package com.p032a.p033a.p045h.p056b;

import android.view.View;
import com.p032a.p033a.p045h.C0860d;

/* renamed from: com.a.a.h.b.l */
public abstract class C0849l<T extends View, Z> extends C0779a<Z> {
    private static boolean f2963b;
    private static Integer f2964c;
    protected final T f2965a;
    private final C0858m f2966d;

    static {
        f2963b = false;
        f2964c = null;
    }

    public C0849l(T t) {
        if (t == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.f2965a = t;
        this.f2966d = new C0858m(t);
    }

    private void m5148a(Object obj) {
        if (f2964c == null) {
            f2963b = true;
            this.f2965a.setTag(obj);
            return;
        }
        this.f2965a.setTag(f2964c.intValue(), obj);
    }

    private Object m5149c() {
        return f2964c == null ? this.f2965a.getTag() : this.f2965a.getTag(f2964c.intValue());
    }

    public C0860d m5150a() {
        Object c = m5149c();
        if (c == null) {
            return null;
        }
        if (c instanceof C0860d) {
            return (C0860d) c;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void m5151a(C0855h c0855h) {
        this.f2966d.m5184a(c0855h);
    }

    public void m5152a(C0860d c0860d) {
        m5148a((Object) c0860d);
    }

    public T c_() {
        return this.f2965a;
    }

    public String toString() {
        return "Target for: " + this.f2965a;
    }
}
