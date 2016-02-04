package android.support.v4.p011a;

/* renamed from: android.support.v4.a.g */
class C0120g implements Runnable {
    final /* synthetic */ C0119f f707a;

    C0120g(C0119f c0119f) {
        this.f707a = c0119f;
    }

    public void run() {
        float a = (((float) (this.f707a.m918e() - this.f707a.f701d)) * 1.0f) / ((float) this.f707a.f702e);
        if (a > 1.0f || this.f707a.f700c.getParent() == null) {
            a = 1.0f;
        }
        this.f707a.f703f = a;
        this.f707a.m915d();
        if (this.f707a.f703f >= 1.0f) {
            this.f707a.m922g();
        } else {
            this.f707a.f700c.postDelayed(this.f707a.f706i, 16);
        }
    }
}
