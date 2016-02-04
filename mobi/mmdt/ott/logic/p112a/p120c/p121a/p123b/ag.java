package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p081b.C1108a;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p157e.p158a.C1505c;
import mobi.mmdt.ott.logic.p157e.p158a.C1506d;
import mobi.mmdt.ott.logic.p157e.p158a.C1507e;
import mobi.mmdt.ott.logic.p157e.p158a.C1508f;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1592l;
import mobi.mmdt.ott.provider.p169c.C1593m;
import mobi.mmdt.ott.provider.p169c.C1594n;
import mobi.mmdt.ott.provider.p169c.C1595o;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.ag */
public class ag extends C0950c {
    private Context f4681a;
    private ArrayList<String> f4682b;
    private C1505c f4683c;
    private ArrayList<String> f4684d;
    private int f4685e;
    private int f4686f;
    private int f4687g;
    private String f4688h;
    private String f4689i;
    private C1595o f4690j;

    public ag(Context context, ArrayList<String> arrayList, String str, int i, int i2, int i3, String str2, C1595o c1595o) {
        super(new C0990j(C1396d.f4796b).m6038b(str2));
        this.f4684d = new ArrayList();
        this.f4681a = context;
        this.f4682b = arrayList;
        this.f4685e = i3;
        this.f4687g = i2;
        this.f4686f = i;
        this.f4688h = str;
        this.f4690j = c1595o;
        switch (ah.f4691a[c1595o.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f4683c = C1506d.m7598a(this.f4681a);
                break;
            case VideoSize.HVGA /*2*/:
                this.f4683c = C1507e.m7605a(this.f4681a);
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f4683c = C1508f.m7612a(this.f4681a);
                break;
        }
        for (int i4 = 0; i4 < this.f4682b.size(); i4++) {
            this.f4684d.add(C1108a.m6381a(C1309a.m6934a(this.f4681a).m6942b()));
        }
    }

    public ag(Context context, ArrayList<String> arrayList, String str, int i, int i2, int i3, String str2, C1595o c1595o, String str3) {
        super(new C0990j(C1396d.f4796b).m6038b(str2));
        this.f4684d = new ArrayList();
        this.f4681a = context;
        this.f4682b = arrayList;
        this.f4685e = i3;
        this.f4687g = i2;
        this.f4686f = i;
        this.f4688h = str;
        this.f4690j = c1595o;
        this.f4689i = str3;
        switch (ah.f4691a[c1595o.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f4683c = C1506d.m7598a(this.f4681a);
                break;
            case VideoSize.HVGA /*2*/:
                this.f4683c = C1507e.m7605a(this.f4681a);
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f4683c = C1508f.m7612a(this.f4681a);
                break;
        }
        for (int i4 = 0; i4 < this.f4682b.size(); i4++) {
            this.f4684d.add(C1108a.m6381a(C1309a.m6934a(this.f4681a).m6942b()));
        }
    }

    protected boolean m7122a(Throwable th) {
        return false;
    }

    public void m7123b() {
        long a = C1113a.m6421a();
        for (int i = 0; i < this.f4682b.size(); i++) {
            try {
                long j;
                if (this.f4690j.equals(C1595o.SINGLE)) {
                    j = a;
                    C1583c.m7966a(this.f4681a, (String) this.f4684d.get(i), C1594n.STICKER, BuildConfig.FLAVOR, a, j, C1592l.OUT, C1593m.SENDING, (String) this.f4682b.get(i), this.f4690j, (String) this.f4682b.get(i), null, this.f4688h);
                } else {
                    j = a;
                    C1583c.m7966a(this.f4681a, (String) this.f4684d.get(i), C1594n.STICKER, BuildConfig.FLAVOR, a, j, C1592l.OUT, C1593m.SENDING, (String) this.f4682b.get(i), this.f4690j, C1309a.m6934a(this.f4681a).m6942b(), null, this.f4688h);
                }
                if (!(this.f4689i == null || this.f4689i.isEmpty())) {
                    C1583c.m7976b(this.f4681a, (String) this.f4684d.get(i), this.f4689i);
                    C1387u.m7218a(this.f4681a, (String) this.f4684d.get(i), C1583c.m8003n(this.f4681a, this.f4689i), this.f4690j);
                }
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
            }
        }
    }

    public void m7124c() {
        for (int i = 0; i < this.f4682b.size(); i++) {
            this.f4683c.m7595a((String) this.f4682b.get(i), (String) this.f4684d.get(i), BuildConfig.FLAVOR + this.f4686f, BuildConfig.FLAVOR + this.f4687g, BuildConfig.FLAVOR + this.f4685e, this.f4689i, C1113a.m6421a());
        }
    }

    protected void m7125d() {
    }
}
