package com.p032a.p033a.p036c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.a.a.c.a */
public class C0582a {
    private int f2464a;
    private int f2465b;
    private Integer f2466c;
    private int f2467d;
    private int f2468e;
    private int f2469f;
    private boolean f2470g;
    private OutputStream f2471h;
    private Bitmap f2472i;
    private byte[] f2473j;
    private byte[] f2474k;
    private int f2475l;
    private byte[] f2476m;
    private boolean[] f2477n;
    private int f2478o;
    private int f2479p;
    private boolean f2480q;
    private boolean f2481r;
    private boolean f2482s;
    private int f2483t;
    private boolean f2484u;

    public C0582a() {
        this.f2466c = null;
        this.f2468e = -1;
        this.f2469f = 0;
        this.f2470g = false;
        this.f2477n = new boolean[256];
        this.f2478o = 7;
        this.f2479p = -1;
        this.f2480q = false;
        this.f2481r = true;
        this.f2482s = false;
        this.f2483t = 10;
    }

    private void m4371a(String str) {
        for (int i = 0; i < str.length(); i++) {
            this.f2471h.write((byte) str.charAt(i));
        }
    }

    private int m4372b(int i) {
        int i2 = 0;
        if (this.f2476m == null) {
            return -1;
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int i3 = 16777216;
        int length = this.f2476m.length;
        int i4 = 0;
        while (i2 < length) {
            int i5 = i2 + 1;
            i2 = red - (this.f2476m[i2] & 255);
            int i6 = i5 + 1;
            int i7 = green - (this.f2476m[i5] & 255);
            i5 = blue - (this.f2476m[i6] & 255);
            i2 = ((i2 * i2) + (i7 * i7)) + (i5 * i5);
            i7 = i6 / 3;
            if (!this.f2477n[i7] || i2 >= i3) {
                i2 = i3;
                i3 = i4;
            } else {
                i3 = i7;
            }
            i4 = i3;
            i3 = i2;
            i2 = i6 + 1;
        }
        return i4;
    }

    private void m4373b() {
        int length = this.f2473j.length;
        int i = length / 3;
        this.f2474k = new byte[i];
        C0584c c0584c = new C0584c(this.f2473j, length, this.f2483t);
        this.f2476m = c0584c.m4403d();
        for (length = 0; length < this.f2476m.length; length += 3) {
            byte b = this.f2476m[length];
            this.f2476m[length] = this.f2476m[length + 2];
            this.f2476m[length + 2] = b;
            this.f2477n[length / 3] = false;
        }
        int i2 = 0;
        for (length = 0; length < i; length++) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            i2 = i4 + 1;
            int a = c0584c.m4396a(this.f2473j[i2] & 255, this.f2473j[i3] & 255, this.f2473j[i4] & 255);
            this.f2477n[a] = true;
            this.f2474k[length] = (byte) a;
        }
        this.f2473j = null;
        this.f2475l = 8;
        this.f2478o = 7;
        if (this.f2466c != null) {
            this.f2467d = m4372b(this.f2466c.intValue());
        } else if (this.f2484u) {
            this.f2467d = m4372b(0);
        }
    }

