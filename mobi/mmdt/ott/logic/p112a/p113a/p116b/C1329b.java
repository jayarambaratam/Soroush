package mobi.mmdt.ott.logic.p112a.p113a.p116b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1320a;
import mobi.mmdt.ott.logic.p161g.C1530c;
import mobi.mmdt.ott.logic.p161g.C1533f;
import net.frakbot.glowpadbackport.BuildConfig;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.a.b.b */
public class C1329b extends C0950c {
    private Context f4598a;
    private String f4599b;

    public C1329b(Context context, String str) {
        super(new C0990j(C1396d.f4797c));
        this.f4598a = context;
        this.f4599b = str;
    }

    protected boolean m7002a(Throwable th) {
        return false;
    }

    public void m7003b() {
    }

    public void m7004c() {
        C1530c.m7703a(this.f4598a).m7712b();
        C0002c.m2a().m17c(new C1320a(C1533f.f5146n, BuildConfig.FLAVOR, this.f4599b));
    }

    protected void m7005d() {
    }
}
