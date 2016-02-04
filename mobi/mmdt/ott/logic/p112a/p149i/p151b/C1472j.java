package mobi.mmdt.ott.logic.p112a.p149i.p151b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1461g;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1462h;
import mobi.mmdt.ott.logic.p164k.C1547b;
import mobi.mmdt.ott.p095c.p096a.C1261k;
import mobi.mmdt.ott.view.stickermarket.C2610z;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.i.b.j */
public class C1472j extends C0950c {
    private Context f4924a;
    private C2610z f4925b;

    public C1472j(Context context, C2610z c2610z) {
        super(new C0990j(C1396d.f4796b));
        this.f4924a = context;
        this.f4925b = c2610z;
    }

    protected boolean m7458a(Throwable th) {
        C0002c.m2a().m17c(new C1461g());
        return false;
    }

    public void m7459b() {
    }

    public void m7460c() {
        C1261k c1261k = C1261k.Date;
        switch (C1473k.f4926a[this.f4925b.ordinal()]) {
            case VideoSize.CIF /*1*/:
                c1261k = C1261k.Date;
                break;
            case VideoSize.HVGA /*2*/:
                c1261k = C1261k.Star;
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                c1261k = C1261k.Free;
                break;
        }
        C0002c.m2a().m17c(new C1462h(C1547b.m7814a(this.f4924a).m7819a("20", "0", c1261k).m6680a()));
    }

    protected void m7461d() {
    }

    public C2610z m7462j() {
        return this.f4925b;
    }
}
