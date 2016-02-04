package mobi.mmdt.ott.logic.p112a.p135f.p136a;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.logic.notifications.C1557d;
import mobi.mmdt.ott.logic.notifications.notifsData.C1559b;
import mobi.mmdt.ott.logic.notifications.notifsData.C1560a;
import mobi.mmdt.ott.logic.notifications.notifsData.C1561c;
import mobi.mmdt.ott.logic.notifications.notifsData.C1562d;
import mobi.mmdt.ott.logic.notifications.notifsData.C1564f;
import mobi.mmdt.ott.logic.notifications.notifsData.C1565g;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p157e.p159b.C1512c;

/* renamed from: mobi.mmdt.ott.logic.a.f.a.d */
public class C1424d extends C0950c {
    private Context f4857a;
    private C1559b f4858b;

    public C1424d(Context context, C1559b c1559b) {
        super(new C0990j(C1396d.f4796b));
        this.f4857a = context;
        this.f4858b = c1559b;
    }

    protected boolean m7338a(Throwable th) {
        return false;
    }

    public void m7339b() {
    }

    public void m7340c() {
        int i = 0;
        if (this.f4858b != null) {
            ArrayList arrayList;
            Iterator it;
            if (this.f4858b instanceof C1565g) {
                C1565g c1565g = (C1565g) this.f4858b;
                arrayList = new ArrayList();
                it = c1565g.m7880d().iterator();
                while (it.hasNext()) {
                    arrayList.add(((C1564f) it.next()).m7875b());
                }
                C1512c.m7630a(c1565g.m7880d().size());
                C1557d.m7851a(this.f4857a, c1565g.m7879c(), c1565g.m7858b(), c1565g.m7876a(), arrayList, MyApplication.m6445a().m6453a(arrayList.size()));
            } else if (this.f4858b instanceof C1562d) {
                C1562d c1562d = (C1562d) this.f4858b;
                arrayList = new ArrayList();
                it = c1562d.m7873e().iterator();
                while (it.hasNext()) {
                    r0 = (C1564f) it.next();
                    arrayList.add(r0.m7874a() + " : " + r0.m7875b());
                }
                if (!c1562d.m7870a()) {
                    C1512c.m7630a(c1562d.m7873e().size());
                }
                C1557d.m7851a(this.f4857a, c1562d.m7872d(), c1562d.m7858b(), c1562d.m7871c(), arrayList, MyApplication.m6445a().m6453a(arrayList.size()));
            } else if (this.f4858b instanceof C1561c) {
                C1561c c1561c = (C1561c) this.f4858b;
                arrayList = new ArrayList();
                it = c1561c.m7867e().iterator();
                while (it.hasNext()) {
                    r0 = (C1564f) it.next();
                    arrayList.add(r0.m7874a() + " : " + r0.m7875b());
                }
                if (!c1561c.m7864a()) {
                    C1512c.m7634b(c1561c.m7867e().size());
                }
                C1557d.m7851a(this.f4857a, c1561c.m7866d(), c1561c.m7858b(), c1561c.m7865c(), arrayList, MyApplication.m6445a().m6453a(arrayList.size()));
            } else if (this.f4858b instanceof C1560a) {
                C1560a c1560a = (C1560a) this.f4858b;
                ArrayList arrayList2 = new ArrayList();
                int i2 = 0;
                int i3 = 0;
                for (Entry value : c1560a.m7860a()) {
                    int i4;
                    int i5 = i + 1;
                    C1559b c1559b = (C1559b) value.getValue();
                    Iterator it2;
                    C1564f c1564f;
                    if (c1559b instanceof C1565g) {
                        C1565g c1565g2 = (C1565g) c1559b;
                        it2 = c1565g2.m7880d().iterator();
                        while (it2.hasNext()) {
                            c1564f = (C1564f) it2.next();
                            arrayList2.add(c1564f.m7874a() + " : " + c1564f.m7875b());
                        }
                        i3 += c1565g2.m7880d().size();
                        i4 = i2;
                        i = i3;
                    } else if (c1559b instanceof C1562d) {
                        C1562d c1562d2 = (C1562d) c1559b;
                        it2 = c1562d2.m7873e().iterator();
                        while (it2.hasNext()) {
                            c1564f = (C1564f) it2.next();
                            arrayList2.add(c1564f.m7874a() + " @ " + c1562d2.m7872d() + " : " + c1564f.m7875b());
                        }
                        if (!c1562d2.m7870a()) {
                            i3 += c1562d2.m7873e().size();
                        }
                        i4 = i2;
                        i = i3;
                    } else {
                        if (c1559b instanceof C1561c) {
                            C1561c c1561c2 = (C1561c) c1559b;
                            it2 = c1561c2.m7867e().iterator();
                            while (it2.hasNext()) {
                                c1564f = (C1564f) it2.next();
                                arrayList2.add(c1564f.m7874a() + " @ " + c1561c2.m7866d() + " : " + c1564f.m7875b());
                            }
                            if (!c1561c2.m7864a()) {
                                i4 = i2 + c1561c2.m7867e().size();
                                i = i3;
                            }
                        }
                        i4 = i2;
                        i = i3;
                    }
                    i2 = i4;
                    i3 = i;
                    i = i5;
                }
                C1512c.m7630a(i3);
                C1512c.m7634b(i2);
                C1557d.m7852a(this.f4857a, arrayList2, i, MyApplication.m6445a().m6453a(arrayList2.size()));
            }
        }
    }

    protected void m7341d() {
    }
}
