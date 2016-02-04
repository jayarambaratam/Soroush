package com.p032a.p033a.p037d.p039b;

import android.util.Log;
import com.p032a.p033a.C0883l;
import com.p032a.p033a.p037d.C0667c;
import com.p032a.p033a.p037d.C0730g;
import com.p032a.p033a.p037d.p038a.C0586c;
import com.p032a.p033a.p037d.p049d.p058f.C0802c;
import com.p032a.p033a.p042j.C0876d;
import com.p032a.p033a.p051g.C0737b;
import java.io.File;

/* renamed from: com.a.a.d.b.a */
class C0617a<A, T, Z> {
    private static final C0649c f2571a;
    private final C0668q f2572b;
    private final int f2573c;
    private final int f2574d;
    private final C0586c<A> f2575e;
    private final C0737b<A, T> f2576f;
    private final C0730g<T> f2577g;
    private final C0802c<T, Z> f2578h;
    private final C0639b f2579i;
    private final C0652e f2580j;
    private final C0883l f2581k;
    private final C0649c f2582l;
    private volatile boolean f2583m;

    static {
        f2571a = new C0649c();
    }

    public C0617a(C0668q c0668q, int i, int i2, C0586c<A> c0586c, C0737b<A, T> c0737b, C0730g<T> c0730g, C0802c<T, Z> c0802c, C0639b c0639b, C0652e c0652e, C0883l c0883l) {
        this(c0668q, i, i2, c0586c, c0737b, c0730g, c0802c, c0639b, c0652e, c0883l, f2571a);
    }

    C0617a(C0668q c0668q, int i, int i2, C0586c<A> c0586c, C0737b<A, T> c0737b, C0730g<T> c0730g, C0802c<T, Z> c0802c, C0639b c0639b, C0652e c0652e, C0883l c0883l, C0649c c0649c) {
        this.f2572b = c0668q;
        this.f2573c = i;
        this.f2574d = i2;
        this.f2575e = c0586c;
        this.f2576f = c0737b;
        this.f2577g = c0730g;
        this.f2578h = c0802c;
        this.f2579i = c0639b;
        this.f2580j = c0652e;
        this.f2581k = c0883l;
        this.f2582l = c0649c;
    }

    private C0670y<Z> m4563a(C0670y<T> c0670y) {
        long a = C0876d.m5296a();
        C0670y c = m4569c(c0670y);
        if (Log.isLoggable("DecodeJob", 2)) {
            m4566a("Transformed resource from source", a);
        }
        m4568b(c);
        a = C0876d.m5296a();
        C0670y<Z> d = m4570d(c);
        if (Log.isLoggable("DecodeJob", 2)) {
            m4566a("Transcoded transformed from source", a);
        }
        return d;
    }

    private C0670y<T> m4564a(C0667c c0667c) {
        C0670y<T> c0670y = null;
        File a = this.f2579i.m4629a().m4576a(c0667c);
        if (a != null) {
            try {
                c0670y = this.f2576f.m4826a().m4834a(a, this.f2573c, this.f2574d);
                if (c0670y == null) {
                    this.f2579i.m4629a().m4578b(c0667c);
                }
            } catch (Throwable th) {
                if (c0670y == null) {
                    this.f2579i.m4629a().m4578b(c0667c);
                }
            }
        }
        return c0670y;
    }

    private C0670y<T> m4565a(A a) {
        if (this.f2580j.m4637a()) {
            return m4567b((Object) a);
        }
        long a2 = C0876d.m5296a();
        C0670y<T> a3 = this.f2576f.m4827b().m4834a(a, this.f2573c, this.f2574d);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return a3;
        }
        m4566a("Decoded from source", a2);
        return a3;
    }

    private void m4566a(String str, long j) {
        Log.v("DecodeJob", str + " in " + C0876d.m5295a(j) + ", key: " + this.f2572b);
    }

    private C0670y<T> m4567b(A a) {
        long a2 = C0876d.m5296a();
        this.f2579i.m4629a().m4577a(this.f2572b.m4675a(), new C0651d(this, this.f2576f.m4828c(), a));
        if (Log.isLoggable("DecodeJob", 2)) {
            m4566a("Wrote source to cache", a2);
        }
        a2 = C0876d.m5296a();
        C0670y<T> a3 = m4564a(this.f2572b.m4675a());
        if (Log.isLoggable("DecodeJob", 2) && a3 != null) {
            m4566a("Decoded source from cache", a2);
        }
        return a3;
    }

    private void m4568b(C0670y<T> c0670y) {
        if (c0670y != null && this.f2580j.m4638b()) {
            long a = C0876d.m5296a();
            this.f2579i.m4629a().m4577a(this.f2572b, new C0651d(this, this.f2576f.m4829d(), c0670y));
            if (Log.isLoggable("DecodeJob", 2)) {
                m4566a("Wrote transformed from source to cache", a);
            }
        }
    }

    private C0670y<T> m4569c(C0670y<T> c0670y) {
        if (c0670y == null) {
            return null;
        }
        C0670y<T> a = this.f2577g.m4802a(c0670y, this.f2573c, this.f2574d);
        if (c0670y.equals(a)) {
            return a;
        }
        c0670y.m4680d();
        return a;
    }

    private C0670y<Z> m4570d(C0670y<T> c0670y) {
        return c0670y == null ? null : this.f2578h.m5033a(c0670y);
    }

    private C0670y<T> m4571e() {
        try {
            long a = C0876d.m5296a();
            Object a2 = this.f2575e.m4438a(this.f2581k);
            if (Log.isLoggable("DecodeJob", 2)) {
                m4566a("Fetched data", a);
            }
            if (this.f2583m) {
                return null;
            }
            C0670y<T> a3 = m4565a(a2);
            this.f2575e.m4439a();
            return a3;
        } finally {
            this.f2575e.m4439a();
        }
    }

    public C0670y<Z> m4572a() {
        if (!this.f2580j.m4638b()) {
            return null;
        }
        long a = C0876d.m5296a();
        C0670y a2 = m4564a(this.f2572b);
        if (Log.isLoggable("DecodeJob", 2)) {
            m4566a("Decoded transformed from cache", a);
        }
        long a3 = C0876d.m5296a();
        C0670y<Z> d = m4570d(a2);
        if (!Log.isLoggable("DecodeJob", 2)) {
            return d;
        }
        m4566a("Transcoded transformed from cache", a3);
        return d;
    }

    public C0670y<Z> m4573b() {
        if (!this.f2580j.m4637a()) {
            return null;
        }
        long a = C0876d.m5296a();
        C0670y a2 = m4564a(this.f2572b.m4675a());
        if (Log.isLoggable("DecodeJob", 2)) {
            m4566a("Decoded source from cache", a);
        }
        return m4563a(a2);
    }

    public C0670y<Z> m4574c() {
        return m4563a(m4571e());
    }

    public void m4575d() {
        this.f2583m = true;
        this.f2575e.m4441c();
    }
}
