package com.p032a.p033a.p037d.p049d.p053c;

import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.C0670y;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: com.a.a.d.d.c.c */
public class C0763c<T> implements C0739e<File, T> {
    private static final C0764d f2812a;
    private C0739e<InputStream, T> f2813b;
    private final C0764d f2814c;

    static {
        f2812a = new C0764d();
    }

    public C0763c(C0739e<InputStream, T> c0739e) {
        this(c0739e, f2812a);
    }

    C0763c(C0739e<InputStream, T> c0739e, C0764d c0764d) {
        this.f2813b = c0739e;
        this.f2814c = c0764d;
    }

    public C0670y<T> m4907a(File file, int i, int i2) {
        InputStream inputStream = null;
        try {
            inputStream = this.f2814c.m4910a(file);
            C0670y<T> a = this.f2813b.m4834a(inputStream, i, i2);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            return a;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
        }
    }

    public String m4909a() {
        return BuildConfig.FLAVOR;
    }
}
