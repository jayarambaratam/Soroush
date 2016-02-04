package mobi.mmdt.ott.logic.notifications.notifsData;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: mobi.mmdt.ott.logic.notifications.notifsData.g */
public class C1565g extends C1559b {
    private ArrayList<C1564f> f5244a;
    private String f5245b;
    private String f5246c;
    private boolean f5247d;

    public C1565g(String str, String str2, String str3, boolean z) {
        super(str3);
        this.f5244a = new ArrayList();
        this.f5245b = str;
        this.f5246c = str2;
        this.f5247d = z;
    }

    public String m7876a() {
        return this.f5245b;
    }

    public void m7877a(String str) {
        this.f5244a.add(new C1564f(this.f5246c, str));
    }

    public void m7878a(ArrayList<C1564f> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f5244a.add((C1564f) it.next());
        }
    }

    public String m7879c() {
        return this.f5246c;
    }

    public ArrayList<C1564f> m7880d() {
        return this.f5244a;
    }
}
