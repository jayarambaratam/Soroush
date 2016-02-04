package com.p032a.p033a.p037d.p049d.p054d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.p032a.p033a.p035b.C0577b;
import com.p032a.p033a.p035b.C0579d;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;

/* renamed from: com.a.a.d.d.d.c */
class C0771c extends ConstantState {
    C0579d f2831a;
    byte[] f2832b;
    Context f2833c;
    C0730g<Bitmap> f2834d;
    int f2835e;
    int f2836f;
    C0577b f2837g;
    C0605e f2838h;
    Bitmap f2839i;

    public C0771c(C0579d c0579d, byte[] bArr, Context context, C0730g<Bitmap> c0730g, int i, int i2, C0577b c0577b, C0605e c0605e, Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("The first frame of the GIF must not be null");
        }
        this.f2831a = c0579d;
        this.f2832b = bArr;
        this.f2838h = c0605e;
        this.f2839i = bitmap;
        this.f2833c = context.getApplicationContext();
        this.f2834d = c0730g;
        this.f2835e = i;
        this.f2836f = i2;
        this.f2837g = c0577b;
    }

    public int getChangingConfigurations() {
        return 0;
    }

    public Drawable newDrawable() {
        return new C0770b(this);
    }

    public Drawable newDrawable(Resources resources) {
        return newDrawable();
    }
}
