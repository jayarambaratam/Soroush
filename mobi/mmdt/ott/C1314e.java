package mobi.mmdt.ott;

import com.p065c.p066a.p067a.p072e.C0955a;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;

/* renamed from: mobi.mmdt.ott.e */
class C1314e implements C0955a {
    final /* synthetic */ MyApplication f4585a;

    C1314e(MyApplication myApplication) {
        this.f4585a = myApplication;
    }

    public void m6988a(String str, Object... objArr) {
        C1104b.m6366b((Object) this, String.format(str, objArr));
    }

    public void m6989a(Throwable th, String str, Object... objArr) {
        C1104b.m6367b(this, String.format(str, objArr), th);
    }

    public boolean m6990a() {
        return true;
    }

    public void m6991b(String str, Object... objArr) {
        C1104b.m6362a((Object) this, String.format(str, objArr));
    }
}
