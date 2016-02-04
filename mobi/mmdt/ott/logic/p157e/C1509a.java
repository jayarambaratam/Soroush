package mobi.mmdt.ott.logic.p157e;

import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
import mobi.mmdt.ott.C1318i;
import mobi.mmdt.ott.p109d.p110a.C1306b;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p170d.C1596a;

/* renamed from: mobi.mmdt.ott.logic.e.a */
public class C1509a {
    private static C1509a f5070a;
    private static ArrayList<C1306b> f5071b;
    private static ArrayList<C1306b> f5072c;
    private static ArrayList<C1596a> f5073d;
    private ArrayList<Map<String, String>> f5074e;
    private Context f5075f;
    private C1318i f5076g;

    static {
        f5071b = new ArrayList();
        f5072c = new ArrayList();
        f5073d = new ArrayList();
    }

    private C1509a(Context context) {
        this.f5074e = new ArrayList();
        this.f5075f = context;
        this.f5076g = new C1318i(1000);
    }

    public static C1509a m7621a(Context context) {
        if (f5070a == null) {
            f5070a = new C1509a(context);
        }
        return f5070a;
    }

    private void m7625d() {
        this.f5076g.m6992a(new C1513b(this));
    }

    public void m7626a(C1306b c1306b, C1596a c1596a, Map<String, String> map) {
        if (!C1583c.m7972a(this.f5075f, c1306b.m6898a(), c1306b.m6900b())) {
            if (c1596a != null) {
                if (!f5072c.contains(c1306b)) {
                    f5072c.add(c1306b);
                    f5073d.add(c1596a);
                    this.f5074e.add(map);
                }
            } else if (!f5071b.contains(c1306b)) {
                f5071b.add(c1306b);
            }
        }
        m7625d();
    }
}
