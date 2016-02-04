package mobi.mmdt.ott.logic.p124j;

import android.content.Context;
import android.net.Uri;
import com.p065c.p066a.p067a.C0950c;
import java.util.HashMap;
import java.util.Random;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p152j.C1481a;
import mobi.mmdt.ott.logic.p112a.p152j.C1482b;
import mobi.mmdt.ott.logic.p112a.p152j.C1483c;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1474a;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1475b;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1476c;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1477d;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1478e;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1480g;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p170d.C1597b;
import mobi.mmdt.ott.provider.p170d.C1598c;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.provider.p170d.C1605j;
import mobi.mmdt.ott.provider.p175i.C1635a;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.j.d */
public class C1545d {
    private static C1545d f5197a;
    private Context f5198b;
    private HashMap<Integer, C1481a> f5199c;
    private HashMap<String, Integer> f5200d;
    private HashMap<Integer, String> f5201e;
    private HashMap<Integer, C1367c> f5202f;

    private C1545d(Context context) {
        this.f5199c = new HashMap();
        this.f5200d = new HashMap();
        this.f5201e = new HashMap();
        this.f5202f = new HashMap();
        this.f5198b = context;
        C1598c.m8099a(this.f5198b, C1604i.TRANSMITTING, C1604i.ERROR);
        C1635a.m8338b(this.f5198b);
        C0002c.m2a().m14a((Object) this);
    }

    private int m7783a() {
        Random random = new Random();
        int nextInt = random.nextInt();
        while (this.f5199c.containsKey(Integer.valueOf(nextInt))) {
            nextInt = random.nextInt();
        }
        return nextInt;
    }

    private synchronized int m7784a(Uri uri, Uri uri2, boolean z) {
        int a;
        a = m7783a();
        if (uri == null || uri.getPath().isEmpty()) {
            throw new NullPointerException();
        }
        C0950c c1483c = new C1483c(this.f5198b, a, uri, uri2, z);
        this.f5199c.put(Integer.valueOf(a), c1483c);
        C1494c.m7541c(c1483c);
        return a;
    }

    private synchronized int m7785a(String str, String str2, Uri uri, boolean z, boolean z2) {
        int a;
        a = m7783a();
        if (str == null || str.isEmpty()) {
            throw new NullPointerException();
        }
        C0950c c1482b = new C1482b(this.f5198b, a, str, str2, uri, z, z2);
        this.f5199c.put(Integer.valueOf(a), c1482b);
        C1494c.m7541c(c1482b);
        return a;
    }

    public static C1545d m7786a(Context context) {
        if (f5197a == null) {
            f5197a = new C1545d(context);
        }
        return f5197a;
    }

    public int m7787a(long j, boolean z, C1367c c1367c) {
        int a;
        C1597b a2 = C1598c.m8102a(this.f5198b, j);
        if (z) {
            a = m7785a(a2.m8091i(), a2.m8083a(), a2.m8089g(), false, true);
            this.f5201e.put(Integer.valueOf(a), "T_" + j);
            this.f5200d.put("T_" + j, Integer.valueOf(a));
            if (c1367c != null) {
                this.f5202f.put(Integer.valueOf(a), c1367c);
            }
        } else {
            a = m7785a(a2.m8090h(), a2.m8083a(), a2.m8088f(), false, false);
            this.f5201e.put(Integer.valueOf(a), "R_" + j);
            this.f5200d.put("R_" + j, Integer.valueOf(a));
            if (c1367c != null) {
                this.f5202f.put(Integer.valueOf(a), c1367c);
            }
        }
        return a;
    }

    public int m7788a(String str, Uri uri, String str2, C1367c c1367c) {
        int a = m7785a(str, str2, uri, true, false);
        if (c1367c != null) {
            this.f5202f.put(Integer.valueOf(a), c1367c);
        }
        return a;
    }

    public int m7789a(boolean z, Uri uri, Uri uri2, C1367c c1367c) {
        int a = m7784a(uri, uri2, z);
        if (c1367c != null) {
            this.f5202f.put(Integer.valueOf(a), c1367c);
        }
        return a;
    }

    public void m7790a(int i) {
        if (this.f5199c.containsKey(Integer.valueOf(i))) {
            ((C1481a) this.f5199c.get(Integer.valueOf(i))).m7482j();
        }
    }

    public void m7791a(long j) {
        String str = "T_" + j;
        if (this.f5200d.containsKey(str) && this.f5199c.containsKey(this.f5200d.get(str))) {
            ((C1481a) this.f5199c.get(this.f5200d.get(str))).m7482j();
        }
        str = "R_" + j;
        if (this.f5200d.containsKey(str) && this.f5199c.containsKey(this.f5200d.get(str))) {
            ((C1481a) this.f5199c.get(this.f5200d.get(str))).m7482j();
        }
    }

    public int m7792b(long j, boolean z, C1367c c1367c) {
        C1597b a = C1598c.m8102a(this.f5198b, j);
        int a2 = m7784a(a.m8088f(), a.m8089g(), z);
        this.f5201e.put(Integer.valueOf(a2), "R_" + j);
        this.f5200d.put("R_" + j, Integer.valueOf(a2));
        if (c1367c != null) {
            this.f5202f.put(Integer.valueOf(a2), c1367c);
        }
        return a2;
    }

