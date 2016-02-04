package mobi.mmdt.ott.logic.p157e;

import android.content.Context;
import mobi.mmdt.componentsutils.p079a.p081b.C1108a;
import mobi.mmdt.ott.logic.p157e.p158a.C1504b;
import mobi.mmdt.ott.p109d.p111b.C1309a;

/* renamed from: mobi.mmdt.ott.logic.e.h */
public class C1519h {
    private static C1519h f5092a;
    private Context f5093b;
    private String f5094c;

    private C1519h(Context context) {
        this.f5093b = context;
        this.f5094c = C1309a.m6934a(this.f5093b).m6942b();
    }

    public static C1519h m7665a(Context context) {
        if (f5092a == null) {
            f5092a = new C1519h(context);
        }
        return f5092a;
    }

    public void m7666a(String str) {
        C1504b.m7583a(this.f5093b).m7584a(str, C1108a.m6381a(this.f5094c));
    }
}
