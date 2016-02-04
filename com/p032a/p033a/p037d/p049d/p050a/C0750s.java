package com.p032a.p033a.p037d.p049d.p050a;

import java.io.InputStream;

/* renamed from: com.a.a.d.d.a.s */
class C0750s {
    private final InputStream f2789a;

    public C0750s(InputStream inputStream) {
        this.f2789a = inputStream;
    }

    public int m4865a() {
        return ((this.f2789a.read() << 8) & 65280) | (this.f2789a.read() & 255);
    }

    public int m4866a(byte[] bArr) {
        int length = bArr.length;
        while (length > 0) {
            int read = this.f2789a.read(bArr, bArr.length - length, length);
            if (read == -1) {
                break;
            }
            length -= read;
        }
        return bArr.length - length;
    }

    public long m4867a(long j) {
        if (j < 0) {
            return 0;
        }
        long j2 = j;
        while (j2 > 0) {
            long skip = this.f2789a.skip(j2);
            if (skip > 0) {
                j2 -= skip;
            } else if (this.f2789a.read() == -1) {
                break;
            } else {
                j2--;
            }
        }
        return j - j2;
    }

    public short m4868b() {
        return (short) (this.f2789a.read() & 255);
    }

    public int m4869c() {
        return this.f2789a.read();
    }
}
