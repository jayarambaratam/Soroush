package mobi.mmdt.ott.view.components.mediaselector.p206b;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.b.b */
public class C1895b extends C1894a implements Comparable<C1895b> {
    private String f6083b;
    private String f6084c;
    private String f6085d;
    private String f6086e;
    private long f6087f;

    public C1895b(int i, String str, String str2, String str3, String str4, long j) {
        super(1, i);
        this.f6083b = str;
        this.f6084c = str2;
        this.f6086e = str4;
        this.f6085d = str3;
        this.f6087f = j;
    }

    public int m9062a(C1895b c1895b) {
        return this.f6087f < c1895b.m9067e() ? 1 : this.f6087f > c1895b.m9067e() ? -1 : 0;
    }

    public String m9063a() {
        return this.f6086e;
    }

    public String m9064b() {
        return this.f6083b;
    }

    public String m9065c() {
        return this.f6084c;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m9062a((C1895b) obj);
    }

    public String m9066d() {
        return this.f6085d;
    }

    public long m9067e() {
        return this.f6087f;
    }
}
