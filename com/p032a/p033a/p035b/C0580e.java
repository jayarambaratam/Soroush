package com.p032a.p033a.p035b;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import mobi.mmdt.ott.C1317h;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;

/* renamed from: com.a.a.b.e */
public class C0580e {
    private final byte[] f2456a;
    private ByteBuffer f2457b;
    private C0579d f2458c;
    private int f2459d;

    public C0580e() {
        this.f2456a = new byte[256];
        this.f2459d = 0;
    }

    private int[] m4353a(int i) {
        int[] iArr;
        Throwable e;
        int i2 = 0;
        byte[] bArr = new byte[(i * 3)];
        try {
            this.f2457b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = bArr[i3] & 255;
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    i3 = i6 + 1;
                    i4 = i2 + 1;
                    iArr[i2] = (((i5 << 16) | -16777216) | (i7 << 8)) | (bArr[i6] & 255);
                    i2 = i4;
                } catch (BufferUnderflowException e2) {
                    e = e2;
                }
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            iArr = null;
            e = th;
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.f2458c.f2444b = 1;
            return iArr;
        }
        return iArr;
    }

    private void m4354c() {
        this.f2457b = null;
        Arrays.fill(this.f2456a, (byte) 0);
        this.f2458c = new C0579d();
        this.f2459d = 0;
    }

    private void m4355d() {
        int i = 0;
        while (i == 0 && !m4366o()) {
            switch (m4364m()) {
                case C1317h.Theme_actionModeCopyDrawable /*33*/:
                    switch (m4364m()) {
                        case VideoSize.CIF /*1*/:
                            m4362k();
                            break;
                        case 249:
                            this.f2458c.f2446d = new C0578c();
                            m4356e();
                            break;
                        case 254:
                            m4362k();
                            break;
                        case 255:
                            m4363l();
                            String str = BuildConfig.FLAVOR;
                            for (int i2 = 0; i2 < 11; i2++) {
                                str = str + ((char) this.f2456a[i2]);
                            }
                            if (!str.equals("NETSCAPE2.0")) {
                                m4362k();
                                break;
                            } else {
                                m4358g();
                                break;
                            }
                        default:
                            m4362k();
                            break;
                    }
                case C1317h.Theme_listDividerAlertDialog /*44*/:
                    if (this.f2458c.f2446d == null) {
                        this.f2458c.f2446d = new C0578c();
                    }
                    m4357f();
                    break;
                case C1317h.Theme_toolbarNavigationButtonStyle /*59*/:
                    i = 1;
                    break;
                default:
                    this.f2458c.f2444b = 1;
                    break;
            }
        }
    }

    private void m4356e() {
        boolean z = true;
        m4364m();
        int m = m4364m();
        this.f2458c.f2446d.f2438g = (m & 28) >> 2;
        if (this.f2458c.f2446d.f2438g == 0) {
            this.f2458c.f2446d.f2438g = 1;
        }
        C0578c c0578c = this.f2458c.f2446d;
        if ((m & 1) == 0) {
            z = false;
        }
        c0578c.f2437f = z;
        int n = m4365n();
        if (n < 3) {
            n = 10;
        }
        this.f2458c.f2446d.f2440i = n * 10;
        this.f2458c.f2446d.f2439h = m4364m();
        m4364m();
    }

    private void m4357f() {
        boolean z = true;
        this.f2458c.f2446d.f2432a = m4365n();
        this.f2458c.f2446d.f2433b = m4365n();
        this.f2458c.f2446d.f2434c = m4365n();
        this.f2458c.f2446d.f2435d = m4365n();
        int m = m4364m();
        boolean z2 = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((m & 7) + 1));
        C0578c c0578c = this.f2458c.f2446d;
        if ((m & 64) == 0) {
            z = false;
        }
        c0578c.f2436e = z;
        if (z2) {
            this.f2458c.f2446d.f2442k = m4353a(pow);
        } else {
            this.f2458c.f2446d.f2442k = null;
        }
        this.f2458c.f2446d.f2441j = this.f2457b.position();
        m4361j();
        if (!m4366o()) {
            C0579d c0579d = this.f2458c;
            c0579d.f2445c++;
            this.f2458c.f2447e.add(this.f2458c.f2446d);
        }
    }

    private void m4358g() {
        do {
            m4363l();
            if (this.f2456a[0] == (byte) 1) {
                this.f2458c.f2455m = (this.f2456a[1] & 255) | ((this.f2456a[2] & 255) << 8);
            }
            if (this.f2459d <= 0) {
                return;
            }
        } while (!m4366o());
    }

    private void m4359h() {
        String str = BuildConfig.FLAVOR;
        for (int i = 0; i < 6; i++) {
            str = str + ((char) m4364m());
        }
        if (str.startsWith("GIF")) {
            m4360i();
            if (this.f2458c.f2450h && !m4366o()) {
                this.f2458c.f2443a = m4353a(this.f2458c.f2451i);
                this.f2458c.f2454l = this.f2458c.f2443a[this.f2458c.f2452j];
                return;
            }
            return;
        }
        this.f2458c.f2444b = 1;
    }

    private void m4360i() {
        this.f2458c.f2448f = m4365n();
        this.f2458c.f2449g = m4365n();
        int m = m4364m();
        this.f2458c.f2450h = (m & 128) != 0;
        this.f2458c.f2451i = 2 << (m & 7);
        this.f2458c.f2452j = m4364m();
        this.f2458c.f2453k = m4364m();
    }

    private void m4361j() {
        m4364m();
        m4362k();
    }

    private void m4362k() {
        int m;
        do {
            m = m4364m();
            this.f2457b.position(this.f2457b.position() + m);
        } while (m > 0);
    }

    private int m4363l() {
        int i = 0;
        this.f2459d = m4364m();
        if (this.f2459d > 0) {
            int i2 = 0;
            while (i < this.f2459d) {
                try {
                    i2 = this.f2459d - i;
                    this.f2457b.get(this.f2456a, i, i2);
                    i += i2;
                } catch (Throwable e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f2459d, e);
                    }
                    this.f2458c.f2444b = 1;
                }
            }
        }
        return i;
    }

    private int m4364m() {
        int i = 0;
        try {
            return this.f2457b.get() & 255;
        } catch (Exception e) {
            this.f2458c.f2444b = 1;
            return i;
        }
    }

    private int m4365n() {
        return this.f2457b.getShort();
    }

    private boolean m4366o() {
        return this.f2458c.f2444b != 0;
    }

    public C0580e m4367a(byte[] bArr) {
        m4354c();
        if (bArr != null) {
            this.f2457b = ByteBuffer.wrap(bArr);
            this.f2457b.rewind();
            this.f2457b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f2457b = null;
            this.f2458c.f2444b = 2;
        }
        return this;
    }

    public void m4368a() {
        this.f2457b = null;
        this.f2458c = null;
    }

    public C0579d m4369b() {
        if (this.f2457b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (m4366o()) {
            return this.f2458c;
        } else {
            m4359h();
            if (!m4366o()) {
                m4355d();
                if (this.f2458c.f2445c < 0) {
                    this.f2458c.f2444b = 1;
                }
            }
            return this.f2458c;
        }
    }
}