    private void m4374c() {
        boolean z = false;
        int width = this.f2472i.getWidth();
        int height = this.f2472i.getHeight();
        if (!(width == this.f2464a && height == this.f2465b)) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f2464a, this.f2465b, Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(createBitmap, 0.0f, 0.0f, null);
            this.f2472i = createBitmap;
        }
        int[] iArr = new int[(width * height)];
        this.f2472i.getPixels(iArr, 0, width, 0, 0, width, height);
        this.f2473j = new byte[(iArr.length * 3)];
        this.f2484u = false;
        int i = 0;
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 == 0) {
                i++;
            }
            int i4 = i2 + 1;
            this.f2473j[i2] = (byte) (i3 & 255);
            height = i4 + 1;
            this.f2473j[i4] = (byte) ((i3 >> 8) & 255);
            i2 = height + 1;
            this.f2473j[height] = (byte) ((i3 >> 16) & 255);
        }
        double length = ((double) (i * 100)) / ((double) iArr.length);
        if (length > 4.0d) {
            z = true;
        }
        this.f2484u = z;
        if (Log.isLoggable("AnimatedGifEncoder", 3)) {
            Log.d("AnimatedGifEncoder", "got pixels for frame with " + length + "% transparent pixels");
        }
    }

    private void m4375c(int i) {
        this.f2471h.write(i & 255);
        this.f2471h.write((i >> 8) & 255);
    }

    private void m4376d() {
        int i;
        int i2;
        this.f2471h.write(33);
        this.f2471h.write(249);
        this.f2471h.write(4);
        if (this.f2466c != null || this.f2484u) {
            i = 1;
            i2 = 2;
        } else {
            i2 = 0;
            i = 0;
        }
        if (this.f2479p >= 0) {
            i2 = this.f2479p & 7;
        }
        this.f2471h.write((((i2 << 2) | 0) | 0) | i);
        m4375c(this.f2469f);
        this.f2471h.write(this.f2467d);
        this.f2471h.write(0);
    }

    private void m4377e() {
        this.f2471h.write(44);
        m4375c(0);
        m4375c(0);
        m4375c(this.f2464a);
        m4375c(this.f2465b);
        if (this.f2481r) {
            this.f2471h.write(0);
        } else {
            this.f2471h.write(this.f2478o | 128);
        }
    }

    private void m4378f() {
        m4375c(this.f2464a);
        m4375c(this.f2465b);
        this.f2471h.write(this.f2478o | 240);
        this.f2471h.write(0);
        this.f2471h.write(0);
    }

    private void m4379g() {
        this.f2471h.write(33);
        this.f2471h.write(255);
        this.f2471h.write(11);
        m4371a("NETSCAPE2.0");
        this.f2471h.write(3);
        this.f2471h.write(1);
        m4375c(this.f2468e);
        this.f2471h.write(0);
    }

    private void m4380h() {
        this.f2471h.write(this.f2476m, 0, this.f2476m.length);
        int length = 768 - this.f2476m.length;
        for (int i = 0; i < length; i++) {
            this.f2471h.write(0);
        }
    }

    private void m4381i() {
        new C0583b(this.f2464a, this.f2465b, this.f2474k, this.f2475l).m4394b(this.f2471h);
    }

    public void m4382a(int i) {
        this.f2469f = Math.round(((float) i) / 10.0f);
    }

    public void m4383a(int i, int i2) {
        if (!this.f2470g || this.f2481r) {
            this.f2464a = i;
            this.f2465b = i2;
            if (this.f2464a < 1) {
                this.f2464a = 320;
            }
            if (this.f2465b < 1) {
                this.f2465b = 240;
            }
            this.f2482s = true;
        }
    }

    public boolean m4384a() {
        if (!this.f2470g) {
            return false;
        }
        boolean z;
        this.f2470g = false;
        try {
            this.f2471h.write(59);
            this.f2471h.flush();
            if (this.f2480q) {
                this.f2471h.close();
            }
            z = true;
        } catch (IOException e) {
            z = false;
        }
        this.f2467d = 0;
        this.f2471h = null;
        this.f2472i = null;
        this.f2473j = null;
        this.f2474k = null;
        this.f2476m = null;
        this.f2480q = false;
        this.f2481r = true;
        return z;
    }

    public boolean m4385a(Bitmap bitmap) {
        if (bitmap == null || !this.f2470g) {
            return false;
        }
        try {
            if (!this.f2482s) {
                m4383a(bitmap.getWidth(), bitmap.getHeight());
            }
            this.f2472i = bitmap;
            m4374c();
            m4373b();
            if (this.f2481r) {
                m4378f();
                m4380h();
                if (this.f2468e >= 0) {
                    m4379g();
                }
            }
            m4376d();
            m4377e();
            if (!this.f2481r) {
                m4380h();
            }
            m4381i();
            this.f2481r = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean m4386a(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.f2480q = false;
        this.f2471h = outputStream;
        try {
            m4371a("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.f2470g = z;
        return z;
    }
}
