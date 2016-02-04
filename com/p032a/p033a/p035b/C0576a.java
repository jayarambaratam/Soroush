package com.p032a.p033a.p035b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: com.a.a.b.a */
public class C0576a {
    private static final String f2415a;
    private static final Config f2416b;
    private int[] f2417c;
    private ByteBuffer f2418d;
    private final byte[] f2419e;
    private short[] f2420f;
    private byte[] f2421g;
    private byte[] f2422h;
    private byte[] f2423i;
    private int[] f2424j;
    private int f2425k;
    private byte[] f2426l;
    private C0579d f2427m;
    private C0577b f2428n;
    private Bitmap f2429o;
    private boolean f2430p;
    private int f2431q;

    static {
        f2415a = C0576a.class.getSimpleName();
        f2416b = Config.ARGB_8888;
    }

    public C0576a(C0577b c0577b) {
        this.f2419e = new byte[256];
        this.f2428n = c0577b;
        this.f2427m = new C0579d();
    }

    private Bitmap m4334a(C0578c c0578c, C0578c c0578c2) {
        int i;
        int i2 = this.f2427m.f2448f;
        int i3 = this.f2427m.f2449g;
        int[] iArr = this.f2424j;
        if (c0578c2 != null && c0578c2.f2438g > 0) {
            if (c0578c2.f2438g == 2) {
                i = 0;
                if (!c0578c.f2437f) {
                    i = this.f2427m.f2454l;
                }
                Arrays.fill(iArr, i);
            } else if (c0578c2.f2438g == 3 && this.f2429o != null) {
                this.f2429o.getPixels(iArr, 0, i2, 0, 0, i2, i3);
            }
        }
        m4336a(c0578c);
        int i4 = 1;
        int i5 = 8;
        int i6 = 0;
        for (i = 0; i < c0578c.f2435d; i++) {
            int i7;
            if (c0578c.f2436e) {
                if (i6 >= c0578c.f2435d) {
                    i4++;
                    switch (i4) {
                        case VideoSize.HVGA /*2*/:
                            i6 = 4;
                            break;
                        case Version.API03_CUPCAKE_15 /*3*/:
                            i6 = 2;
                            i5 = 4;
                            break;
                        case Version.API04_DONUT_16 /*4*/:
                            i6 = 1;
                            i5 = 2;
                            break;
                    }
                }
                int i8 = i6;
                i6 += i5;
                i7 = i8;
            } else {
                i7 = i;
            }
            i7 += c0578c.f2433b;
            if (i7 < this.f2427m.f2449g) {
                int i9 = this.f2427m.f2448f * i7;
                int i10 = i9 + c0578c.f2432a;
                i7 = c0578c.f2434c + i10;
                if (this.f2427m.f2448f + i9 < i7) {
                    i7 = this.f2427m.f2448f + i9;
                }
                i9 = c0578c.f2434c * i;
                int i11 = i10;
                while (i11 < i7) {
                    i10 = i9 + 1;
                    i9 = this.f2417c[this.f2423i[i9] & 255];
                    if (i9 != 0) {
                        iArr[i11] = i9;
                    }
                    i11++;
                    i9 = i10;
                }
            }
        }
        if (this.f2430p && (c0578c.f2438g == 0 || c0578c.f2438g == 1)) {
            if (this.f2429o == null) {
                this.f2429o = m4339j();
            }
            this.f2429o.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        }
        Bitmap j = m4339j();
        j.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        return j;
    }

    @TargetApi(12)
    private static void m4335a(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }

