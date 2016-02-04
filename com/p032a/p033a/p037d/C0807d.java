package com.p032a.p033a.p037d;

import com.p032a.p033a.p037d.p039b.C0670y;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: com.a.a.d.d */
public class C0807d<T> implements C0730g<T> {
    private final Collection<? extends C0730g<T>> f2906a;
    private String f2907b;

    @SafeVarargs
    public C0807d(C0730g<T>... c0730gArr) {
        if (c0730gArr.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f2906a = Arrays.asList(c0730gArr);
    }

    public C0670y<T> m5044a(C0670y<T> c0670y, int i, int i2) {
        C0670y<T> c0670y2 = c0670y;
        for (C0730g a : this.f2906a) {
            C0670y<T> a2 = a.m4802a(c0670y2, i, i2);
            if (!(c0670y2 == null || c0670y2.equals(c0670y) || c0670y2.equals(a2))) {
                c0670y2.m4680d();
            }
            c0670y2 = a2;
        }
        return c0670y2;
    }

    public String m5045a() {
        if (this.f2907b == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (C0730g a : this.f2906a) {
                stringBuilder.append(a.m4803a());
            }
            this.f2907b = stringBuilder.toString();
        }
        return this.f2907b;
    }
}
