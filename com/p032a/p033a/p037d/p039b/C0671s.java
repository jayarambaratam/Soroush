package com.p032a.p033a.p037d.p039b;

import android.os.Looper;
import com.p032a.p033a.p037d.C0667c;

/* renamed from: com.a.a.d.b.s */
class C0671s<Z> implements C0670y<Z> {
    private final C0670y<Z> f2682a;
    private final boolean f2683b;
    private C0654t f2684c;
    private C0667c f2685d;
    private int f2686e;
    private boolean f2687f;

    C0671s(C0670y<Z> c0670y, boolean z) {
        if (c0670y == null) {
            throw new NullPointerException("Wrapped resource must not be null");
        }
        this.f2682a = c0670y;
        this.f2683b = z;
    }

    void m4681a(C0667c c0667c, C0654t c0654t) {
        this.f2685d = c0667c;
        this.f2684c = c0654t;
    }

    boolean m4682a() {
        return this.f2683b;
    }

    public Z m4683b() {
        return this.f2682a.m4678b();
    }

    public int m4684c() {
        return this.f2682a.m4679c();
    }

    public void m4685d() {
        if (this.f2686e > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (this.f2687f) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        } else {
            this.f2687f = true;
            this.f2682a.m4680d();
        }
    }

    void m4686e() {
        if (this.f2687f) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.f2686e++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    void m4687f() {
        if (this.f2686e <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i = this.f2686e - 1;
            this.f2686e = i;
            if (i == 0) {
                this.f2684c.m4641b(this.f2685d, this);
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }
}
