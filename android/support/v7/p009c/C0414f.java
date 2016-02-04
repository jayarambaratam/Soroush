package android.support.v7.p009c;

/* renamed from: android.support.v7.c.f */
final class C0414f implements C0413i {
    C0414f() {
    }

    private boolean m3939a(float[] fArr) {
        return fArr[2] <= 0.05f;
    }

    private boolean m3940b(float[] fArr) {
        return fArr[2] >= 0.95f;
    }

    private boolean m3941c(float[] fArr) {
        return fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f;
    }

    public boolean m3942a(int i, float[] fArr) {
        return (m3940b(fArr) || m3939a(fArr) || m3941c(fArr)) ? false : true;
    }
}
