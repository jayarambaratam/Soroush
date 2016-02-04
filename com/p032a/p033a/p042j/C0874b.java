package com.p032a.p033a.p042j;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.a.a.j.b */
public final class C0874b extends FilterInputStream {
    private final long f3057a;
    private int f3058b;

    C0874b(InputStream inputStream, long j) {
        super(inputStream);
        this.f3057a = j;
    }

    private int m5289a(int i) {
        if (i >= 0) {
            this.f3058b += i;
        } else if (this.f3057a - ((long) this.f3058b) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f3057a + ", but read: " + this.f3058b);
        }
        return i;
    }

    public static InputStream m5290a(InputStream inputStream, long j) {
        return new C0874b(inputStream, j);
    }

    public synchronized int available() {
        return (int) Math.max(this.f3057a - ((long) this.f3058b), (long) this.in.available());
    }

    public synchronized int read() {
        return m5289a(super.read());
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i, int i2) {
        return m5289a(super.read(bArr, i, i2));
    }
}
