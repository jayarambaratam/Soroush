package mobi.mmdt.ott.logic.p112a.p149i.p151b;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.io.IOException;
import java.security.GeneralSecurityException;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1459e;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1460f;
import mobi.mmdt.ott.logic.p164k.C1547b;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1201d;
import mobi.mmdt.ott.p095c.p107c.C1279f;
import mobi.mmdt.ott.p095c.p107c.C1293u;
import mobi.mmdt.ott.p095c.p107c.aj;
import org.json.JSONException;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.i.b.f */
public class C1468f extends C0950c {
    private Context f4916a;

    public C1468f(Context context) {
        super(new C0990j(C1396d.f4796b));
        this.f4916a = context;
    }

    protected boolean m7437a(Throwable th) {
        C0002c.m2a().m17c(new C1459e());
        return false;
    }

    public void m7438b() {
    }

    public void m7439c() {
        C1201d[] a;
        Throwable e;
        try {
            a = C1547b.m7814a(this.f4916a).m7820b().m6660a();
        } catch (JSONException e2) {
            e = e2;
            C1104b.m6368b((Object) this, e);
            a = null;
            C0002c.m2a().m17c(new C1460f(a));
        } catch (IOException e3) {
            e = e3;
            C1104b.m6368b((Object) this, e);
            a = null;
            C0002c.m2a().m17c(new C1460f(a));
        } catch (NumberFormatException e4) {
            e = e4;
            C1104b.m6368b((Object) this, e);
            a = null;
            C0002c.m2a().m17c(new C1460f(a));
        } catch (NameNotFoundException e5) {
            e = e5;
            C1104b.m6368b((Object) this, e);
            a = null;
            C0002c.m2a().m17c(new C1460f(a));
        } catch (GeneralSecurityException e6) {
            e = e6;
            C1104b.m6368b((Object) this, e);
            a = null;
            C0002c.m2a().m17c(new C1460f(a));
        } catch (C1279f e7) {
            e = e7;
            C1104b.m6368b((Object) this, e);
            a = null;
            C0002c.m2a().m17c(new C1460f(a));
        } catch (C1293u e8) {
            e = e8;
            C1104b.m6368b((Object) this, e);
            a = null;
            C0002c.m2a().m17c(new C1460f(a));
        } catch (aj e9) {
            e = e9;
            C1104b.m6368b((Object) this, e);
            a = null;
            C0002c.m2a().m17c(new C1460f(a));
        }
        C0002c.m2a().m17c(new C1460f(a));
    }

    protected void m7440d() {
    }
}
