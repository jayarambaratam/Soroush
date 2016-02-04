package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p122a.C1364a;
import mobi.mmdt.ott.p089b.C1162g;
import mobi.mmdt.ott.provider.p177k.C1647b;
import mobi.mmdt.ott.provider.p177k.C1652g;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.f */
public class C1372f extends C0950c {
    private Context f4709a;
    private String f4710b;
    private String f4711c;
    private C1162g f4712d;

    public C1372f(Context context, String str, String str2, C1162g c1162g) {
        super(new C0990j(C1396d.f4797c));
        this.f4709a = context;
        this.f4710b = str;
        this.f4711c = str2;
        this.f4712d = c1162g;
    }

    protected boolean m7148a(Throwable th) {
        C0002c.m2a().m17c(new C1364a(th));
        return false;
    }

    public void m7149b() {
    }

    public void m7150c() {
        C1652g c1652g;
        switch (C1373g.f4713a[this.f4712d.ordinal()]) {
            case VideoSize.CIF /*1*/:
                c1652g = C1652g.ACTIVE;
                break;
            case VideoSize.HVGA /*2*/:
                c1652g = C1652g.INACTIVE;
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                c1652g = C1652g.GONE;
                break;
            case Version.API04_DONUT_16 /*4*/:
                c1652g = C1652g.COMPOSING;
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                c1652g = C1652g.PAUSED;
                break;
            default:
                c1652g = C1652g.INACTIVE;
                break;
        }
        if (C1647b.m8385b(this.f4709a, this.f4710b)) {
            C1647b.m8384b(this.f4709a, this.f4710b, this.f4711c, c1652g);
        } else {
            C1647b.m8383a(this.f4709a, this.f4710b, this.f4711c, c1652g);
        }
    }

    protected void m7151d() {
    }
}
