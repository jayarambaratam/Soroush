package com.p032a.p033a.p037d.p049d.p050a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;

/* renamed from: com.a.a.d.d.a.e */
public class C0732e extends C0731d {
    public C0732e(C0605e c0605e) {
        super(c0605e);
    }

    protected Bitmap m4806a(C0605e c0605e, Bitmap bitmap, int i, int i2) {
        Bitmap a = c0605e.m4508a(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        Bitmap a2 = C0757z.m4889a(a, bitmap, i, i2);
        if (!(a == null || a == a2 || c0605e.m4511a(a))) {
            a.recycle();
        }
        return a2;
    }

    public String m4807a() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }
}
