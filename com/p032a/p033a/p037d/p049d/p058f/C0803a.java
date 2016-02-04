package com.p032a.p033a.p037d.p049d.p058f;

import android.graphics.Bitmap;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p049d.p050a.C0743m;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;
import com.p032a.p033a.p037d.p049d.p057e.C0793a;

/* renamed from: com.a.a.d.d.f.a */
public class C0803a implements C0802c<C0793a, C0742b> {
    private final C0802c<Bitmap, C0743m> f2900a;

    public C0803a(C0802c<Bitmap, C0743m> c0802c) {
        this.f2900a = c0802c;
    }

    public C0670y<C0742b> m5035a(C0670y<C0793a> c0670y) {
        C0793a c0793a = (C0793a) c0670y.m4678b();
        C0670y b = c0793a.m5006b();
        return b != null ? this.f2900a.m5033a(b) : c0793a.m5007c();
    }

    public String m5036a() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
