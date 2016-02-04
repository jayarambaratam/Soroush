package p000a.p003b.p004a;

/* renamed from: a.b.a.e */
public enum C0031e {
    NO_ERROR(0),
    FORMAT_ERR(1),
    SERVER_FAIL(2),
    NX_DOMAIN(3),
    NO_IMP(4),
    REFUSED(5),
    YXDOMAIN(6),
    YXRRSET(7),
    NXRRSET(8),
    NOT_AUTH(9),
    NOT_ZONE(10);
    
    private static final C0031e[] f121l;
    private final byte f123m;

    static {
        f121l = new C0031e[]{NO_ERROR, FORMAT_ERR, SERVER_FAIL, NX_DOMAIN, NO_IMP, REFUSED, YXDOMAIN, YXRRSET, NXRRSET, NOT_AUTH, NOT_ZONE, null, null, null, null, null};
    }

    private C0031e(int i) {
        this.f123m = (byte) i;
    }

    public static C0031e m60a(int i) {
        if (i >= 0 && i <= 15) {
            return f121l[i];
        }
        throw new IllegalArgumentException();
    }

    public byte m61a() {
        return this.f123m;
    }
}
