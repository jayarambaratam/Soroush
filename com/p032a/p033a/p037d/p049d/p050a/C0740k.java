package com.p032a.p033a.p037d.p049d.p050a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.p032a.p033a.p037d.C0598a;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;

/* renamed from: com.a.a.d.d.a.k */
public class C0740k implements C0739e<ParcelFileDescriptor, Bitmap> {
    private final aa f2763a;
    private final C0605e f2764b;
    private C0598a f2765c;

    public C0740k(C0605e c0605e, C0598a c0598a) {
        this(new aa(), c0605e, c0598a);
    }

    public C0740k(aa aaVar, C0605e c0605e, C0598a c0598a) {
        this.f2763a = aaVar;
        this.f2764b = c0605e;
        this.f2765c = c0598a;
    }

    public C0670y<Bitmap> m4836a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2) {
        return C0729c.m4797a(this.f2763a.m4790a(parcelFileDescriptor, this.f2764b, i, i2, this.f2765c), this.f2764b);
    }

    public String m4838a() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }
}
