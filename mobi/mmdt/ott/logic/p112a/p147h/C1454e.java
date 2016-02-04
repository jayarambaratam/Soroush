package mobi.mmdt.ott.logic.p112a.p147h;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.LinkedHashMap;
import java.util.Map;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p157e.C1518g;
import mobi.mmdt.ott.p095c.p107c.C1291s;
import mobi.mmdt.ott.provider.p171e.C1607a;

/* renamed from: mobi.mmdt.ott.logic.a.h.e */
public class C1454e extends C0950c {
    private Context f4888a;
    private String[] f4889b;

    public C1454e(Context context, boolean z, String[] strArr) {
        super(new C0990j(C1396d.f4796b));
        this.f4888a = context;
        if (z) {
            this.f4889b = C1607a.m8162b(this.f4888a);
        } else {
            this.f4889b = strArr;
        }
    }

    protected boolean m7396a(Throwable th) {
        return false;
    }

    public void m7397b() {
    }

    public void m7398c() {
        if (this.f4889b == null) {
            throw new NullPointerException();
        } else if (!C1518g.m7654a(this.f4888a).m7663b().m7505a(true, false)) {
            throw new C1291s();
        } else if (this.f4889b.length != 0) {
            Map linkedHashMap = new LinkedHashMap();
            for (String str : this.f4889b) {
                try {
                    linkedHashMap.put(str, Long.valueOf(System.currentTimeMillis() - C1518g.m7654a(this.f4888a).m7663b().m7495a(str)));
                } catch (Throwable e) {
                    C1104b.m6368b((Object) this, e);
                } catch (Throwable e2) {
                    C1104b.m6368b((Object) this, e2);
                }
            }
            if (linkedHashMap.size() != 0) {
                C1607a.m8154a(this.f4888a, linkedHashMap);
            }
        }
    }

    protected void m7399d() {
    }
}
