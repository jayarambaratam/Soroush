package com.p032a.p033a.p042j;

/* renamed from: com.a.a.j.g */
public class C0878g {
    private Class<?> f3064a;
    private Class<?> f3065b;

    public C0878g(Class<?> cls, Class<?> cls2) {
        m5299a(cls, cls2);
    }

    public void m5299a(Class<?> cls, Class<?> cls2) {
        this.f3064a = cls;
        this.f3065b = cls2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0878g c0878g = (C0878g) obj;
        return !this.f3064a.equals(c0878g.f3064a) ? false : this.f3065b.equals(c0878g.f3065b);
    }

    public int hashCode() {
        return (this.f3064a.hashCode() * 31) + this.f3065b.hashCode();
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f3064a + ", second=" + this.f3065b + '}';
    }
}
