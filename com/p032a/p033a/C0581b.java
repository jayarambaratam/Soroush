package com.p032a.p033a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.p032a.p033a.p037d.p046c.C0677s;
import com.p032a.p033a.p037d.p046c.C0714h;
import com.p032a.p033a.p037d.p046c.C0716j;
import com.p032a.p033a.p037d.p049d.p058f.C0802c;
import com.p032a.p033a.p051g.C0835e;
import java.io.InputStream;

/* renamed from: com.a.a.b */
public class C0581b<ModelType> extends C0575a<ModelType, Bitmap> {
    private final C0677s<ModelType, InputStream> f2460g;
    private final C0677s<ModelType, ParcelFileDescriptor> f2461h;
    private final C0872i f2462i;
    private final C0889r f2463j;

    C0581b(C0574e<ModelType, ?, ?, ?> c0574e, C0677s<ModelType, InputStream> c0677s, C0677s<ModelType, ParcelFileDescriptor> c0677s2, C0889r c0889r) {
        super(C0581b.m4370a(c0574e.f2386c, c0677s, c0677s2, Bitmap.class, null), Bitmap.class, c0574e);
        this.f2460g = c0677s;
        this.f2461h = c0677s2;
        this.f2462i = c0574e.f2386c;
        this.f2463j = c0889r;
    }

    private static <A, R> C0835e<A, C0716j, Bitmap, R> m4370a(C0872i c0872i, C0677s<A, InputStream> c0677s, C0677s<A, ParcelFileDescriptor> c0677s2, Class<R> cls, C0802c<Bitmap, R> c0802c) {
        if (c0677s == null && c0677s2 == null) {
            return null;
        }
        C0802c a;
        if (c0802c == null) {
            a = c0872i.m5273a(Bitmap.class, (Class) cls);
        }
        return new C0835e(new C0714h(c0677s, c0677s2), a, c0872i.m5278b(C0716j.class, Bitmap.class));
    }
}