    public void onEvent(C1474a c1474a) {
        if (this.f5201e.containsKey(Integer.valueOf(c1474a.m7463a()))) {
            long parseLong = Long.parseLong(((String) this.f5201e.get(Integer.valueOf(c1474a.m7463a()))).split("_")[1]);
            if (c1474a.m7464b()) {
                C1598c.m8104b(this.f5198b, parseLong, C1604i.CANCEL);
            } else {
                C1598c.m8095a(this.f5198b, parseLong, C1604i.CANCEL);
                if (c1474a.m7464b()) {
                    C1598c.m8092a(this.f5198b, parseLong, 0);
                }
            }
        }
        if (this.f5202f.containsKey(Integer.valueOf(c1474a.m7463a()))) {
            ((C1367c) this.f5202f.get(Integer.valueOf(c1474a.m7463a()))).m7096b(c1474a.m7463a());
        }
    }

    public void onEvent(C1475b c1475b) {
        if (this.f5201e.containsKey(Integer.valueOf(c1475b.m7465a()))) {
            long parseLong = Long.parseLong(((String) this.f5201e.get(Integer.valueOf(c1475b.m7465a()))).split("_")[1]);
            if (c1475b.m7466b()) {
                C1598c.m8104b(this.f5198b, parseLong, C1604i.FINISHED);
            } else {
                C1598c.m8095a(this.f5198b, parseLong, C1604i.FINISHED);
            }
            if (C1309a.m6934a(this.f5198b).m6981x()) {
                C1597b a = C1598c.m8102a(this.f5198b, parseLong);
                if (a.m8085c().equals(C1605j.IMAGE) || a.m8085c().equals(C1605j.VIDEO)) {
                    C1490b.m7516a(this.f5198b).m7522a(a.m8088f());
                }
            }
        }
        if (this.f5202f.containsKey(Integer.valueOf(c1475b.m7465a()))) {
            ((C1367c) this.f5202f.get(Integer.valueOf(c1475b.m7465a()))).m7097c(c1475b.m7465a());
        }
    }

    public void onEvent(C1476c c1476c) {
        if (this.f5201e.containsKey(Integer.valueOf(c1476c.m7468b()))) {
            long parseLong = Long.parseLong(((String) this.f5201e.get(Integer.valueOf(c1476c.m7468b()))).split("_")[1]);
            if (c1476c.m7469c()) {
                C1598c.m8104b(this.f5198b, parseLong, C1604i.ERROR);
            } else {
                C1598c.m8095a(this.f5198b, parseLong, C1604i.ERROR);
                if (c1476c.m7469c()) {
                    C1598c.m8092a(this.f5198b, parseLong, 0);
                }
            }
        }
        if (this.f5202f.containsKey(Integer.valueOf(c1476c.m7468b()))) {
            ((C1367c) this.f5202f.get(Integer.valueOf(c1476c.m7468b()))).m7094a(c1476c.m7468b(), c1476c.m7467a());
        }
    }

    public void onEvent(C1477d c1477d) {
        if (this.f5201e.containsKey(Integer.valueOf(c1477d.m7470a()))) {
            long parseLong = Long.parseLong(((String) this.f5201e.get(Integer.valueOf(c1477d.m7470a()))).split("_")[1]);
            if (c1477d.m7472c()) {
                C1598c.m8104b(this.f5198b, parseLong, C1604i.TRANSMITTING);
            } else {
                C1598c.m8095a(this.f5198b, parseLong, C1604i.TRANSMITTING);
                if (!c1477d.m7472c()) {
                    C1598c.m8092a(this.f5198b, parseLong, c1477d.m7471b());
                }
            }
        }
        if (this.f5202f.containsKey(Integer.valueOf(c1477d.m7470a()))) {
            ((C1367c) this.f5202f.get(Integer.valueOf(c1477d.m7470a()))).m7093a(c1477d.m7470a(), c1477d.m7471b());
        }
    }

    public void onEvent(C1478e c1478e) {
        if (this.f5201e.containsKey(Integer.valueOf(c1478e.m7473a()))) {
            long parseLong = Long.parseLong(((String) this.f5201e.get(Integer.valueOf(c1478e.m7473a()))).split("_")[1]);
            if (c1478e.m7474b()) {
                C1598c.m8104b(this.f5198b, parseLong, C1604i.TRANSMITTING);
            } else {
                C1598c.m8095a(this.f5198b, parseLong, C1604i.TRANSMITTING);
            }
        }
        if (this.f5202f.containsKey(Integer.valueOf(c1478e.m7473a()))) {
            ((C1367c) this.f5202f.get(Integer.valueOf(c1478e.m7473a()))).m7092a(c1478e.m7473a());
        }
    }

    public void onEvent(C1480g c1480g) {
        if (this.f5201e.containsKey(Integer.valueOf(c1480g.m7478d()))) {
            long parseLong = Long.parseLong(((String) this.f5201e.get(Integer.valueOf(c1480g.m7478d()))).split("_")[1]);
            C1598c.m8095a(this.f5198b, parseLong, C1604i.FINISHED);
            C1598c.m8092a(this.f5198b, parseLong, 100);
            C1598c.m8093a(this.f5198b, parseLong, c1480g.m7477c(), c1480g.m7476b(), c1480g.m7475a());
        }
        if (this.f5202f.containsKey(Integer.valueOf(c1480g.m7478d()))) {
            ((C1367c) this.f5202f.get(Integer.valueOf(c1480g.m7478d()))).m7095a(c1480g.m7478d(), c1480g.m7477c(), c1480g.m7476b(), c1480g.m7475a());
        }
    }
}
