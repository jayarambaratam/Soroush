package com.p032a.p033a.p037d.p049d.p050a;

import android.graphics.Bitmap;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p042j.C0879h;

/* renamed from: com.a.a.d.d.a.c */
public class C0729c implements C0670y<Bitmap> {
    private final Bitmap f2751a;
    private final C0605e f2752b;

    public C0729c(Bitmap bitmap, C0605e c0605e) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (c0605e == null) {
            throw new NullPointerException("BitmapPool must not be null");
        } else {
            this.f2751a = bitmap;
            this.f2752b = c0605e;
        }
    }

    public static C0729c m4797a(Bitmap bitmap, C0605e c0605e) {
        return bitmap == null ? null : new C0729c(bitmap, c0605e);
    }

    public Bitmap m4798a() {
        return this.f2751a;
    }

    public /* synthetic */ Object m4799b() {
        return m4798a();
    }

    public int m4800c() {
        return C0879h.m5302a(this.f2751a);
    }

    public void m4801d() {
        if (!this.f2752b.m4511a(this.f2751a)) {
            this.f2751a.recycle();
        }
    }
}
