package android.support.v4.os;

import android.os.Build.VERSION;

/* renamed from: android.support.v4.os.c */
public final class C0262c {
    private boolean f1222a;
    private C0263d f1223b;
    private Object f1224c;
    private boolean f1225d;

    public boolean m1799a() {
        boolean z;
        synchronized (this) {
            z = this.f1222a;
        }
        return z;
    }

    public void m1800b() {
        if (m1799a()) {
            throw new C0268i();
        }
    }

    public void m1801c() {
        synchronized (this) {
            if (this.f1222a) {
                return;
            }
            this.f1222a = true;
            this.f1225d = true;
            C0263d c0263d = this.f1223b;
            Object obj = this.f1224c;
            if (c0263d != null) {
                try {
                    c0263d.m1803a();
                } catch (Throwable th) {
                    synchronized (this) {
                    }
                    this.f1225d = false;
                    notifyAll();
                }
            }
            if (obj != null) {
                C0264e.m1805a(obj);
            }
            synchronized (this) {
                this.f1225d = false;
                notifyAll();
            }
        }
    }

    public Object m1802d() {
        if (VERSION.SDK_INT < 16) {
            return null;
        }
        Object obj;
        synchronized (this) {
            if (this.f1224c == null) {
                this.f1224c = C0264e.m1804a();
                if (this.f1222a) {
                    C0264e.m1805a(this.f1224c);
                }
            }
            obj = this.f1224c;
        }
        return obj;
    }
}
