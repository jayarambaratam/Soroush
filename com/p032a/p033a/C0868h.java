package com.p032a.p033a;

import android.content.Context;
import com.p032a.p033a.p037d.p046c.C0677s;
import com.p032a.p033a.p037d.p049d.p058f.C0802c;
import com.p032a.p033a.p037d.p049d.p058f.C0806e;
import com.p032a.p033a.p051g.C0831f;
import com.p032a.p033a.p051g.C0835e;
import com.p032a.p033a.p055e.C0809i;
import com.p032a.p033a.p055e.C0824q;

/* renamed from: com.a.a.h */
public class C0868h<ModelType, DataType, ResourceType> extends C0574e<ModelType, DataType, ResourceType, ResourceType> {
    private final C0677s<ModelType, DataType> f3033g;
    private final Class<DataType> f3034h;
    private final Class<ResourceType> f3035i;
    private final C0889r f3036j;

    C0868h(Context context, C0872i c0872i, Class<ModelType> cls, C0677s<ModelType, DataType> c0677s, Class<DataType> cls2, Class<ResourceType> cls3, C0824q c0824q, C0809i c0809i, C0889r c0889r) {
        super(context, cls, C0868h.m5256a(c0872i, c0677s, cls2, cls3, C0806e.m5041b()), cls3, c0872i, c0824q, c0809i);
        this.f3033g = c0677s;
        this.f3034h = cls2;
        this.f3035i = cls3;
        this.f3036j = c0889r;
    }

    private static <A, T, Z, R> C0831f<A, T, Z, R> m5256a(C0872i c0872i, C0677s<A, T> c0677s, Class<T> cls, Class<Z> cls2, C0802c<Z, R> c0802c) {
        return new C0835e(c0677s, c0802c, c0872i.m5278b((Class) cls, (Class) cls2));
    }
}
