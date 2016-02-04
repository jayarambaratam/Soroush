package com.p032a.p033a.p037d.p049d.p050a;

import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.a.a.d.d.a.v */
public class C0753v extends FilterInputStream {
    private volatile byte[] f2796a;
    private int f2797b;
    private int f2798c;
    private int f2799d;
    private int f2800e;

    public C0753v(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        this.f2799d = -1;
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("buffer is null or empty");
        }
        this.f2796a = bArr;
    }

    private int m4877a(InputStream inputStream, byte[] bArr) {
        int read;
        if (this.f2799d == -1 || this.f2800e - this.f2799d >= this.f2798c) {
            read = inputStream.read(bArr);
            if (read <= 0) {
                return read;
            }
            this.f2799d = -1;
            this.f2800e = 0;
            this.f2797b = read;
            return read;
        }
        if (this.f2799d == 0 && this.f2798c > bArr.length && this.f2797b == bArr.length) {
            read = bArr.length * 2;
            if (read > this.f2798c) {
                read = this.f2798c;
            }
            if (Log.isLoggable("BufferedIs", 3)) {
                Log.d("BufferedIs", "allocate buffer of length: " + read);
            }
            Object obj = new byte[read];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            this.f2796a = obj;
            bArr = obj;
        } else if (this.f2799d > 0) {
            System.arraycopy(bArr, this.f2799d, bArr, 0, bArr.length - this.f2799d);
        }
        this.f2800e -= this.f2799d;
        this.f2799d = 0;
        this.f2797b = 0;
        int read2 = inputStream.read(bArr, this.f2800e, bArr.length - this.f2800e);
        this.f2797b = read2 <= 0 ? this.f2800e : this.f2800e + read2;
        return read2;
    }

    private static IOException m4878b() {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void m4879a() {
        this.f2798c = this.f2796a.length;
    }

    public synchronized int available() {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f2796a == null || inputStream == null) {
            throw C0753v.m4878b();
        }
        return inputStream.available() + (this.f2797b - this.f2800e);
    }

    public void close() {
        this.f2796a = null;
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void mark(int i) {
        this.f2798c = Math.max(this.f2798c, i);
        this.f2799d = this.f2800e;
    }

    public boolean markSupported() {
        return true;
    }

    public synchronized int read() {
        int i = -1;
        synchronized (this) {
            byte[] bArr = this.f2796a;
            InputStream inputStream = this.in;
            if (bArr == null || inputStream == null) {
                throw C0753v.m4878b();
            }
            if (this.f2800e < this.f2797b || m4877a(inputStream, bArr) != -1) {
                if (bArr != this.f2796a) {
                    bArr = this.f2796a;
                    if (bArr == null) {
                        throw C0753v.m4878b();
                    }
                }
                if (this.f2797b - this.f2800e > 0) {
                    i = this.f2800e;
                    this.f2800e = i + 1;
                    i = bArr[i] & 255;
                }
            }
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r7, int r8, int r9) {
        /*
        r6 = this;
        r0 = -1;
        monitor-enter(r6);
        r2 = r6.f2796a;	 Catch:{ all -> 0x000b }
        if (r2 != 0) goto L_0x000e;
    L_0x0006:
        r0 = com.p032a.p033a.p037d.p049d.p050a.C0753v.m4878b();	 Catch:{ all -> 0x000b }
        throw r0;	 Catch:{ all -> 0x000b }
    L_0x000b:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x000e:
        if (r9 != 0) goto L_0x0013;
    L_0x0010:
        r0 = 0;
    L_0x0011:
        monitor-exit(r6);
        return r0;
    L_0x0013:
        r4 = r6.in;	 Catch:{ all -> 0x000b }
        if (r4 != 0) goto L_0x001c;
    L_0x0017:
        r0 = com.p032a.p033a.p037d.p049d.p050a.C0753v.m4878b();	 Catch:{ all -> 0x000b }
        throw r0;	 Catch:{ all -> 0x000b }
    L_0x001c:
        r1 = r6.f2800e;	 Catch:{ all -> 0x000b }
        r3 = r6.f2797b;	 Catch:{ all -> 0x000b }
        if (r1 >= r3) goto L_0x0059;
    L_0x0022:
        r1 = r6.f2797b;	 Catch:{ all -> 0x000b }
        r3 = r6.f2800e;	 Catch:{ all -> 0x000b }
        r1 = r1 - r3;
        if (r1 < r9) goto L_0x003e;
    L_0x0029:
        r1 = r9;
    L_0x002a:
        r3 = r6.f2800e;	 Catch:{ all -> 0x000b }
        java.lang.System.arraycopy(r2, r3, r7, r8, r1);	 Catch:{ all -> 0x000b }
        r3 = r6.f2800e;	 Catch:{ all -> 0x000b }
        r3 = r3 + r1;
        r6.f2800e = r3;	 Catch:{ all -> 0x000b }
        if (r1 == r9) goto L_0x003c;
    L_0x0036:
        r3 = r4.available();	 Catch:{ all -> 0x000b }
        if (r3 != 0) goto L_0x0044;
    L_0x003c:
        r0 = r1;
        goto L_0x0011;
    L_0x003e:
        r1 = r6.f2797b;	 Catch:{ all -> 0x000b }
        r3 = r6.f2800e;	 Catch:{ all -> 0x000b }
        r1 = r1 - r3;
        goto L_0x002a;
    L_0x0044:
        r8 = r8 + r1;
        r3 = r9 - r1;
    L_0x0047:
        r1 = r6.f2799d;	 Catch:{ all -> 0x000b }
        if (r1 != r0) goto L_0x005b;
    L_0x004b:
        r1 = r2.length;	 Catch:{ all -> 0x000b }
        if (r3 < r1) goto L_0x005b;
    L_0x004e:
        r1 = r4.read(r7, r8, r3);	 Catch:{ all -> 0x000b }
        if (r1 != r0) goto L_0x0085;
    L_0x0054:
        if (r3 == r9) goto L_0x0011;
    L_0x0056:
        r0 = r9 - r3;
        goto L_0x0011;
    L_0x0059:
        r3 = r9;
        goto L_0x0047;
    L_0x005b:
        r1 = r6.m4877a(r4, r2);	 Catch:{ all -> 0x000b }
        if (r1 != r0) goto L_0x0066;
    L_0x0061:
        if (r3 == r9) goto L_0x0011;
    L_0x0063:
        r0 = r9 - r3;
        goto L_0x0011;
    L_0x0066:
        r1 = r6.f2796a;	 Catch:{ all -> 0x000b }
        if (r2 == r1) goto L_0x0073;
    L_0x006a:
        r2 = r6.f2796a;	 Catch:{ all -> 0x000b }
        if (r2 != 0) goto L_0x0073;
    L_0x006e:
        r0 = com.p032a.p033a.p037d.p049d.p050a.C0753v.m4878b();	 Catch:{ all -> 0x000b }
        throw r0;	 Catch:{ all -> 0x000b }
    L_0x0073:
        r1 = r6.f2797b;	 Catch:{ all -> 0x000b }
        r5 = r6.f2800e;	 Catch:{ all -> 0x000b }
        r1 = r1 - r5;
        if (r1 < r3) goto L_0x008a;
    L_0x007a:
        r1 = r3;
    L_0x007b:
        r5 = r6.f2800e;	 Catch:{ all -> 0x000b }
        java.lang.System.arraycopy(r2, r5, r7, r8, r1);	 Catch:{ all -> 0x000b }
        r5 = r6.f2800e;	 Catch:{ all -> 0x000b }
        r5 = r5 + r1;
        r6.f2800e = r5;	 Catch:{ all -> 0x000b }
    L_0x0085:
        r3 = r3 - r1;
        if (r3 != 0) goto L_0x0090;
    L_0x0088:
        r0 = r9;
        goto L_0x0011;
    L_0x008a:
        r1 = r6.f2797b;	 Catch:{ all -> 0x000b }
        r5 = r6.f2800e;	 Catch:{ all -> 0x000b }
        r1 = r1 - r5;
        goto L_0x007b;
    L_0x0090:
        r5 = r4.available();	 Catch:{ all -> 0x000b }
        if (r5 != 0) goto L_0x009a;
    L_0x0096:
        r0 = r9 - r3;
        goto L_0x0011;
    L_0x009a:
        r8 = r8 + r1;
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.d.d.a.v.read(byte[], int, int):int");
    }

    public synchronized void reset() {
        if (this.f2796a == null) {
            throw new IOException("Stream is closed");
        } else if (-1 == this.f2799d) {
            throw new C0754w("Mark has been invalidated");
        } else {
            this.f2800e = this.f2799d;
        }
    }

    public synchronized long skip(long j) {
        byte[] bArr = this.f2796a;
        InputStream inputStream = this.in;
        if (bArr == null) {
            throw C0753v.m4878b();
        } else if (j < 1) {
            j = 0;
        } else if (inputStream == null) {
            throw C0753v.m4878b();
        } else if (((long) (this.f2797b - this.f2800e)) >= j) {
            this.f2800e = (int) (((long) this.f2800e) + j);
        } else {
            long j2 = (long) (this.f2797b - this.f2800e);
            this.f2800e = this.f2797b;
            if (this.f2799d == -1 || j > ((long) this.f2798c)) {
                j = j2 + inputStream.skip(j - j2);
            } else if (m4877a(inputStream, bArr) == -1) {
                j = j2;
            } else if (((long) (this.f2797b - this.f2800e)) >= j - j2) {
                this.f2800e = (int) ((j - j2) + ((long) this.f2800e));
            } else {
                j = (j2 + ((long) this.f2797b)) - ((long) this.f2800e);
                this.f2800e = this.f2797b;
            }
        }
        return j;
    }
}
