package com.p032a.p033a.p037d.p049d.p054d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.p032a.p033a.p035b.C0576a;
import com.p032a.p033a.p035b.C0579d;
import com.p032a.p033a.p035b.C0580e;
import com.p032a.p033a.p037d.C0739e;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p049d.C0792d;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: com.a.a.d.d.d.p */
public class C0787p implements C0739e<InputStream, C0770b> {
    private static final C0789r f2865a;
    private static final C0788q f2866b;
    private final Context f2867c;
    private final C0789r f2868d;
    private final C0605e f2869e;
    private final C0788q f2870f;
    private final C0768a f2871g;

    static {
        f2865a = new C0789r();
        f2866b = new C0788q();
    }

    public C0787p(Context context, C0605e c0605e) {
        this(context, c0605e, f2865a, f2866b);
    }

    C0787p(Context context, C0605e c0605e, C0789r c0789r, C0788q c0788q) {
        this.f2867c = context;
        this.f2869e = c0605e;
        this.f2870f = c0788q;
        this.f2871g = new C0768a(c0605e);
        this.f2868d = c0789r;
    }

    private Bitmap m4982a(C0576a c0576a, C0579d c0579d, byte[] bArr) {
        c0576a.m4342a(c0579d, bArr);
        c0576a.m4341a();
        return c0576a.m4347f();
    }

    private C0773e m4983a(byte[] bArr, int i, int i2, C0580e c0580e, C0576a c0576a) {
        C0579d b = c0580e.m4369b();
        if (b.m4351a() <= 0 || b.m4352b() != 0) {
            return null;
        }
        Bitmap a = m4982a(c0576a, b, bArr);
        if (a == null) {
            return null;
        }
        return new C0773e(new C0770b(this.f2867c, this.f2871g, this.f2869e, C0792d.m5002b(), i, i2, b, bArr, a));
    }

    private static byte[] m4984a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
        } catch (Throwable e) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public C0773e m4986a(InputStream inputStream, int i, int i2) {
        byte[] a = C0787p.m4984a(inputStream);
        C0580e a2 = this.f2868d.m4990a(a);
        C0576a a3 = this.f2870f.m4988a(this.f2871g);
        try {
            C0773e a4 = m4983a(a, i, i2, a2, a3);
            return a4;
        } finally {
            this.f2868d.m4991a(a2);
            this.f2870f.m4989a(a3);
        }
    }

    public String m4987a() {
        return BuildConfig.FLAVOR;
    }
}
