package mobi.mmdt.ott.logic.p157e;

import android.content.Context;
import java.util.Map;
import mobi.mmdt.ott.logic.p155b.C1487a;
import mobi.mmdt.ott.p089b.C1153a;
import mobi.mmdt.ott.p089b.C1162g;
import mobi.mmdt.ott.p089b.C1163h;
import mobi.mmdt.ott.p089b.C1164i;
import mobi.mmdt.ott.p089b.C1165j;

/* renamed from: mobi.mmdt.ott.logic.e.g */
public class C1518g implements C1164i {
    private static C1518g f5088a;
    private C1487a f5089b;
    private C1515d f5090c;
    private Context f5091d;

    private C1518g(Context context) {
        this.f5091d = context;
        this.f5089b = C1487a.m7494a(this.f5091d);
        this.f5090c = C1515d.m7645a(this.f5091d);
        this.f5089b.m7510b((C1164i) this);
    }

    public static C1518g m7654a(Context context) {
        if (f5088a == null) {
            f5088a = new C1518g(context);
        }
        return f5088a;
    }

    public void m7655a() {
        this.f5089b.m7506b();
    }

    public void m7656a(String str, String str2) {
        this.f5090c.m7647a(str, str2);
    }

    public void m7657a(String str, String str2, String str3, String str4, Map<String, String> map) {
        this.f5090c.m7648a(str, str2, str3, str4, map);
    }

    public void m7658a(String str, String str2, String str3, Map<String, String> map) {
        this.f5090c.m7649a(str, str2, str3, map);
    }

    public void m7659a(String str, String str2, C1162g c1162g) {
        this.f5090c.m7650a(str, str2, c1162g);
    }

    public void m7660a(String str, C1163h c1163h) {
        this.f5090c.m7651a(str, c1163h);
    }

    public void m7661a(C1153a c1153a) {
        this.f5089b.m7503a((C1164i) this);
        this.f5089b.m7501a(c1153a);
    }

    public void m7662a(C1165j c1165j) {
        this.f5090c.m7652a(c1165j);
    }

    public C1487a m7663b() {
        return this.f5089b;
    }

    public void m7664b(String str, String str2, C1162g c1162g) {
        this.f5090c.m7653b(str, str2, c1162g);
    }
}
