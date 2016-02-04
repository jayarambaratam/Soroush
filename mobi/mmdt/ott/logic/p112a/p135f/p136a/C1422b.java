package mobi.mmdt.ott.logic.p112a.p135f.p136a;

import android.content.Context;
import android.graphics.Bitmap;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.Timer;
import java.util.concurrent.ExecutionException;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.notifications.C1557d;
import mobi.mmdt.ott.logic.notifications.C1558e;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p147h.C1451b;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p171e.C1611e;
import mobi.mmdt.ott.view.p178a.aj;

/* renamed from: mobi.mmdt.ott.logic.a.f.a.b */
public class C1422b extends C0950c {
    private Context f4852a;
    private String f4853b;

    public C1422b(Context context, String str) {
        super(new C0990j(C1396d.f4796b));
        this.f4852a = context;
        this.f4853b = str;
    }

    protected boolean m7334a(Throwable th) {
        return false;
    }

    public void m7335b() {
        C1494c.m7540b(new C1451b(this.f4852a, new String[]{this.f4853b}, false, false));
    }

    public void m7336c() {
        Throwable e;
        C1611e a = C1607a.m8152a(this.f4852a, this.f4853b);
        String a2 = a.m8199a();
        Bitmap a3 = C1558e.m7853a(this.f4852a);
        if (a2 != null) {
            try {
                if (!a2.isEmpty()) {
                    a3 = C1111c.m6391a(this.f4852a, aj.m8474a(a2));
                }
            } catch (InterruptedException e2) {
                e = e2;
                C1104b.m6367b(C1557d.class, "IOException happened in GenerateNotification", e);
                new Timer().schedule(new C1423c(this, a, a3), 10000);
            } catch (ExecutionException e3) {
                e = e3;
                C1104b.m6367b(C1557d.class, "IOException happened in GenerateNotification", e);
                new Timer().schedule(new C1423c(this, a, a3), 10000);
            }
        }
        new Timer().schedule(new C1423c(this, a, a3), 10000);
    }

    protected void m7337d() {
    }
}
