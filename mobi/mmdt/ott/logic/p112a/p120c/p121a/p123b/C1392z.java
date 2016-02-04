package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p081b.C1108a;
import mobi.mmdt.componentsutils.p079a.p083d.C1112a;
import mobi.mmdt.componentsutils.p079a.p084e.C1113a;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p122a.C1365b;
import mobi.mmdt.ott.logic.p124j.C1367c;
import mobi.mmdt.ott.logic.p124j.C1545d;
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
import mobi.mmdt.ott.provider.p170d.C1598c;
import mobi.mmdt.ott.provider.p170d.C1603h;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.provider.p170d.C1605j;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.z */
public class C1392z extends C0950c {
    private Context f4779a;
    private ArrayList<C1367c> f4780b;
    private String f4781c;
    private String f4782d;
    private ArrayList<String> f4783e;
    private ArrayList<String> f4784f;
    private C1605j f4785g;
    private long f4786h;
    private ArrayList<Long> f4787i;
    private int f4788j;
    private C1505c f4789k;
    private C1595o f4790l;
    private String f4791m;

    public C1392z(Context context, ArrayList<String> arrayList, String str, String str2, C1605j c1605j, String str3, C1595o c1595o) {
        super(new C0990j(C1396d.f4796b).m6038b(str3));
        this.f4780b = new ArrayList();
        this.f4783e = new ArrayList();
        this.f4784f = new ArrayList();
        this.f4787i = new ArrayList();
        this.f4791m = null;
        this.f4779a = context;
        this.f4781c = str2;
        this.f4784f = arrayList;
        this.f4785g = c1605j;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        this.f4782d = str;
        this.f4790l = c1595o;
        switch (ab.f4670a[c1595o.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f4789k = C1506d.m7598a(this.f4779a);
            case VideoSize.HVGA /*2*/:
                this.f4789k = C1507e.m7605a(this.f4779a);
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f4789k = C1508f.m7612a(this.f4779a);
            default:
        }
    }

    public C1392z(Context context, ArrayList<String> arrayList, String str, String str2, C1605j c1605j, String str3, C1595o c1595o, String str4) {
        super(new C0990j(C1396d.f4796b).m6038b(str3));
        this.f4780b = new ArrayList();
        this.f4783e = new ArrayList();
        this.f4784f = new ArrayList();
        this.f4787i = new ArrayList();
        this.f4791m = null;
        this.f4779a = context;
        this.f4781c = str2;
        this.f4784f = arrayList;
        this.f4785g = c1605j;
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        this.f4782d = str;
        this.f4790l = c1595o;
        this.f4791m = str4;
        switch (ab.f4670a[c1595o.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f4789k = C1506d.m7598a(this.f4779a);
            case VideoSize.HVGA /*2*/:
                this.f4789k = C1507e.m7605a(this.f4779a);
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f4789k = C1508f.m7612a(this.f4779a);
            default:
        }
    }

    public static int m7232a(Context context, String str) {
        return MediaPlayer.create(context, Uri.parse(str)).getDuration();
    }

    private Long m7233a(File file, boolean z, boolean z2, boolean z3) {
        C1603h c1603h = z ? C1603h.STOP : null;
        int i = z ? 0 : -1;
        this.f4788j = z2 ? C1392z.m7232a(this.f4779a, this.f4781c) : -1;
        String lastPathSegment = C1598c.m8100a(this.f4779a, Uri.fromFile(file), null, null, this.f4785g, file.getName(), file.length(), 0, z3 ? Uri.fromFile(new File(z3 ? m7234a(this.f4781c) : null)) : null, null, this.f4788j, C1604i.NOT_STARTED, C1604i.NOT_STARTED, c1603h, i).getLastPathSegment();
        return Long.valueOf(lastPathSegment != null ? Long.parseLong(lastPathSegment) : 0);
    }

    private String m7234a(String str) {
        Bitmap b;
        File file = new File(str);
        String a = C1490b.m7516a(this.f4779a).m7519a();
        switch (ab.f4671b[this.f4785g.ordinal()]) {
            case VideoSize.CIF /*1*/:
                b = C1112a.m6420b(str);
                break;
            case VideoSize.HVGA /*2*/:
                b = C1112a.m6418a(str);
                break;
            default:
                return a;
        }
        C1112a.m6419a(b, a);
        return a;
    }

    private void m7245j() {
        for (int i = 0; i < this.f4784f.size(); i++) {
            this.f4780b.add(new aa(this, i));
        }
    }

    protected boolean m7246a(Throwable th) {
        C1598c.m8095a(this.f4779a, this.f4786h, C1604i.ERROR);
        C0002c.m2a().m17c(new C1365b(th));
        return false;
    }

    public void m7247b() {
        C1594n c1594n;
        m7245j();
        long a = C1113a.m6421a();
        File file = new File(this.f4781c);
        C1594n c1594n2 = null;
        try {
            switch (ab.f4671b[this.f4785g.ordinal()]) {
                case VideoSize.CIF /*1*/:
                    this.f4786h = m7233a(file, false, false, true).longValue();
                    c1594n2 = C1594n.IMAGE;
                    break;
                case VideoSize.HVGA /*2*/:
                    this.f4786h = m7233a(file, false, true, true).longValue();
                    c1594n2 = C1594n.VIDEO;
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    this.f4786h = m7233a(file, true, true, false).longValue();
                    c1594n2 = C1594n.PUSH_TO_TALK;
                    break;
                case Version.API04_DONUT_16 /*4*/:
                    this.f4786h = m7233a(file, true, true, false).longValue();
                    c1594n2 = C1594n.AUDIO;
                    break;
                case Version.API05_ECLAIR_20 /*5*/:
                    this.f4786h = m7233a(file, false, false, false).longValue();
                    c1594n2 = C1594n.FILE;
                    break;
            }
            c1594n = c1594n2;
        } catch (Throwable e) {
            C1104b.m6367b(C1392z.class, "IOException", e);
            c1594n = null;
        }
        Iterator it = this.f4784f.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2;
            String str = (String) it.next();
            this.f4783e.add(C1108a.m6381a(C1309a.m6934a(this.f4779a).m6942b()));
            try {
                Uri a2;
                if (this.f4790l.equals(C1595o.SINGLE)) {
                    a2 = C1583c.m7966a(this.f4779a, (String) this.f4783e.get(i), c1594n, this.f4782d, a, a, C1592l.OUT, C1593m.SENDING, str, this.f4790l, str, Long.valueOf(this.f4786h), null);
                } else {
                    a2 = C1583c.m7966a(this.f4779a, (String) this.f4783e.get(i), c1594n, this.f4782d, a, a, C1592l.OUT, C1593m.SENDING, str, this.f4790l, C1309a.m6934a(this.f4779a).m6942b(), Long.valueOf(this.f4786h), null);
                }
                if (!(this.f4791m == null || this.f4791m.isEmpty())) {
                    C1583c.m7976b(this.f4779a, (String) this.f4783e.get(i), this.f4791m);
                    C1387u.m7218a(this.f4779a, (String) this.f4783e.get(i), C1583c.m8003n(this.f4779a, this.f4791m), this.f4790l);
                }
                this.f4787i.add(Long.valueOf(Long.parseLong(a2.getLastPathSegment())));
                i2 = i + 1;
            } catch (Throwable e2) {
                C1104b.m6368b((Object) this, e2);
                i2 = i;
            }
            i = i2;
        }
    }

    public void m7248c() {
        for (int i = 0; i < this.f4784f.size(); i++) {
            C1598c.m8095a(this.f4779a, this.f4786h, C1604i.TRANSMITTING);
            C1545d.m7786a(this.f4779a).m7792b(this.f4786h, false, (C1367c) this.f4780b.get(i));
        }
    }

    protected void m7249d() {
    }
}
