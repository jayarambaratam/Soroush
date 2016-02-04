package p025b.p026a.p027a.p028a;

import android.view.View;

/* renamed from: b.a.a.a.g */
class C0560g implements Runnable {
    final /* synthetic */ C0557d f2331a;
    private final float f2332b;
    private final float f2333c;
    private final long f2334d;
    private final float f2335e;
    private final float f2336f;

    public C0560g(C0557d c0557d, float f, float f2, float f3, float f4) {
        this.f2331a = c0557d;
        this.f2332b = f3;
        this.f2333c = f4;
        this.f2334d = System.currentTimeMillis();
        this.f2335e = f;
        this.f2336f = f2;
    }

    private float m4220a() {
        return C0557d.f2300a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f2334d)) * 1.0f) / ((float) this.f2331a.f2305b)));
    }

    public void run() {
        View c = this.f2331a.m4211c();
        if (c != null) {
            float a = m4220a();
            this.f2331a.m4206a((this.f2335e + ((this.f2336f - this.f2335e) * a)) / this.f2331a.m4215g(), this.f2332b, this.f2333c);
            if (a < 1.0f) {
                C0547a.m4155a(c, this);
            }
        }
    }
}
