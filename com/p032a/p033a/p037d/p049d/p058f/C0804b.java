package com.p032a.p033a.p037d.p049d.p058f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p049d.p050a.C0743m;
import com.p032a.p033a.p037d.p049d.p050a.C0746o;

/* renamed from: com.a.a.d.d.f.b */
public class C0804b implements C0802c<Bitmap, C0743m> {
    private final Resources f2901a;
    private final C0605e f2902b;

    public C0804b(Resources resources, C0605e c0605e) {
        this.f2901a = resources;
        this.f2902b = c0605e;
    }

    public C0670y<C0743m> m5037a(C0670y<Bitmap> c0670y) {
        return new C0746o(new C0743m(this.f2901a, (Bitmap) c0670y.m4678b()), this.f2902b);
    }

    public String m5038a() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
