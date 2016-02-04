package mobi.mmdt.ott.logic.p112a.p117b.p119b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.ArrayList;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1334a;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1204g;
import mobi.mmdt.ott.p109d.p110a.C1305a;
import mobi.mmdt.ott.provider.p168b.C1573b;
import mobi.mmdt.ott.provider.p172f.C1619f;

/* renamed from: mobi.mmdt.ott.logic.a.b.b.a */
public class C1349a extends C0950c {
    private final C1204g[] f4619a;
    private final Context f4620b;
    private boolean f4621c;

    public C1349a(Context context, C1204g[] c1204gArr, boolean z) {
        super(new C0990j(C1396d.f4796b));
        this.f4621c = false;
        this.f4620b = context;
        this.f4619a = c1204gArr;
        this.f4621c = z;
    }

    protected boolean m7033a(Throwable th) {
        return false;
    }

    public void m7034b() {
    }

    public void m7035c() {
        ArrayList arrayList = new ArrayList();
        for (C1204g c1204g : this.f4619a) {
            C1619f a = C1334a.m7023a(c1204g.m6640e());
            if (C1573b.m7925c(this.f4620b, c1204g.m6638c())) {
                C1573b.m7920a(this.f4620b, c1204g.m6638c(), c1204g.m6639d(), c1204g.m6643h(), c1204g.m6641f(), c1204g.m6642g(), a, c1204g.m6644i(), C1573b.m7922a(this.f4620b, c1204g.m6638c()).m7919a(), c1204g.m6645j(), c1204g.m6701b());
            } else {
                arrayList.add(new C1305a(c1204g.m6638c(), c1204g.m6639d(), c1204g.m6643h(), c1204g.m6641f(), c1204g.m6642g(), a, c1204g.m6644i(), true, c1204g.m6645j(), false, c1204g.m6701b()));
                if (this.f4621c) {
                    C1494c.m7539a(new C1353e(this.f4620b, c1204g.m6638c(), 0, 20));
                }
            }
        }
        if (arrayList.size() > 0) {
            C1573b.m7923a(this.f4620b, arrayList);
        }
    }

    protected void m7036d() {
    }
}
