package com.p032a.p033a.p036c;

import android.support.v7.widget.RecyclerView.ItemAnimator;
import java.io.OutputStream;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;

/* renamed from: com.a.a.c.b */
class C0583b {
    int f2485a;
    int f2486b;
    int f2487c;
    int f2488d;
    int[] f2489e;
    int[] f2490f;
    int f2491g;
    int f2492h;
    boolean f2493i;
    int f2494j;
    int f2495k;
    int f2496l;
    int f2497m;
    int f2498n;
    int[] f2499o;
    int f2500p;
    byte[] f2501q;
    private int f2502r;
    private int f2503s;
    private byte[] f2504t;
    private int f2505u;
    private int f2506v;
    private int f2507w;

    C0583b(int i, int i2, byte[] bArr, int i3) {
        this.f2486b = 12;
        this.f2488d = ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;
        this.f2489e = new int[5003];
        this.f2490f = new int[5003];
        this.f2491g = 5003;
        this.f2492h = 0;
        this.f2493i = false;
        this.f2497m = 0;
        this.f2498n = 0;
        this.f2499o = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, InBandBytestreamManager.MAXIMUM_BLOCK_SIZE};
        this.f2501q = new byte[256];
        this.f2502r = i;
        this.f2503s = i2;
        this.f2504t = bArr;
        this.f2505u = Math.max(2, i3);
    }

    private int m4387a() {
        if (this.f2506v == 0) {
            return -1;
        }
        this.f2506v--;
        byte[] bArr = this.f2504t;
        int i = this.f2507w;
        this.f2507w = i + 1;
        return bArr[i] & 255;
    }

    void m4388a(byte b, OutputStream outputStream) {
        byte[] bArr = this.f2501q;
        int i = this.f2500p;
        this.f2500p = i + 1;
        bArr[i] = b;
        if (this.f2500p >= 254) {
            m4395c(outputStream);
        }
    }

    void m4389a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f2489e[i2] = -1;
        }
    }

    void m4390a(int i, OutputStream outputStream) {
        int i2;
        int i3 = 0;
        this.f2494j = i;
        this.f2493i = false;
        this.f2485a = this.f2494j;
        this.f2487c = m4392b(this.f2485a);
        this.f2495k = 1 << (i - 1);
        this.f2496l = this.f2495k + 1;
        this.f2492h = this.f2495k + 2;
        this.f2500p = 0;
        int a = m4387a();
        for (i2 = this.f2491g; i2 < 65536; i2 *= 2) {
            i3++;
        }
        int i4 = 8 - i3;
        int i5 = this.f2491g;
        m4389a(i5);
        m4393b(this.f2495k, outputStream);
        while (true) {
            i3 = m4387a();
            if (i3 != -1) {
                int i6 = (i3 << this.f2486b) + a;
                i2 = (i3 << i4) ^ a;
                if (this.f2489e[i2] == i6) {
                    a = this.f2490f[i2];
                } else if (this.f2489e[i2] >= 0) {
                    r3 = i5 - i2;
                    if (i2 == 0) {
                        r3 = 1;
                    }
                    do {
                        i2 -= r3;
                        if (i2 < 0) {
                            i2 += i5;
                        }
                        if (this.f2489e[i2] == i6) {
                            a = this.f2490f[i2];
                            break;
                        }
                    } while (this.f2489e[i2] >= 0);
                    m4393b(a, outputStream);
                    if (this.f2492h >= this.f2488d) {
                        r0 = this.f2490f;
                        r3 = this.f2492h;
                        this.f2492h = r3 + 1;
                        r0[i2] = r3;
                        this.f2489e[i2] = i6;
                        a = i3;
                    } else {
                        m4391a(outputStream);
                        a = i3;
                    }
                } else {
                    m4393b(a, outputStream);
                    if (this.f2492h >= this.f2488d) {
                        m4391a(outputStream);
                        a = i3;
                    } else {
                        r0 = this.f2490f;
                        r3 = this.f2492h;
                        this.f2492h = r3 + 1;
                        r0[i2] = r3;
                        this.f2489e[i2] = i6;
                        a = i3;
                    }
                }
            } else {
                m4393b(a, outputStream);
                m4393b(this.f2496l, outputStream);
                return;
            }
        }
    }

    void m4391a(OutputStream outputStream) {
        m4389a(this.f2491g);
        this.f2492h = this.f2495k + 2;
        this.f2493i = true;
        m4393b(this.f2495k, outputStream);
    }

    final int m4392b(int i) {
        return (1 << i) - 1;
    }

    void m4393b(int i, OutputStream outputStream) {
        this.f2497m &= this.f2499o[this.f2498n];
        if (this.f2498n > 0) {
            this.f2497m |= i << this.f2498n;
        } else {
            this.f2497m = i;
        }
        this.f2498n += this.f2485a;
        while (this.f2498n >= 8) {
            m4388a((byte) (this.f2497m & 255), outputStream);
            this.f2497m >>= 8;
            this.f2498n -= 8;
        }
        if (this.f2492h > this.f2487c || this.f2493i) {
            if (this.f2493i) {
                int i2 = this.f2494j;
                this.f2485a = i2;
                this.f2487c = m4392b(i2);
                this.f2493i = false;
            } else {
                this.f2485a++;
                if (this.f2485a == this.f2486b) {
                    this.f2487c = this.f2488d;
                } else {
                    this.f2487c = m4392b(this.f2485a);
                }
            }
        }
        if (i == this.f2496l) {
            while (this.f2498n > 0) {
                m4388a((byte) (this.f2497m & 255), outputStream);
                this.f2497m >>= 8;
                this.f2498n -= 8;
            }
            m4395c(outputStream);
        }
    }

    void m4394b(OutputStream outputStream) {
        outputStream.write(this.f2505u);
        this.f2506v = this.f2502r * this.f2503s;
        this.f2507w = 0;
        m4390a(this.f2505u + 1, outputStream);
        outputStream.write(0);
    }

    void m4395c(OutputStream outputStream) {
        if (this.f2500p > 0) {
            outputStream.write(this.f2500p);
            outputStream.write(this.f2501q, 0, this.f2500p);
            this.f2500p = 0;
        }
    }
}
