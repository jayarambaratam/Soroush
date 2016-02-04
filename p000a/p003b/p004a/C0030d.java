package p000a.p003b.p004a;

/* renamed from: a.b.a.d */
public enum C0030d {
    QUERY(0),
    INVERSE_QUERY(1),
    STATUS(2),
    NOTIFY(4),
    UPDATE(5);
    
    private static final C0030d[] f107f;
    private final byte f109g;

    static {
        f107f = new C0030d[]{QUERY, INVERSE_QUERY, STATUS, null, NOTIFY, UPDATE, null, null, null, null, null, null, null, null, null};
    }

    private C0030d(int i) {
        this.f109g = (byte) i;
    }

    public static C0030d m58a(int i) {
        if (i >= 0 && i <= 15) {
            return f107f[i];
        }
        throw new IllegalArgumentException();
    }

    public byte m59a() {
        return this.f109g;
    }
}
