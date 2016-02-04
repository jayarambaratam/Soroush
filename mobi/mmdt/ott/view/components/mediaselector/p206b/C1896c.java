package mobi.mmdt.ott.view.components.mediaselector.p206b;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.b.c */
public class C1896c extends C1894a implements Comparable<C1896c> {
    private String f6088b;
    private String f6089c;
    private String f6090d;
    private long f6091e;
    private boolean f6092f;

    public C1896c(int i, String str, String str2, String str3, long j, boolean z) {
        super(2, i);
        this.f6088b = str;
        this.f6089c = str2;
        this.f6091e = j;
        this.f6090d = str3;
        this.f6092f = z;
    }

    public int m9068a(C1896c c1896c) {
        return 0;
    }

    public String m9069a() {
        return this.f6089c;
    }

    public void m9070a(boolean z) {
        this.f6092f = z;
    }

    public String m9071b() {
        return this.f6090d;
    }

    public boolean m9072c() {
        return this.f6092f;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m9068a((C1896c) obj);
    }
}
