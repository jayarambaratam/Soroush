package mobi.mmdt.ott.view.components.fileselector.p199b;

/* renamed from: mobi.mmdt.ott.view.components.fileselector.b.b */
public class C1808b extends C1807a {
    private String f5814b;
    private String f5815c;
    private String f5816d;
    private boolean f5817e;
    private int f5818f;

    public C1808b(String str, String str2, String str3, int i, boolean z, int i2) {
        super(1, i2);
        this.f5816d = str3;
        this.f5815c = str2;
        this.f5814b = str;
        this.f5817e = z;
        this.f5818f = i;
    }

    public String m8789a() {
        return this.f5814b;
    }

    public void m8790a(boolean z) {
        this.f5817e = z;
    }

    protected int m8791b(C1807a c1807a) {
        return this.f5814b.compareToIgnoreCase(((C1808b) c1807a).m8789a());
    }

    public String m8792b() {
        return this.f5816d;
    }

    public String m8793c() {
        return this.f5815c;
    }

    public boolean m8794d() {
        return this.f5817e;
    }

    public int m8795e() {
        return this.f5818f;
    }
}
