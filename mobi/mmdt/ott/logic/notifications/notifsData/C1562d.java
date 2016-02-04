package mobi.mmdt.ott.logic.notifications.notifsData;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: mobi.mmdt.ott.logic.notifications.notifsData.d */
public class C1562d extends C1559b {
    private ArrayList<C1564f> f5237a;
    private String f5238b;
    private String f5239c;
    private boolean f5240d;

    public C1562d(String str, String str2, String str3, boolean z) {
        super(str3);
        this.f5237a = new ArrayList();
        this.f5238b = str;
        this.f5239c = str2;
        this.f5240d = z;
    }

    public void m7868a(String str, String str2) {
        this.f5237a.add(new C1564f(str, str2));
    }

    public void m7869a(ArrayList<C1564f> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f5237a.add((C1564f) it.next());
        }
    }

    public boolean m7870a() {
        return this.f5240d;
    }

    public String m7871c() {
        return this.f5238b;
    }

    public String m7872d() {
        return this.f5239c;
    }

    public ArrayList<C1564f> m7873e() {
        return this.f5237a;
    }
}
