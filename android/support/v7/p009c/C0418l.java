package android.support.v7.p009c;

import android.graphics.Color;
import android.support.v4.p013c.C0198a;
import java.util.Arrays;

/* renamed from: android.support.v7.c.l */
public final class C0418l {
    private final int f2043a;
    private final int f2044b;
    private final int f2045c;
    private final int f2046d;
    private final int f2047e;
    private boolean f2048f;
    private int f2049g;
    private int f2050h;
    private float[] f2051i;

    public C0418l(int i, int i2) {
        this.f2043a = Color.red(i);
        this.f2044b = Color.green(i);
        this.f2045c = Color.blue(i);
        this.f2046d = i;
        this.f2047e = i2;
    }

    private void m3949f() {
        if (!this.f2048f) {
            int a = C0198a.m1618a(-1, this.f2046d, 4.5f);
            int a2 = C0198a.m1618a(-1, this.f2046d, 3.0f);
            if (a == -1 || a2 == -1) {
                int a3 = C0198a.m1618a(-16777216, this.f2046d, 4.5f);
                int a4 = C0198a.m1618a(-16777216, this.f2046d, 3.0f);
                if (a3 == -1 || a3 == -1) {
                    this.f2050h = a != -1 ? C0198a.m1625c(-1, a) : C0198a.m1625c(-16777216, a3);
                    this.f2049g = a2 != -1 ? C0198a.m1625c(-1, a2) : C0198a.m1625c(-16777216, a4);
                    this.f2048f = true;
                    return;
                }
                this.f2050h = C0198a.m1625c(-16777216, a3);
                this.f2049g = C0198a.m1625c(-16777216, a4);
                this.f2048f = true;
                return;
            }
            this.f2050h = C0198a.m1625c(-1, a);
            this.f2049g = C0198a.m1625c(-1, a2);
            this.f2048f = true;
        }
    }

    public int m3950a() {
        return this.f2046d;
    }

    public float[] m3951b() {
        if (this.f2051i == null) {
            this.f2051i = new float[3];
            C0198a.m1622a(this.f2043a, this.f2044b, this.f2045c, this.f2051i);
        }
        return this.f2051i;
    }

    public int m3952c() {
        return this.f2047e;
    }

    public int m3953d() {
        m3949f();
        return this.f2049g;
    }

    public int m3954e() {
        m3949f();
        return this.f2050h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0418l c0418l = (C0418l) obj;
        return this.f2047e == c0418l.f2047e && this.f2046d == c0418l.f2046d;
    }

    public int hashCode() {
        return (this.f2046d * 31) + this.f2047e;
    }

    public String toString() {
        return new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(m3950a())).append(']').append(" [HSL: ").append(Arrays.toString(m3951b())).append(']').append(" [Population: ").append(this.f2047e).append(']').append(" [Title Text: #").append(Integer.toHexString(m3953d())).append(']').append(" [Body Text: #").append(Integer.toHexString(m3954e())).append(']').toString();
    }
}
