package mobi.mmdt.ott.logic.p161g;

import android.content.Context;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.logic.g.c */
public class C1530c {
    private static C1530c f5126a;
    private String f5127b;
    private final Context f5128c;
    private final C1534g f5129d;
    private boolean f5130e;
    private boolean f5131f;

    private C1530c(Context context) {
        this.f5127b = BuildConfig.FLAVOR;
        this.f5130e = false;
        this.f5131f = false;
        this.f5128c = context;
        this.f5129d = C1534g.m7722a(this.f5128c);
        this.f5129d.m7738a(new C1532d(this));
    }

    public static C1530c m7703a(Context context) {
        if (f5126a == null) {
            f5126a = new C1530c(context);
        }
        return f5126a;
    }

    public void m7709a() {
        if (this.f5129d != null) {
            this.f5129d.m7745f();
        }
    }

    public synchronized void m7710a(String str) {
        try {
            Thread.sleep(2000);
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
        if (this.f5129d != null) {
            this.f5129d.m7737a(str, str);
        }
        try {
            Thread.sleep(300);
        } catch (Throwable e2) {
            C1104b.m6368b((Object) this, e2);
        }
    }

    public void m7711a(boolean z) {
        if (this.f5129d != null) {
            this.f5129d.m7741b(z);
        }
    }

    public void m7712b() {
        if (this.f5129d != null) {
            this.f5129d.m7748i();
        }
    }

    public void m7713b(boolean z) {
        if (this.f5129d != null) {
            this.f5129d.m7739a(z);
        }
    }

    public void m7714c() {
        if (this.f5129d != null) {
            this.f5129d.m7744e();
        }
    }
}
