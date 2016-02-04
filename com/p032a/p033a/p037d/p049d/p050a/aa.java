package com.p032a.p033a.p037d.p049d.p050a;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.p032a.p033a.p037d.C0598a;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;

/* renamed from: com.a.a.d.d.a.aa */
public class aa implements C0726a<ParcelFileDescriptor> {
    private static final ab f2746a;
    private ab f2747b;
    private int f2748c;

    static {
        f2746a = new ab();
    }

    public aa() {
        this(f2746a, -1);
    }

    aa(ab abVar, int i) {
        this.f2747b = abVar;
        this.f2748c = i;
    }

    public Bitmap m4790a(ParcelFileDescriptor parcelFileDescriptor, C0605e c0605e, int i, int i2, C0598a c0598a) {
        MediaMetadataRetriever a = this.f2747b.m4792a();
        a.setDataSource(parcelFileDescriptor.getFileDescriptor());
        Bitmap frameAtTime = this.f2748c >= 0 ? a.getFrameAtTime((long) this.f2748c) : a.getFrameAtTime();
        a.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    public String m4791a() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
