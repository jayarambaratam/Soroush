package mobi.mmdt.ott;

import com.p065c.p066a.p067a.p072e.C0955a;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;

/* renamed from: mobi.mmdt.ott.c */
class C1304c implements C0955a {
    final /* synthetic */ MyApplication f4519a;

    C1304c(MyApplication myApplication) {
        this.f4519a = myApplication;
    }

    public void m6883a(String str, Object... objArr) {
        C1104b.m6366b((Object) this, String.format(str, objArr));
    }

    public void m6884a(Throwable th, String str, Object... objArr) {
        C1104b.m6367b(this, String.format(str, objArr), th);
    }

    public boolean m6885a() {
        return true;
    }

    public void m6886b(String str, Object... objArr) {
        C1104b.m6362a((Object) this, String.format(str, objArr));
    }
}
