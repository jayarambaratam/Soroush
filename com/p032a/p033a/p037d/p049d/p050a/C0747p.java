package com.p032a.p033a.p037d.p049d.p050a;

import android.util.Log;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;

/* renamed from: com.a.a.d.d.a.p */
public class C0747p {
    private static final byte[] f2778a;
    private static final int[] f2779b;
    private final C0750s f2780c;

    static {
        f2779b = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
        byte[] bArr = new byte[0];
        try {
            bArr = "Exif\u0000\u0000".getBytes(StringUtils.UTF8);
        } catch (UnsupportedEncodingException e) {
        }
        f2778a = bArr;
    }

    public C0747p(InputStream inputStream) {
        this.f2780c = new C0750s(inputStream);
    }

    private static int m4853a(int i, int i2) {
        return (i + 2) + (i2 * 12);
    }

    private static int m4854a(C0749r c0749r) {
        ByteOrder byteOrder;
        int length = "Exif\u0000\u0000".length();
        short b = c0749r.m4864b(length);
        if (b == (short) 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (b == (short) 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + b);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        c0749r.m4863a(byteOrder);
        length += c0749r.m4862a(length + 4);
        short b2 = c0749r.m4864b(length);
        for (b = (short) 0; b < b2; b++) {
            int a = C0747p.m4853a(length, b);
            short b3 = c0749r.m4864b(a);
            if (b3 == (short) 274) {
                short b4 = c0749r.m4864b(a + 2);
                if (b4 >= (short) 1 && b4 <= (short) 12) {
                    int a2 = c0749r.m4862a(a + 4);
                    if (a2 >= 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + b + " tagType=" + b3 + " formatCode=" + b4 + " componentCount=" + a2);
                        }
                        a2 += f2779b[b4];
                        if (a2 <= 4) {
                            a += 8;
                            if (a < 0 || a > c0749r.m4861a()) {
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + a + " tagType=" + b3);
                                }
                            } else if (a2 >= 0 && a + a2 <= c0749r.m4861a()) {
                                return c0749r.m4864b(a);
                            } else {
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + b3);
                                }
                            }
                        } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + b4);
                        }
                    } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Got invalid format code=" + b4);
                }
            }
        }
        return -1;
    }

    private static boolean m4855a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    private byte[] m4856d() {
        long a;
        int a2;
        do {
            short b;
            short b2 = this.f2780c.m4868b();
            if (b2 == (short) 255) {
                b = this.f2780c.m4868b();
                if (b == (short) 218) {
                    return null;
                }
                if (b != (short) 217) {
                    a2 = this.f2780c.m4865a() - 2;
                    if (b != (short) 225) {
                        a = this.f2780c.m4867a((long) a2);
                    } else {
                        byte[] bArr = new byte[a2];
                        int a3 = this.f2780c.m4866a(bArr);
                        if (a3 == a2) {
                            return bArr;
                        }
                        if (!Log.isLoggable("ImageHeaderParser", 3)) {
                            return null;
                        }
                        Log.d("ImageHeaderParser", "Unable to read segment data, type: " + b + ", length: " + a2 + ", actually read: " + a3);
                        return null;
                    }
                } else if (!Log.isLoggable("ImageHeaderParser", 3)) {
                    return null;
                } else {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                    return null;
                }
            } else if (!Log.isLoggable("ImageHeaderParser", 3)) {
                return null;
            } else {
                Log.d("ImageHeaderParser", "Unknown segmentId=" + b2);
                return null;
            }
        } while (a == ((long) a2));
        if (!Log.isLoggable("ImageHeaderParser", 3)) {
            return null;
        }
        Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + b + ", wanted to skip: " + a2 + ", but actually skipped: " + a);
        return null;
    }

    public boolean m4857a() {
        return m4858b().m4860a();
    }

    public C0748q m4858b() {
        int a = this.f2780c.m4865a();
        if (a == 65496) {
            return C0748q.JPEG;
        }
        a = ((a << 16) & -65536) | (this.f2780c.m4865a() & InBandBytestreamManager.MAXIMUM_BLOCK_SIZE);
        if (a != -1991225785) {
            return (a >> 8) == 4671814 ? C0748q.GIF : C0748q.UNKNOWN;
        } else {
            this.f2780c.m4867a(21);
            return this.f2780c.m4869c() >= 3 ? C0748q.PNG_A : C0748q.PNG;
        }
    }

    public int m4859c() {
        Object obj = null;
        if (!C0747p.m4855a(this.f2780c.m4865a())) {
            return -1;
        }
        byte[] d = m4856d();
        Object obj2 = (d == null || d.length <= f2778a.length) ? null : 1;
        if (obj2 != null) {
            for (int i = 0; i < f2778a.length; i++) {
                if (d[i] != f2778a[i]) {
                    break;
                }
            }
        }
        obj = obj2;
        return obj != null ? C0747p.m4854a(new C0749r(d)) : -1;
    }
}
