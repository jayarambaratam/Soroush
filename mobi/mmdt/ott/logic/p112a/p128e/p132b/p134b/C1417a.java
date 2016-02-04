package mobi.mmdt.ott.logic.p112a.p128e.p132b.p134b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p081b.C1108a;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p133a.C1412a;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p133a.C1413b;
import mobi.mmdt.ott.logic.p112a.p128e.p132b.p133a.C1416e;
import mobi.mmdt.ott.logic.p157e.C1518g;
import mobi.mmdt.ott.logic.p157e.p158a.C1504b;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p095c.p096a.C1258f;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1198u;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p171e.C1611e;
import mobi.mmdt.ott.provider.p172f.C1619f;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.e.b.b.a */
public class C1417a extends C0950c {
    private final Context f4836a;
    private final String f4837b;
    private final ArrayList<String> f4838c;
    private final ArrayList<C1619f> f4839d;
    private final Boolean f4840e;

    public C1417a(Context context, String str, ArrayList<String> arrayList, ArrayList<C1619f> arrayList2, boolean z) {
        super(new C0990j(C1396d.f4796b));
        this.f4836a = context;
        this.f4838c = arrayList;
        this.f4837b = str;
        this.f4840e = Boolean.valueOf(z);
        this.f4839d = arrayList2;
    }

    public static void m7313a(Context context, String str, ArrayList<String> arrayList, ArrayList<C1619f> arrayList2) {
        String b = C1309a.m6934a(context).m6942b();
        C1611e a = C1607a.m8152a(context, b);
        for (int i = 0; i < arrayList2.size(); i++) {
            if (!((String) arrayList.get(i)).equals(b)) {
                C1518g.m7654a(context).m7663b().m7500a(str, (String) arrayList.get(i), BuildConfig.FLAVOR);
                C1518g.m7654a(context).m7663b().m7508b(str, (String) arrayList.get(i));
                String a2 = C1108a.m6381a(b);
                C1611e a3 = C1607a.m8152a(context, (String) arrayList.get(i));
                C1504b.m7583a(context).m7589a(C1108a.m6381a(b), a3 != null ? a3.m8202d() + " Added by " + a.m8202d() : ((String) arrayList.get(i)) + " Added by " + a.m8202d(), str, (String) arrayList.get(i), (C1619f) arrayList2.get(i));
                C1504b.m7583a(context).m7590a(str, "You joined by " + a.m8202d(), (String) arrayList.get(i), (C1619f) arrayList2.get(i), a2);
            }
        }
    }

    private void m7314j() {
        String b = C1309a.m6934a(this.f4836a).m6942b();
        for (int i = 0; i < this.f4839d.size(); i++) {
            C1546a.m7793a(this.f4836a).m7795a(this.f4837b, (String) this.f4838c.get(i));
            String a = C1108a.m6381a(b);
            C1611e a2 = C1607a.m8152a(this.f4836a, (String) this.f4838c.get(i));
            C1504b.m7583a(this.f4836a).m7587a(this.f4837b, b, a2 != null ? a2.m8202d() + " Removed by " + C1607a.m8152a(this.f4836a, b).m8202d() : ((String) this.f4838c.get(i)) + " Removed by " + C1607a.m8152a(this.f4836a, b).m8202d(), (String) this.f4838c.get(i), a);
            try {
                C1518g.m7654a(this.f4836a).m7663b().m7499a(this.f4837b, (String) this.f4838c.get(i));
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
            }
        }
        C0002c.m2a().m17c(new C1416e());
    }

    private void m7315k() {
        C1417a.m7313a(this.f4836a, this.f4837b, this.f4838c, this.f4839d);
        C1309a.m6934a(this.f4836a).m6942b();
        C1198u[] c1198uArr = new C1198u[this.f4838c.size()];
        for (int i = 0; i < this.f4838c.size(); i++) {
            switch (C1418b.f4841a[((C1619f) this.f4839d.get(i)).ordinal()]) {
                case VideoSize.CIF /*1*/:
                    c1198uArr[i] = new C1198u((String) this.f4838c.get(i), C1258f.ADMIN);
                    break;
                case VideoSize.HVGA /*2*/:
                    c1198uArr[i] = new C1198u((String) this.f4838c.get(i), C1258f.MEMBER);
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    c1198uArr[i] = new C1198u((String) this.f4838c.get(i), C1258f.NONE);
                    break;
                case Version.API04_DONUT_16 /*4*/:
                    c1198uArr[i] = new C1198u((String) this.f4838c.get(i), C1258f.OWNER);
                    break;
                case Version.API05_ECLAIR_20 /*5*/:
                    c1198uArr[i] = new C1198u((String) this.f4838c.get(i), C1258f.VISITOR);
                    break;
                default:
                    break;
            }
        }
        C1546a.m7793a(this.f4836a).m7798a(this.f4837b, c1198uArr);
        C0002c.m2a().m17c(new C1416e());
    }

    protected boolean m7316a(Throwable th) {
        C0002c.m2a().m17c(new C1412a(th, this.f4838c));
        return false;
    }

    public void m7317b() {
    }

    public void m7318c() {
        if (this.f4838c.size() == 0) {
            C0002c.m2a().m17c(new C1413b());
        } else if (this.f4838c.size() != this.f4839d.size()) {
        } else {
            if (this.f4840e.booleanValue()) {
                m7314j();
                return;
            }
            m7315k();
            C0002c.m2a().m17c(new C1413b());
        }
    }

    protected void m7319d() {
    }
}
