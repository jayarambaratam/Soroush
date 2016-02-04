package mobi.mmdt.ott.p095c.p096a.p098b.p099a;

import mobi.mmdt.ott.p095c.p096a.C1258f;

/* renamed from: mobi.mmdt.ott.c.a.b.a.al */
public class al extends C1198u {
    private boolean f4310a;
    private long f4311b;

    public al(String str, C1258f c1258f, int i, long j) {
        boolean z = true;
        super(str, c1258f);
        if (i != 1) {
            z = false;
        }
        this.f4310a = z;
        this.f4311b = 1000 * j;
    }

    public boolean m6648c() {
        return this.f4310a;
    }

    public long m6649d() {
        return this.f4311b;
    }
}
