package com.p032a.p033a.p037d.p049d.p050a;

import android.content.Context;
import android.graphics.Bitmap;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p042j.C0879h;

/* renamed from: com.a.a.d.d.a.d */
public abstract class C0731d implements C0730g<Bitmap> {
    private C0605e f2753a;

    public C0731d(Context context) {
        this(C0872i.m5264a(context).m5272a());
    }

    public C0731d(C0605e c0605e) {
        this.f2753a = c0605e;
    }

    protected abstract Bitmap m4804a(C0605e c0605e, Bitmap bitmap, int i, int i2);

    public final C0670y<Bitmap> m4805a(C0670y<Bitmap> c0670y, int i, int i2) {
        if (C0879h.m5308a(i, i2)) {
            Bitmap bitmap = (Bitmap) c0670y.m4678b();
            if (i == RtlSpacingHelper.UNDEFINED) {
                i = bitmap.getWidth();
            }
            if (i2 == RtlSpacingHelper.UNDEFINED) {
                i2 = bitmap.getHeight();
            }
            Bitmap a = m4804a(this.f2753a, bitmap, i, i2);
            return bitmap.equals(a) ? c0670y : C0729c.m4797a(a, this.f2753a);
        } else {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
    }
}
