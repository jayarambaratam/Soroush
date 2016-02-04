package mobi.mmdt.ott.logic.p112a;

import android.content.Context;
import android.content.Intent;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.core.StartUpService;
import mobi.mmdt.ott.logic.notifications.C1557d;
import mobi.mmdt.ott.logic.notifications.notifsData.NewUpdateNotificationService;
import mobi.mmdt.ott.logic.p161g.C1534g;
import mobi.mmdt.ott.p109d.p111b.C1309a;

/* renamed from: mobi.mmdt.ott.logic.a.c */
public class C1393c extends C0950c {
    private Context f4792a;

    public C1393c(Context context) {
        super(new C0990j(C1396d.f4796b));
        this.f4792a = context;
    }

    protected boolean m7250a(Throwable th) {
        return false;
    }

    public void m7251b() {
    }

    public void m7252c() {
        C1534g.m7722a(this.f4792a).m7742c();
        C1534g.m7722a(this.f4792a).m7740b();
        C1534g.m7722a(this.f4792a).m7735a();
        C1309a.m6934a(this.f4792a).m6941a(true);
        StartUpService.m7553e(this.f4792a);
        C1557d.m7850a(this.f4792a);
        this.f4792a.stopService(new Intent(this.f4792a, NewUpdateNotificationService.class));
    }

    protected void m7253d() {
    }
}
