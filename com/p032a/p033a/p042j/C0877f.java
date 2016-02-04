package com.p032a.p033a.p042j;

import java.io.FilterInputStream;
import java.io.InputStream;

/* renamed from: com.a.a.j.f */
public class C0877f extends FilterInputStream {
    private int f3063a;

    public C0877f(InputStream inputStream) {
        super(inputStream);
        this.f3063a = RtlSpacingHelper.UNDEFINED;
    }

    private long m5297a(long j) {
        return this.f3063a == 0 ? -1 : (this.f3063a == RtlSpacingHelper.UNDEFINED || j <= ((long) this.f3063a)) ? j : (long) this.f3063a;
    }

    private void m5298b(long j) {
        if (this.f3063a != RtlSpacingHelper.UNDEFINED && j != -1) {
            this.f3063a = (int) (((long) this.f3063a) - j);
        }
    }

    public int available() {
        return this.f3063a == RtlSpacingHelper.UNDEFINED ? super.available() : Math.min(this.f3063a, super.available());
    }

    public void mark(int i) {
        super.mark(i);
        this.f3063a = i;
    }

    public int read() {
        if (m5297a(1) == -1) {
            return -1;
        }
        int read = super.read();
        m5298b(1);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) {
        int a = (int) m5297a((long) i2);
        if (a == -1) {
            return -1;
        }
        int read = super.read(bArr, i, a);
        m5298b((long) read);
        return read;
    }

    public void reset() {
        super.reset();
        this.f3063a = RtlSpacingHelper.UNDEFINED;
    }

    public long skip(long j) {
        long a = m5297a(j);
        if (a == -1) {
            return -1;
        }
        long skip = super.skip(a);
        m5298b(skip);
        return skip;
    }
}
