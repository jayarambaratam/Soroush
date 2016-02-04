package mobi.mmdt.ott.logic.p112a.p147h;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p147h.p148a.C1446a;
import mobi.mmdt.ott.logic.p112a.p147h.p148a.C1447b;
import mobi.mmdt.ott.logic.p164k.C1548c;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ac;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bi;
import mobi.mmdt.ott.p109d.p110a.C1308d;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p176j.C1641a;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.h.c */
public class C1452c extends C1450a {
    public C1452c(Context context) {
        super(context, C1309a.m6934a(context).m6954e(), C1309a.m6934a(context).m6957f());
    }

    protected boolean m7386a(Throwable th) {
        C0002c.m2a().m17c(new C1447b(th));
        return false;
    }

    public void m7387b() {
    }

    public void m7388c() {
        bi[] biVarArr = new bi[this.a.size()];
        int i = 0;
        for (String str : this.a.keySet()) {
            String str2;
            int i2 = i + 1;
            biVarArr[i] = new bi((String) this.b.get(str2), str2);
            i = i2;
        }
        ArrayList a = C1548c.m7822a(this.d).m7829a(biVarArr).m6689a();
        String[] strArr = new String[a.size()];
        ArrayList arrayList = new ArrayList();
        Iterator it = a.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            ac acVar = (ac) it.next();
            int i4 = i3 + 1;
            strArr[i3] = acVar.m6618d();
            arrayList.add(new C1308d(acVar.m6619e(), acVar.m6620f(), acVar.m6616b(), acVar.m6615a(), acVar.m6618d(), (String) this.a.get(acVar.m6618d()), this.a.containsKey(acVar.m6618d()), acVar.m6621g(), acVar.m6617c(), (String) this.b.get(acVar.m6618d()), (Uri) this.c.get(acVar.m6618d()), true, false));
            i3 = i4;
        }
        C1607a.m8153a(this.d, arrayList);
        C1494c.m7541c(new C1454e(this.d, false, strArr));
        this.e.m6949c(true);
        for (String str22 : this.a.keySet()) {
            str22 = (String) this.a.get(str22);
            if (!C1641a.m8371b(this.d, str22)) {
                C1641a.m8369a(this.d, str22);
            }
        }
        C0002c.m2a().m17c(new C1446a());
    }

    protected void m7389d() {
    }
}
