package com.p032a.p033a;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.p032a.p033a.p037d.p046c.C0677s;
import com.p032a.p033a.p037d.p046c.C0714h;
import com.p032a.p033a.p037d.p046c.C0716j;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;
import com.p032a.p033a.p037d.p049d.p057e.C0793a;
import com.p032a.p033a.p037d.p049d.p058f.C0802c;
import com.p032a.p033a.p051g.C0835e;
import com.p032a.p033a.p055e.C0809i;
import com.p032a.p033a.p055e.C0824q;
import java.io.InputStream;

/* renamed from: com.a.a.d */
public class C0808d<ModelType> extends C0585c<ModelType> {
    private final C0677s<ModelType, InputStream> f2908g;
    private final C0677s<ModelType, ParcelFileDescriptor> f2909h;
    private final C0889r f2910i;

    C0808d(Class<ModelType> cls, C0677s<ModelType, InputStream> c0677s, C0677s<ModelType, ParcelFileDescriptor> c0677s2, Context context, C0872i c0872i, C0824q c0824q, C0809i c0809i, C0889r c0889r) {
        super(context, cls, C0808d.m5046a(c0872i, c0677s, c0677s2, C0793a.class, C0742b.class, null), c0872i, c0824q, c0809i);
        this.f2908g = c0677s;
        this.f2909h = c0677s2;
        this.f2910i = c0889r;
    }

    private static <A, Z, R> C0835e<A, C0716j, Z, R> m5046a(C0872i c0872i, C0677s<A, InputStream> c0677s, C0677s<A, ParcelFileDescriptor> c0677s2, Class<Z> cls, Class<R> cls2, C0802c<Z, R> c0802c) {
        if (c0677s == null && c0677s2 == null) {
            return null;
        }
        C0802c a;
        if (c0802c == null) {
            a = c0872i.m5273a((Class) cls, (Class) cls2);
        }
        return new C0835e(new C0714h(c0677s, c0677s2), a, c0872i.m5278b(C0716j.class, (Class) cls));
    }

    public C0581b<ModelType> m5047j() {
        return (C0581b) this.f2910i.m5346a(new C0581b(this, this.f2908g, this.f2909h, this.f2910i));
    }
}
