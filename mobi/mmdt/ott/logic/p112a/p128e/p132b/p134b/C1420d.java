package mobi.mmdt.ott.logic.p112a.p128e.p132b.p134b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.p112a.C1334a;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p147h.C1451b;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.al;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p172f.C1614a;

/* renamed from: mobi.mmdt.ott.logic.a.e.b.b.d */
public class C1420d extends C0950c {
    private Context f4847a;
    private String f4848b;

    public C1420d(Context context, String str) {
        super(new C0990j(C1396d.f4796b));
        this.f4847a = context;
        this.f4848b = str;
    }

    protected boolean m7324a(Throwable th) {
        return false;
    }

    public void m7325b() {
    }

    public void m7326c() {
        C1309a.m6934a(this.f4847a).m6942b();
        C1309a.m6934a(this.f4847a).m6963i();
        al[] a = C1546a.m7793a(this.f4847a).m7806b(this.f4848b).m6713a();
        String[] strArr = new String[a.length];
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Map linkedHashMap = new LinkedHashMap();
        int length = a.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            al alVar = a[i];
            int i3 = i2 + 1;
            strArr[i2] = alVar.m6646a();
            if (C1614a.m8231a(this.f4847a, this.f4848b, alVar.m6646a())) {
                linkedHashMap.put(alVar.m6646a(), Long.valueOf(alVar.m6649d()));
            } else {
                arrayList.add(alVar.m6646a());
                linkedHashMap.put(alVar.m6646a(), Long.valueOf(alVar.m6649d()));
                arrayList2.add(Boolean.valueOf(alVar.m6648c()));
                arrayList3.add(C1334a.m7023a(alVar.m6647b()));
            }
            i++;
            i2 = i3;
        }
        C1614a.m8230a(this.f4847a, this.f4848b, arrayList, arrayList2, arrayList3);
        C1614a.m8228a(this.f4847a, this.f4848b, strArr);
        try {
            new C1451b(this.f4847a, strArr, false, false).m7384c();
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
        C1607a.m8154a(this.f4847a, linkedHashMap);
    }

    protected void m7327d() {
    }
}
