package mobi.mmdt.ott.logic.p112a.p149i.p151b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1461g;
import mobi.mmdt.ott.logic.p112a.p149i.p150a.C1462h;
import mobi.mmdt.ott.logic.p164k.C1547b;
import mobi.mmdt.ott.view.stickermarket.C2610z;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.i.b.d */
public class C1466d extends C0950c {
    private Context f4911a;
    private String f4912b;
    private C2610z f4913c;

    public C1466d(Context context, C2610z c2610z, String str) {
        super(new C0990j(C1396d.f4796b));
        this.f4911a = context;
        this.f4913c = c2610z;
        this.f4912b = str;
    }

    protected boolean m7427a(Throwable th) {
        C0002c.m2a().m17c(new C1461g());
        return false;
    }

    public void m7428b() {
    }

    public void m7429c() {
        C0002c.m2a().m17c(new C1462h(C1547b.m7814a(this.f4911a).m7818a("20", "0", this.f4912b).m6680a()));
    }

    protected void m7430d() {
    }

    public C2610z m7431j() {
        return this.f4913c;
    }

    public String m7432k() {
        return this.f4912b;
    }
}
