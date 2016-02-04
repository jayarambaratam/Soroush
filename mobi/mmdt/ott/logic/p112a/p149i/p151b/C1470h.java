package mobi.mmdt.ott.logic.p112a.p149i.p151b;

import android.content.Context;
import android.net.Uri;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.io.File;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.logic.p124j.C1545d;
import mobi.mmdt.ott.logic.p164k.C1547b;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.be;
import mobi.mmdt.ott.provider.p175i.C1635a;
import mobi.mmdt.ott.provider.p175i.C1638d;
import mobi.mmdt.ott.provider.p175i.C1640f;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.logic.a.i.b.h */
public class C1470h extends C0950c {
    private Context f4919a;
    private Uri f4920b;
    private int f4921c;
    private C1367c f4922d;

    public C1470h(Context context, int i) {
        super(new C0990j(C1396d.f4796b).m6036a(i + BuildConfig.FLAVOR));
        this.f4922d = new C1471i(this);
        this.f4919a = context;
        this.f4921c = i;
    }

    protected boolean m7448a(Throwable th) {
        return false;
    }

    public void m7449b() {
    }

    public void m7450c() {
        Object obj = null;
        C1638d c = C1635a.m8341c(this.f4919a, this.f4921c);
        if (!c.moveToFirst()) {
            C1635a.m8336a(this.f4919a, this.f4921c, -1, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, -1, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, false, 0, C1640f.NOT_STARTED, -1);
            obj = 1;
        } else if (c.m8358b() == C1640f.NOT_STARTED || c.m8358b() == C1640f.CANCEL || c.m8358b() == C1640f.ERROR) {
            obj = 1;
        }
        if (!(c == null || c.isClosed())) {
            c.close();
        }
        if (obj != null) {
            be b = C1547b.m7814a(this.f4919a).m7821b(BuildConfig.FLAVOR + this.f4921c);
            if (b != null) {
                String a;
                switch (this.f4919a.getResources().getDisplayMetrics().densityDpi) {
                    case 120:
                        a = b.m6672a().m6681a();
                        break;
                    case 160:
                        a = b.m6672a().m6682b();
                        break;
                    case 240:
                        a = b.m6672a().m6685e();
                        break;
                    case 320:
                        a = b.m6672a().m6686f();
                        break;
                    case 480:
                        a = b.m6672a().m6684d();
                        break;
                    case 640:
                        a = b.m6672a().m6683c();
                        break;
                    default:
                        a = b.m6672a().m6685e();
                        break;
                }
                if (a != null) {
                    this.f4920b = Uri.fromFile(new File(C1490b.m7516a(this.f4919a).m7529g(this.f4921c + ".zip")));
                    C1635a.m8333a(this.f4919a, this.f4921c, C1640f.TRANSMITTING);
                    C1635a.m8339b(this.f4919a, this.f4921c, C1545d.m7786a(this.f4919a).m7788a(a, this.f4920b, null, this.f4922d));
                }
            }
        }
    }

    protected void m7451d() {
    }
}
