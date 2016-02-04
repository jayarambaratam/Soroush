package mobi.mmdt.ott.logic.notifications.notifsData;

import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: mobi.mmdt.ott.logic.notifications.notifsData.c */
public class C1561c extends C1559b {
    private ArrayList<C1564f> f5233a;
    private String f5234b;
    private String f5235c;
    private boolean f5236d;

    public C1561c(String str, String str2, String str3, boolean z) {
        super(str3);
        this.f5233a = new ArrayList();
        this.f5234b = str;
        this.f5235c = str2;
        this.f5236d = z;
    }

    public void m7862a(String str, String str2) {
        this.f5233a.add(new C1564f(str, str2));
    }

    public void m7863a(ArrayList<C1564f> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f5233a.add((C1564f) it.next());
        }
    }

    public boolean m7864a() {
        return this.f5236d;
    }

    public String m7865c() {
        return this.f5234b;
    }

    public String m7866d() {
        return this.f5235c;
    }

    public ArrayList<C1564f> m7867e() {
        return this.f5233a;
    }
}
