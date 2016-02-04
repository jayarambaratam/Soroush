package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.ArrayList;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1588h;
import mobi.mmdt.ott.provider.p169c.C1594n;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.provider.p170d.C1598c;
import mobi.mmdt.ott.provider.p170d.C1605j;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p173g.C1622c;
import mobi.mmdt.ott.provider.p174h.C1629b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.d */
public class C1370d extends C0950c {
    private Context f4705a;
    private String f4706b;
    private String f4707c;

    public C1370d(Context context, String str, String str2) {
        super(new C0990j(C1396d.f4796b));
        this.f4705a = context;
        this.f4707c = str2;
        this.f4706b = str;
    }

    protected boolean m7144a(Throwable th) {
        return false;
    }

    public void m7145b() {
    }

    public void m7146c() {
        C1595o c1595o;
        C1588h n = C1583c.m8003n(this.f4705a, this.f4706b);
        C1594n k = n.m8050k();
        if (C1607a.m8167d(this.f4705a, this.f4707c)) {
            c1595o = C1595o.SINGLE;
        } else if (C1622c.m8254a(this.f4705a, this.f4707c)) {
            c1595o = C1595o.GROUP;
        } else {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f4707c);
        ArrayList arrayList2;
        switch (C1371e.f4708a[k.ordinal()]) {
            case VideoSize.CIF /*1*/:
                C1494c.m7539a(new ai(this.f4705a, arrayList, n.m8045f(), this.f4707c, c1595o));
            case VideoSize.HVGA /*2*/:
                String b = n.m8041b();
                C1494c.m7539a(new ag(this.f4705a, arrayList, b, Integer.parseInt(C1629b.m8294a(b)), Integer.parseInt(C1629b.m8297b(b)), Integer.parseInt(C1629b.m8299c(b)), this.f4707c, c1595o));
            case Version.API03_CUPCAKE_15 /*3*/:
                arrayList2 = arrayList;
                C1494c.m7539a(new C1392z(this.f4705a, arrayList2, n.m8045f(), C1598c.m8102a(this.f4705a, n.m8048i().longValue()).m8088f().getPath(), C1605j.IMAGE, this.f4707c, c1595o));
            case Version.API04_DONUT_16 /*4*/:
                arrayList2 = arrayList;
                C1494c.m7539a(new C1392z(this.f4705a, arrayList2, n.m8045f(), C1598c.m8102a(this.f4705a, n.m8048i().longValue()).m8088f().getPath(), C1605j.PUSH_TO_TALK, this.f4707c, c1595o));
            case Version.API05_ECLAIR_20 /*5*/:
                arrayList2 = arrayList;
                C1494c.m7539a(new C1392z(this.f4705a, arrayList2, n.m8045f(), C1598c.m8102a(this.f4705a, n.m8048i().longValue()).m8088f().getPath(), C1605j.VIDEO, this.f4707c, c1595o));
            case Version.API06_ECLAIR_201 /*6*/:
                arrayList2 = arrayList;
                C1494c.m7539a(new C1392z(this.f4705a, arrayList2, n.m8045f(), C1598c.m8102a(this.f4705a, n.m8048i().longValue()).m8088f().getPath(), C1605j.OTHER, this.f4707c, c1595o));
            default:
        }
    }

    protected void m7147d() {
    }
}
