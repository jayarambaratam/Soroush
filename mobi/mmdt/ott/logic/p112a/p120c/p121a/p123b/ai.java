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
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.ai */
public class ai extends C0950c {
    private Context f4692a;
    private C1505c f4693b;
    private C1375i[] f4694c;
    private String f4695d;
    private String f4696e;
    private C1595o f4697f;

    public ai(Context context, ArrayList<String> arrayList, String str, String str2, C1595o c1595o) {
        super(new C0990j(C1396d.f4796b).m6038b(str2));
        this.f4695d = null;
        this.f4692a = context;
        this.f4697f = c1595o;
        this.f4694c = m7127a(str, arrayList, c1595o);
        this.f4696e = str2;
    }

    public ai(Context context, ArrayList<String> arrayList, String str, String str2, C1595o c1595o, String str3) {
        super(new C0990j(C1396d.f4796b).m6038b(str2));
        this.f4695d = null;
        this.f4692a = context;
        this.f4697f = c1595o;
        this.f4694c = m7127a(str, arrayList, c1595o);
        this.f4695d = str3;
    }

    private String m7126a(String str) {
        String[] split = str.split("[ \\n,.!?]");
        return (split.length == 0 || str.length() == split[split.length - 1].length()) ? str : str.substring(0, (str.length() - split[split.length - 1].length()) - 1);
    }

    private C1375i[] m7127a(String str, ArrayList<String> arrayList, C1595o c1595o) {
        int length = str.length() / 1000;
        if (str.length() % 1000 != 0) {
            length++;
        }
        this.f4694c = new C1375i[(length * arrayList.size())];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str2 = (String) arrayList.get(i3);
            int i4 = i;
            i = 0;
            while (i < str.length() / 1000) {
                String a = m7126a(str.substring(i2, (i + 1) * 1000));
                int length2 = a.length() + i2;
                i2 = i4 + 1;
                this.f4694c[i4] = new C1375i(C1108a.m6381a(C1309a.m6934a(this.f4692a).m6942b()), a, str2, c1595o);
                i++;
                i4 = i2;
                i2 = length2;
            }
            if (str.length() % 1000 != 0) {
                String substring = str.substring(i2, str.length());
                i = i4 + 1;
                this.f4694c[i4] = new C1375i(C1108a.m6381a(C1309a.m6934a(this.f4692a).m6942b()), substring, str2, c1595o);
            } else {
                i = i4;
            }
        }
        return this.f4694c;
    }

    protected boolean m7128a(Throwable th) {
        return false;
    }

    public void m7129b() {
        long a = C1113a.m6421a();
        for (C1375i c1375i : this.f4694c) {
            try {
                if (this.f4697f.equals(C1595o.SINGLE)) {
                    C1583c.m7966a(this.f4692a, c1375i.m7155c(), C1594n.TEXT, c1375i.m7154b(), a, a, C1592l.OUT, C1593m.SENDING, c1375i.m7156d(), c1375i.m7153a(), c1375i.m7156d(), null, null);
                } else {
                    C1583c.m7966a(this.f4692a, c1375i.m7155c(), C1594n.TEXT, c1375i.m7154b(), a, a, C1592l.OUT, C1593m.SENDING, c1375i.m7156d(), c1375i.m7153a(), C1309a.m6934a(this.f4692a).m6942b(), null, null);
                }
                if (!(this.f4695d == null || this.f4695d.isEmpty())) {
                    C1583c.m7976b(this.f4692a, c1375i.m7155c(), this.f4695d);
                    C1387u.m7218a(this.f4692a, c1375i.m7155c(), C1583c.m8003n(this.f4692a, this.f4695d), this.f4697f);
                }
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
            }
        }
    }

    public void m7130c() {
        for (int i = 0; i < this.f4694c.length; i++) {
            switch (aj.f4698a[this.f4694c[i].m7153a().ordinal()]) {
                case VideoSize.CIF /*1*/:
                    this.f4693b = C1506d.m7598a(this.f4692a);
                    break;
                case VideoSize.HVGA /*2*/:
                    this.f4693b = C1507e.m7605a(this.f4692a);
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    this.f4693b = C1508f.m7612a(this.f4692a);
                    break;
                default:
                    break;
            }
            this.f4693b.m7592a(this.f4694c[i].m7156d(), this.f4694c[i].m7154b(), this.f4694c[i].m7155c(), this.f4695d, C1113a.m6421a());
        }
    }

    protected void m7131d() {
    }
}