    private void m4336a(C0578c c0578c) {
        int i;
        if (c0578c != null) {
            this.f2418d.position(c0578c.f2441j);
        }
        int i2 = c0578c == null ? this.f2427m.f2448f * this.f2427m.f2449g : c0578c.f2434c * c0578c.f2435d;
        if (this.f2423i == null || this.f2423i.length < i2) {
            this.f2423i = new byte[i2];
        }
        if (this.f2420f == null) {
            this.f2420f = new short[ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT];
        }
        if (this.f2421g == null) {
            this.f2421g = new byte[ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT];
        }
        if (this.f2422h == null) {
            this.f2422h = new byte[4097];
        }
        int h = m4337h();
        int i3 = 1 << h;
        int i4 = i3 + 1;
        int i5 = i3 + 2;
        int i6 = -1;
        int i7 = h + 1;
        int i8 = (1 << i7) - 1;
        for (i = 0; i < i3; i++) {
            this.f2420f[i] = (short) 0;
            this.f2421g[i] = (byte) i;
        }
        i = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = i7;
        int i14 = i8;
        int i15 = i5;
        i7 = 0;
        i8 = 0;
        i5 = 0;
        while (i9 < i2) {
            if (i8 == 0) {
                i8 = m4338i();
                if (i8 <= 0) {
                    this.f2431q = 3;
                    break;
                }
                i7 = 0;
            }
            i += (this.f2419e[i7] & 255) << i12;
            int i16 = i7 + 1;
            int i17 = i8 - 1;
            i7 = i13;
            i8 = i14;
            i13 = i11;
            int i18 = i12 + 8;
            i12 = i;
            i = i5;
            i5 = i15;
            i15 = i18;
            while (i15 >= i7) {
                i11 = i12 & i8;
                i14 = i12 >> i7;
                i15 -= i7;
                if (i11 == i3) {
                    i7 = h + 1;
                    i8 = (1 << i7) - 1;
                    i5 = i3 + 2;
                    i12 = i14;
                    i6 = -1;
                } else if (i11 > i5) {
                    this.f2431q = 3;
                    i11 = i13;
                    i12 = i15;
                    i13 = i7;
                    i15 = i5;
                    i7 = i16;
                    i5 = i;
                    i = i14;
                    i14 = i8;
                    i8 = i17;
                    break;
                } else if (i11 == i4) {
                    i11 = i13;
                    i12 = i15;
                    i13 = i7;
                    i15 = i5;
                    i7 = i16;
                    i5 = i;
                    i = i14;
                    i14 = i8;
                    i8 = i17;
                    break;
                } else if (i6 == -1) {
                    i12 = i10 + 1;
                    this.f2422h[i10] = this.f2421g[i11];
                    i10 = i12;
                    i13 = i11;
                    i6 = i11;
                    i12 = i14;
                } else {
                    if (i11 >= i5) {
                        i12 = i10 + 1;
                        this.f2422h[i10] = (byte) i13;
                        i10 = i12;
                        i13 = i6;
                    } else {
                        i13 = i11;
                    }
                    while (i13 >= i3) {
                        i12 = i10 + 1;
                        this.f2422h[i10] = this.f2421g[i13];
                        short s = this.f2420f[i13];
                        i10 = i12;
                    }
                    i13 = this.f2421g[i13] & 255;
                    i12 = i10 + 1;
                    this.f2422h[i10] = (byte) i13;
                    if (i5 < ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT) {
                        this.f2420f[i5] = (short) i6;
                        this.f2421g[i5] = (byte) i13;
                        i5++;
                        if ((i5 & i8) == 0 && i5 < ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT) {
                            i7++;
                            i8 += i5;
                        }
                    }
                    i10 = i9;
                    while (i12 > 0) {
                        i9 = i12 - 1;
                        i12 = i + 1;
                        this.f2423i[i] = this.f2422h[i9];
                        i10++;
                        i = i12;
                        i12 = i9;
                    }
                    i9 = i10;
                    i6 = i11;
                    i10 = i12;
                    i12 = i14;
                }
            }
            i11 = i13;
            i14 = i8;
            i8 = i17;
            i13 = i7;
            i7 = i16;
            i18 = i15;
            i15 = i5;
            i5 = i;
            i = i12;
            i12 = i18;
        }
        for (i7 = i5; i7 < i2; i7++) {
            this.f2423i[i7] = (byte) 0;
        }
    }

    private int m4337h() {
        int i = 0;
        try {
            return this.f2418d.get() & 255;
        } catch (Exception e) {
            this.f2431q = 1;
            return i;
        }
    }

    private int m4338i() {
        int h = m4337h();
        int i = 0;
        if (h > 0) {
            while (i < h) {
                int i2 = h - i;
                try {
                    this.f2418d.get(this.f2419e, i, i2);
                    i += i2;
                } catch (Throwable e) {
                    Log.w(f2415a, "Error Reading Block", e);
                    this.f2431q = 1;
                }
            }
        }
        return i;
    }

