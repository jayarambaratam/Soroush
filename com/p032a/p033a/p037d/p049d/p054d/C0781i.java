package com.p032a.p033a.p037d.p049d.p054d;

import android.graphics.Bitmap;
import android.os.Handler;
import com.p032a.p033a.p045h.p056b.C0780g;
import com.p032a.p033a.p045h.p060a.C0841d;

/* renamed from: com.a.a.d.d.d.i */
class C0781i extends C0780g<Bitmap> {
    private final Handler f2857a;
    private final int f2858b;
    private final long f2859c;
    private Bitmap f2860d;

    public C0781i(Handler handler, int i, long j) {
        this.f2857a = handler;
        this.f2858b = i;
        this.f2859c = j;
    }

    public void m4969a(Bitmap bitmap, C0841d<? super Bitmap> c0841d) {
        this.f2860d = bitmap;
        this.f2857a.sendMessageAtTime(this.f2857a.obtainMessage(1, this), this.f2859c);
    }

    public Bitmap d_() {
        return this.f2860d;
    }
}
