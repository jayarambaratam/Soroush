package p000a.p001a.p002a;

import java.lang.reflect.Method;

/* renamed from: a.a.a.n */
final class C0013n {
    final Method f57a;
    final C0016q f58b;
    final Class<?> f59c;
    String f60d;

    C0013n(Method method, C0016q c0016q, Class<?> cls) {
        this.f57a = method;
        this.f58b = c0016q;
        this.f59c = cls;
    }

    private synchronized void m25a() {
        if (this.f60d == null) {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append(this.f57a.getDeclaringClass().getName());
            stringBuilder.append('#').append(this.f57a.getName());
            stringBuilder.append('(').append(this.f59c.getName());
            this.f60d = stringBuilder.toString();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0013n)) {
            return false;
        }
        m25a();
        C0013n c0013n = (C0013n) obj;
        c0013n.m25a();
        return this.f60d.equals(c0013n.f60d);
    }

    public int hashCode() {
        return this.f57a.hashCode();
    }
}
