package com.p032a.p033a.p037d.p049d.p054d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.p032a.p033a.p035b.C0577b;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;

/* renamed from: com.a.a.d.d.d.a */
class C0768a implements C0577b {
    private final C0605e f2818a;

    public C0768a(C0605e c0605e) {
        this.f2818a = c0605e;
    }

    public Bitmap m4918a(int i, int i2, Config config) {
        return this.f2818a.m4512b(i, i2, config);
    }

    public void m4919a(Bitmap bitmap) {
        if (!this.f2818a.m4511a(bitmap)) {
            bitmap.recycle();
        }
    }
}
