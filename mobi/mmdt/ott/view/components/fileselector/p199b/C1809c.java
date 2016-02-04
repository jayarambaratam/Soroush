package mobi.mmdt.ott.view.components.fileselector.p199b;

/* renamed from: mobi.mmdt.ott.view.components.fileselector.b.c */
public class C1809c extends C1807a {
    private String f5819b;
    private String f5820c;
    private String f5821d;

    public C1809c(String str, String str2, String str3, int i) {
        super(2, i);
        this.f5821d = str3;
        this.f5820c = str2;
        this.f5819b = str;
    }

    public String m8796a() {
        return this.f5819b;
    }

    protected int m8797b(C1807a c1807a) {
        return this.f5819b.compareToIgnoreCase(((C1809c) c1807a).m8796a());
    }

    public String m8798b() {
        return this.f5821d;
    }

    public String m8799c() {
        return this.f5820c;
    }
}