    private Bitmap m4339j() {
        Bitmap a = this.f2428n.m4349a(this.f2427m.f2448f, this.f2427m.f2449g, f2416b);
        if (a == null) {
            a = Bitmap.createBitmap(this.f2427m.f2448f, this.f2427m.f2449g, f2416b);
        }
        C0576a.m4335a(a);
        return a;
    }

    public int m4340a(int i) {
        return (i < 0 || i >= this.f2427m.f2445c) ? -1 : ((C0578c) this.f2427m.f2447e.get(i)).f2440i;
    }

    public void m4341a() {
        this.f2425k = (this.f2425k + 1) % this.f2427m.f2445c;
    }

    public void m4342a(C0579d c0579d, byte[] bArr) {
        this.f2427m = c0579d;
        this.f2426l = bArr;
        this.f2431q = 0;
        this.f2425k = -1;
        this.f2418d = ByteBuffer.wrap(bArr);
        this.f2418d.rewind();
        this.f2418d.order(ByteOrder.LITTLE_ENDIAN);
        this.f2430p = false;
        for (C0578c c0578c : c0579d.f2447e) {
            if (c0578c.f2438g == 3) {
                this.f2430p = true;
                break;
            }
        }
        this.f2423i = new byte[(c0579d.f2448f * c0579d.f2449g)];
        this.f2424j = new int[(c0579d.f2448f * c0579d.f2449g)];
    }

    public int m4343b() {
        return (this.f2427m.f2445c <= 0 || this.f2425k < 0) ? -1 : m4340a(this.f2425k);
    }

    public int m4344c() {
        return this.f2427m.f2445c;
    }

    public int m4345d() {
        return this.f2425k;
    }

    public int m4346e() {
        return this.f2427m.f2455m;
    }

    public synchronized Bitmap m4347f() {
        Bitmap bitmap;
        int i = 0;
        synchronized (this) {
            if (this.f2427m.f2445c <= 0 || this.f2425k < 0) {
                if (Log.isLoggable(f2415a, 3)) {
                    Log.d(f2415a, "unable to decode frame, frameCount=" + this.f2427m.f2445c + " framePointer=" + this.f2425k);
                }
                this.f2431q = 1;
            }
            if (this.f2431q == 1 || this.f2431q == 2) {
                if (Log.isLoggable(f2415a, 3)) {
                    Log.d(f2415a, "Unable to decode frame, status=" + this.f2431q);
                }
                bitmap = null;
            } else {
                this.f2431q = 0;
                C0578c c0578c = (C0578c) this.f2427m.f2447e.get(this.f2425k);
                int i2 = this.f2425k - 1;
                C0578c c0578c2 = i2 >= 0 ? (C0578c) this.f2427m.f2447e.get(i2) : null;
                if (c0578c.f2442k == null) {
                    this.f2417c = this.f2427m.f2443a;
                } else {
                    this.f2417c = c0578c.f2442k;
                    if (this.f2427m.f2452j == c0578c.f2439h) {
                        this.f2427m.f2454l = 0;
                    }
                }
                if (c0578c.f2437f) {
                    i2 = this.f2417c[c0578c.f2439h];
                    this.f2417c[c0578c.f2439h] = 0;
                    i = i2;
                }
                if (this.f2417c == null) {
                    if (Log.isLoggable(f2415a, 3)) {
                        Log.d(f2415a, "No Valid Color Table");
                    }
                    this.f2431q = 1;
                    bitmap = null;
                } else {
                    Bitmap a = m4334a(c0578c, c0578c2);
                    if (c0578c.f2437f) {
                        this.f2417c[c0578c.f2439h] = i;
                    }
                    bitmap = a;
                }
            }
        }
        return bitmap;
    }

    public void m4348g() {
        this.f2427m = null;
        this.f2426l = null;
        this.f2423i = null;
        this.f2424j = null;
        if (this.f2429o != null) {
            this.f2428n.m4350a(this.f2429o);
        }
        this.f2429o = null;
    }
}
