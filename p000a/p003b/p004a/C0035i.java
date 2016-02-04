package p000a.p003b.p004a;

import java.util.HashMap;

/* renamed from: a.b.a.i */
public enum C0035i {
    IN(1),
    CH(3),
    HS(4),
    NONE(254),
    ANY(255);
    
    private static final HashMap<Integer, C0035i> f142f;
    private final int f144g;

    static {
        f142f = new HashMap();
        C0035i[] values = C0035i.values();
        int length = values.length;
        int i;
        while (i < length) {
            C0035i c0035i = values[i];
            f142f.put(Integer.valueOf(c0035i.m72a()), c0035i);
            i++;
        }
    }

    private C0035i(int i) {
        this.f144g = i;
    }

    public static C0035i m71a(int i) {
        return (C0035i) f142f.get(Integer.valueOf(i));
    }

    public int m72a() {
        return this.f144g;
    }
}
