package com.p032a.p033a.p037d.p049d.p050a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.C0670y;
import com.p032a.p033a.p037d.p046c.C0716j;
import java.io.InputStream;

/* renamed from: com.a.a.d.d.a.t */
public class C0751t implements C0739e<C0716j, Bitmap> {
    private final C0739e<InputStream, Bitmap> f2790a;
    private final C0739e<ParcelFileDescriptor, Bitmap> f2791b;

    public C0751t(C0739e<InputStream, Bitmap> c0739e, C0739e<ParcelFileDescriptor, Bitmap> c0739e2) {
        this.f2790a = c0739e;
        this.f2791b = c0739e2;
    }

    public C0670y<Bitmap> m4870a(C0716j c0716j, int i, int i2) {
        C0670y<Bitmap> a;
        InputStream a2 = c0716j.m4769a();
        if (a2 != null) {
            try {
                a = this.f2790a.m4834a(a2, i, i2);
            } catch (Throwable e) {
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", e);
                }
            }
            if (a == null) {
                return a;
            }
            ParcelFileDescriptor b = c0716j.m4770b();
            return b == null ? this.f2791b.m4834a(b, i, i2) : a;
        }
        a = null;
        if (a == null) {
            return a;
        }
        ParcelFileDescriptor b2 = c0716j.m4770b();
        if (b2 == null) {
        }
    }

    public String m4872a() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
