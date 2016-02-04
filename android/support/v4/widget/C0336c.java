package android.support.v4.widget;

import android.view.animation.AnimationUtils;

/* renamed from: android.support.v4.widget.c */
class C0336c {
    private int f1641a;
    private int f1642b;
    private float f1643c;
    private float f1644d;
    private long f1645e;
    private long f1646f;
    private int f1647g;
    private int f1648h;
    private long f1649i;
    private float f1650j;
    private int f1651k;

    public C0336c() {
        this.f1645e = Long.MIN_VALUE;
        this.f1649i = -1;
        this.f1646f = 0;
        this.f1647g = 0;
        this.f1648h = 0;
    }

    private float m3341a(float f) {
        return ((-4.0f * f) * f) + (4.0f * f);
    }

    private float m3342a(long j) {
        if (j < this.f1645e) {
            return 0.0f;
        }
        if (this.f1649i < 0 || j < this.f1649i) {
            return C0332a.m3084b(((float) (j - this.f1645e)) / ((float) this.f1641a), 0.0f, 1.0f) * 0.5f;
        }
        long j2 = j - this.f1649i;
        return (C0332a.m3084b(((float) j2) / ((float) this.f1651k), 0.0f, 1.0f) * this.f1650j) + (1.0f - this.f1650j);
    }

    public void m3343a() {
        this.f1645e = AnimationUtils.currentAnimationTimeMillis();
        this.f1649i = -1;
        this.f1646f = this.f1645e;
        this.f1650j = 0.5f;
        this.f1647g = 0;
        this.f1648h = 0;
    }

    public void m3344a(float f, float f2) {
        this.f1643c = f;
        this.f1644d = f2;
    }

    public void m3345a(int i) {
        this.f1641a = i;
    }

    public void m3346b() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f1651k = C0332a.m3085b((int) (currentAnimationTimeMillis - this.f1645e), 0, this.f1642b);
        this.f1650j = m3342a(currentAnimationTimeMillis);
        this.f1649i = currentAnimationTimeMillis;
    }

    public void m3347b(int i) {
        this.f1642b = i;
    }

    public boolean m3348c() {
        return this.f1649i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1649i + ((long) this.f1651k);
    }

    public void m3349d() {
        if (this.f1646f == 0) {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float a = m3341a(m3342a(currentAnimationTimeMillis));
        long j = currentAnimationTimeMillis - this.f1646f;
        this.f1646f = currentAnimationTimeMillis;
        this.f1647g = (int) ((((float) j) * a) * this.f1643c);
        this.f1648h = (int) ((((float) j) * a) * this.f1644d);
    }

    public int m3350e() {
        return (int) (this.f1643c / Math.abs(this.f1643c));
    }

    public int m3351f() {
        return (int) (this.f1644d / Math.abs(this.f1644d));
    }

    public int m3352g() {
        return this.f1647g;
    }

    public int m3353h() {
        return this.f1648h;
    }
}
