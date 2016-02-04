package mobi.mmdt.ott.logic.p112a.p147h;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p147h.p148a.C1448c;
import mobi.mmdt.ott.logic.p112a.p147h.p148a.C1449d;
import mobi.mmdt.ott.logic.p164k.C1548c;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ac;
import mobi.mmdt.ott.p109d.p110a.C1308d;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p171e.C1607a;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.h.b */
public class C1451b extends C1450a {
    private String[] f4885f;
    private boolean f4886g;
    private boolean f4887h;

    public C1451b(Context context, String[] strArr, boolean z, boolean z2) {
        super(context, C1309a.m6934a(context).m6954e(), C1309a.m6934a(context).m6957f());
        this.f4886g = false;
        this.f4887h = false;
        this.f4887h = z2;
        if (strArr == null && strArr.length == 0) {
            throw new NullPointerException();
        }
        this.f4886g = z;
        this.f4885f = strArr;
    }

    protected boolean m7382a(Throwable th) {
        C0002c.m2a().m17c(new C1448c(th));
        return false;
    }

    public void m7383b() {
    }

    public void m7384c() {
        if (this.f4887h) {
            C1494c.m7541c(new C1454e(this.d, false, this.f4885f));
        }
        if (!this.f4886g) {
            Collection linkedList = new LinkedList(Arrays.asList(C1607a.m8158a(this.d, this.f4885f)));
            List linkedList2 = new LinkedList(Arrays.asList(this.f4885f));
            linkedList2.removeAll(linkedList);
            this.f4885f = new String[linkedList2.size()];
            this.f4885f = (String[]) linkedList2.toArray(this.f4885f);
        }
        if (!(this.f4885f == null || this.f4885f.length == 0)) {
            ArrayList a = C1548c.m7822a(this.d).m7825a(this.f4885f).m6622a();
            String[] strArr = new String[a.size()];
            Iterator it = a.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2 = i + 1;
                strArr[i] = ((ac) it.next()).m6618d();
                i = i2;
            }
            List asList = Arrays.asList(C1607a.m8158a(this.d, strArr));
            ArrayList arrayList = new ArrayList();
            Iterator it2 = a.iterator();
            while (it2.hasNext()) {
                ac acVar = (ac) it2.next();
                if (asList.contains(acVar.m6618d())) {
                    C1607a.m8150a(this.d, acVar.m6619e(), acVar.m6620f(), acVar.m6616b(), acVar.m6615a(), acVar.m6618d(), (String) this.a.get(acVar.m6618d()), this.a.containsKey(acVar.m6618d()), acVar.m6621g(), acVar.m6617c(), (String) this.b.get(acVar.m6618d()), (Uri) this.c.get(acVar.m6618d()));
                } else {
                    arrayList.add(new C1308d(acVar.m6619e(), acVar.m6620f(), acVar.m6616b(), acVar.m6615a(), acVar.m6618d(), (String) this.a.get(acVar.m6618d()), this.a.containsKey(acVar.m6618d()), acVar.m6621g(), acVar.m6617c(), (String) this.b.get(acVar.m6618d()), (Uri) this.c.get(acVar.m6618d()), false, false));
                }
            }
            C1607a.m8153a(this.d, arrayList);
        }
        C0002c.m2a().m17c(new C1449d());
    }

    protected void m7385d() {
    }
}
