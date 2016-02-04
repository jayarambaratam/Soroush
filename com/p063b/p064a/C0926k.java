package com.p063b.p064a;

/* renamed from: com.b.a.k */
public class C0926k {
    public static final C0926k f3544a;
    public static final C0926k f3545b;
    public static final C0926k f3546c;
    public static final C0926k f3547d;
    public static final C0926k f3548e;
    public static final C0926k f3549f;
    public static final C0926k f3550g;
    public static final C0926k f3551h;
    public static final C0926k f3552i;
    private C0927l f3553j;
    private C0928m f3554k;

    static {
        f3544a = new C0926k(null, null);
        f3545b = new C0926k(C0927l.None, null);
        f3546c = new C0926k(C0927l.XMidYMid, C0928m.Meet);
        f3547d = new C0926k(C0927l.XMinYMin, C0928m.Meet);
        f3548e = new C0926k(C0927l.XMaxYMax, C0928m.Meet);
        f3549f = new C0926k(C0927l.XMidYMin, C0928m.Meet);
        f3550g = new C0926k(C0927l.XMidYMax, C0928m.Meet);
        f3551h = new C0926k(C0927l.XMidYMid, C0928m.Slice);
        f3552i = new C0926k(C0927l.XMinYMin, C0928m.Slice);
    }

    public C0926k(C0927l c0927l, C0928m c0928m) {
        this.f3553j = c0927l;
        this.f3554k = c0928m;
    }

    public C0927l m5786a() {
        return this.f3553j;
    }

    public C0928m m5787b() {
        return this.f3554k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0926k c0926k = (C0926k) obj;
        return this.f3553j != c0926k.f3553j ? false : this.f3554k == c0926k.f3554k;
    }
}
