package com.p032a.p033a.p037d.p049d.p053c;

import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.C0670y;
import java.io.File;
import java.io.InputStream;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: com.a.a.d.d.c.g */
class C0767g implements C0739e<InputStream, File> {
    private C0767g() {
    }

    public C0670y<File> m4915a(InputStream inputStream, int i, int i2) {
        throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
    }

    public String m4917a() {
        return BuildConfig.FLAVOR;
    }
}
