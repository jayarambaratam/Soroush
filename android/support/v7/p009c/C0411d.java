package android.support.v7.p009c;

import android.support.v4.p013c.C0198a;
import java.util.List;

/* renamed from: android.support.v7.c.d */
class C0411d extends C0410j {
    private List<C0418l> f2023a;
    private int f2024b;
    private C0418l f2025c;
    private C0418l f2026d;
    private C0418l f2027e;
    private C0418l f2028f;
    private C0418l f2029g;
    private C0418l f2030h;

    C0411d() {
    }

    private static float m3920a(float f, float f2) {
        return 1.0f - Math.abs(f - f2);
    }

    private static float m3921a(float f, float f2, float f3, float f4, float f5, float f6, int i, int i2, float f7) {
        return C0411d.m3923a(C0411d.m3920a(f, f2), f3, C0411d.m3920a(f4, f5), f6, ((float) i) / ((float) i2), f7);
    }

    private static float m3922a(float f, float f2, float f3, float f4, int i, int i2) {
        return C0411d.m3921a(f, f2, 3.0f, f3, f4, 6.0f, i, i2, 1.0f);
    }

    private static float m3923a(float... fArr) {
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < fArr.length; i += 2) {
            float f3 = fArr[i];
            float f4 = fArr[i + 1];
            f2 += f3 * f4;
            f += f4;
        }
        return f2 / f;
    }

    private C0418l m3924a(float f, float f2, float f3, float f4, float f5, float f6) {
        C0418l c0418l = null;
        float f7 = 0.0f;
        for (C0418l c0418l2 : this.f2023a) {
            float f8 = c0418l2.m3951b()[1];
            float f9 = c0418l2.m3951b()[2];
            if (f8 >= f5 && f8 <= f6 && f9 >= f2 && f9 <= f3 && !m3925a(c0418l2)) {
                f8 = C0411d.m3922a(f8, f4, f9, f, c0418l2.m3952c(), this.f2024b);
                if (c0418l != null) {
                    if (f8 > f7) {
                    }
                }
                f7 = f8;
                c0418l = c0418l2;
            }
            f8 = f7;
            C0418l c0418l22 = c0418l;
            f7 = f8;
            c0418l = c0418l22;
        }
        return c0418l;
    }

    private boolean m3925a(C0418l c0418l) {
        return this.f2025c == c0418l || this.f2027e == c0418l || this.f2029g == c0418l || this.f2026d == c0418l || this.f2028f == c0418l || this.f2030h == c0418l;
    }

    private void m3926b() {
        this.f2025c = m3924a(0.5f, 0.3f, 0.7f, 1.0f, 0.35f, 1.0f);
        this.f2029g = m3924a(0.74f, 0.55f, 1.0f, 1.0f, 0.35f, 1.0f);
        this.f2027e = m3924a(0.26f, 0.0f, 0.45f, 1.0f, 0.35f, 1.0f);
        this.f2026d = m3924a(0.5f, 0.3f, 0.7f, 0.3f, 0.0f, 0.4f);
        this.f2030h = m3924a(0.74f, 0.55f, 1.0f, 0.3f, 0.0f, 0.4f);
        this.f2028f = m3924a(0.26f, 0.0f, 0.45f, 0.3f, 0.0f, 0.4f);
    }

    private static float[] m3927b(C0418l c0418l) {
        Object obj = new float[3];
        System.arraycopy(c0418l.m3951b(), 0, obj, 0, 3);
        return obj;
    }

    private void m3928c() {
        if (this.f2025c == null && this.f2027e != null) {
            float[] b = C0411d.m3927b(this.f2027e);
            b[2] = 0.5f;
            this.f2025c = new C0418l(C0198a.m1621a(b), 0);
        }
        if (this.f2027e == null && this.f2025c != null) {
            b = C0411d.m3927b(this.f2025c);
            b[2] = 0.26f;
            this.f2027e = new C0418l(C0198a.m1621a(b), 0);
        }
    }

    private int m3929d() {
        int i = 0;
        for (C0418l c : this.f2023a) {
            i = Math.max(i, c.m3952c());
        }
        return i;
    }

    public C0418l m3930a() {
        return this.f2025c;
    }

    public void m3931a(List<C0418l> list) {
        this.f2023a = list;
        this.f2024b = m3929d();
        m3926b();
        m3928c();
    }
}
