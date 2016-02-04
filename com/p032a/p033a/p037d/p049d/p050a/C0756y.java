package com.p032a.p033a.p037d.p049d.p050a;

import android.graphics.Bitmap;
import com.p032a.p033a.p037d.C0598a;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import java.io.InputStream;

/* renamed from: com.a.a.d.d.a.y */
public class C0756y implements C0739e<InputStream, Bitmap> {
    private final C0733f f2805a;
    private C0605e f2806b;
    private C0598a f2807c;
    private String f2808d;

    public C0756y(C0605e c0605e, C0598a c0598a) {
        this(C0733f.f2754a, c0605e, c0598a);
    }

    public C0756y(C0733f c0733f, C0605e c0605e, C0598a c0598a) {
        this.f2805a = c0733f;
        this.f2806b = c0605e;
        this.f2807c = c0598a;
    }

    public C0670y<Bitmap> m4884a(InputStream inputStream, int i, int i2) {
        return C0729c.m4797a(this.f2805a.m4818a(inputStream, this.f2806b, i, i2, this.f2807c), this.f2806b);
    }

    public String m4886a() {
        if (this.f2808d == null) {
            this.f2808d = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.f2805a.m4789a() + this.f2807c.name();
        }
        return this.f2808d;
    }
}
