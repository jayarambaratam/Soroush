package mobi.mmdt.ott.view.conversation.p222d;

import mobi.mmdt.ott.view.components.p181b.C1722f;

/* renamed from: mobi.mmdt.ott.view.conversation.d.a */
public abstract class C2151a extends C1722f {
    private String f7015b;
    private String f7016c;
    private boolean f7017d;
    private boolean f7018e;
    private boolean f7019f;
    private long f7020g;

    public C2151a(int i, int i2, String str, long j, String str2, boolean z, boolean z2, boolean z3) {
        super(i, i2);
        this.f7015b = str2;
        this.f7017d = z;
        this.f7018e = z2;
        this.f7019f = z3;
        this.f7020g = j;
        this.f7016c = str;
    }

    public boolean m9839a() {
        return m8659g() % 10 == 1;
    }

    public String m9840b() {
        return this.f7015b;
    }

    public boolean m9841c() {
        return this.f7017d;
    }

    public boolean m9842d() {
        return this.f7018e;
    }

    public boolean m9843e() {
        return this.f7019f;
    }

    public String m9844f() {
        return this.f7016c;
    }
}
