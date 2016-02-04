package mobi.mmdt.ott;

import com.p065c.p066a.p067a.p072e.C0955a;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;

/* renamed from: mobi.mmdt.ott.d */
class C1313d implements C0955a {
    final /* synthetic */ MyApplication f4584a;

    C1313d(MyApplication myApplication) {
        this.f4584a = myApplication;
    }

    public void m6984a(String str, Object... objArr) {
        C1104b.m6366b((Object) this, String.format(str, objArr));
    }

    public void m6985a(Throwable th, String str, Object... objArr) {
        C1104b.m6367b(this, String.format(str, objArr), th);
    }

    public boolean m6986a() {
        return true;
    }

    public void m6987b(String str, Object... objArr) {
        C1104b.m6362a((Object) this, String.format(str, objArr));
    }
}
