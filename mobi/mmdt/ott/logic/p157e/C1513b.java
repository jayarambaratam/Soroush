package mobi.mmdt.ott.logic.p157e;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1368b;
import mobi.mmdt.ott.logic.p157e.p159b.C1512c;
import mobi.mmdt.ott.p109d.p110a.C1306b;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p170d.C1598c;

/* renamed from: mobi.mmdt.ott.logic.e.b */
class C1513b implements Runnable {
    final /* synthetic */ C1509a f5079a;

    C1513b(C1509a c1509a) {
        this.f5079a = c1509a;
    }

    public void run() {
        Iterator it;
        if (C1509a.f5073d.size() > 0 && C1509a.f5073d.size() == C1509a.f5072c.size() && C1509a.f5073d.size() == this.f5079a.f5074e.size()) {
            ArrayList a = C1598c.m8101a(this.f5079a.f5075f, C1509a.f5073d);
            C1104b.m6366b((Object) C1509a.class, "********   mUri.size: " + a.size() + "       mConversationsWithFile.size: " + C1509a.f5072c.size());
            for (int i = 0; i < a.size(); i++) {
                if (C1509a.f5072c.size() > 0) {
                    ((C1306b) C1509a.f5072c.get(i)).m6899a(Long.parseLong(((Uri) a.get(i)).getLastPathSegment()));
                    C1494c.m7541c(new C1368b(this.f5079a.f5075f, ((C1306b) C1509a.f5072c.get(i)).m6904f(), (Map) this.f5079a.f5074e.get(i)));
                }
            }
            C1583c.m7971a(this.f5079a.f5075f, C1509a.f5072c);
            it = C1509a.f5072c.iterator();
            while (it.hasNext()) {
                C1512c.m7631a(((C1306b) it.next()).m6907i());
            }
            C1509a.f5073d.clear();
            C1509a.f5072c.clear();
            this.f5079a.f5074e.clear();
        }
        if (C1509a.f5071b.size() > 0) {
            C1583c.m7971a(this.f5079a.f5075f, C1509a.f5071b);
            it = C1509a.f5071b.iterator();
            while (it.hasNext()) {
                C1512c.m7631a(((C1306b) it.next()).m6907i());
            }
            C1509a.f5071b.clear();
        }
    }
}
